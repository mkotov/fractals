#include "MKL.h"
#include <mkl_cblas.h>
#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT void JNICALL Java_MKL_affineTransform (JNIEnv *env, jclass cl, jint n, jfloatArray jxs, jfloatArray jys, jfloat a, jfloat b, jfloat c, jfloat d, jfloat e, jfloat f) {
	jfloat *xs = (*env)->GetFloatArrayElements(env, jxs, NULL);
    	jfloat *ys = (*env)->GetFloatArrayElements(env, jys, NULL);

	float p[] = {-1, a, b, c, d};
	cblas_srotm(n, xs, 1, ys, 1, p);
	cblas_saxpy(n, 1, &e, 0, xs, 1);
	cblas_saxpy(n, 1, &f, 0, ys, 1);
	(*env)->ReleaseFloatArrayElements(env, jxs, xs, 0);
	(*env)->ReleaseFloatArrayElements(env, jys, ys, 0);
}


unsigned ipow(unsigned m, unsigned n) {
	unsigned r = 1;
	unsigned i;
	for (i = 0; i < n; ++i) {
		r *= m;
	}
	return r;
} 

JNIEXPORT jobject JNICALL Java_MKL_apply(JNIEnv *env, jclass cl, jint n, jobjectArray jts) {
	int m = (*env)->GetArrayLength(env, jts);
	float **p = (float **)malloc(m * sizeof (float *));
	
	jclass classTransform = (*env)->FindClass(env, "Transform");
	jfieldID idA = (*env)->GetFieldID(env, classTransform, "a", "F");
	jfieldID idB = (*env)->GetFieldID(env, classTransform, "b", "F");
	jfieldID idC = (*env)->GetFieldID(env, classTransform, "c", "F");
	jfieldID idD = (*env)->GetFieldID(env, classTransform, "d", "F");
	jfieldID idE = (*env)->GetFieldID(env, classTransform, "e", "F");
	jfieldID idF = (*env)->GetFieldID(env, classTransform, "f", "F");	

	int i;
	jobject t;
	for (i = 0; i < m; ++i) {
		t = (*env)->GetObjectArrayElement(env, jts, i);
		p[i] = (float *)malloc(7 * sizeof (float));
		p[i][0] = -1;
		p[i][1] = (*env)->GetFloatField(env, t, idA);
		p[i][2] = (*env)->GetFloatField(env, t, idB);
		p[i][3] = (*env)->GetFloatField(env, t, idC);
		p[i][4] = (*env)->GetFloatField(env, t, idD);
		p[i][5] = (*env)->GetFloatField(env, t, idE);
		p[i][6] = (*env)->GetFloatField(env, t, idF);
	}

	int k = ipow(m, n);
	jfloatArray jxs = (*env)->NewFloatArray(env, k);
	jfloatArray jys = (*env)->NewFloatArray(env, k);


        jfloat *xs = (*env)->GetFloatArrayElements(env, jxs, NULL);
        jfloat *ys = (*env)->GetFloatArrayElements(env, jys, NULL);
	xs[0] = 0;
	ys[0] = 0;

	int j;
	int w;
	for (i = 0; i < n; ++i) {
		w = ipow(m, i);
		for (j = 1; j < m; ++j) {
			cblas_scopy(w, xs, 1, xs + w * j, 1);
			cblas_scopy(w, ys, 1, ys + w * j, 1);
		}		
		for (j = 0; j < m; ++j) {
			cblas_srotm(w, xs + w * j, 1, ys + w * j, 1, p[j]);
			cblas_saxpy(w, 1, &(p[j][5]), 0, xs + w * j, 1);
			cblas_saxpy(w, 1, &(p[j][6]), 0, ys + w * j, 1);
		}
	}

	for (i = 0; i < m; ++i) {
		free(p[i]);
	}
	free(p);
	(*env)->ReleaseFloatArrayElements(env, jxs, xs, 0);
	(*env)->ReleaseFloatArrayElements(env, jys, ys, 0);
	jclass classPoints = (*env)->FindClass(env, "Points");
	jmethodID idConstructorPoints = (*env)->GetMethodID(env, classPoints, "<init>", "([F[F)V");
	jobject ps = (*env)->NewObject(env, classPoints, idConstructorPoints, jxs, jys);
	return ps;
}

