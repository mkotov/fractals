/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class MKL */

#ifndef _Included_MKL
#define _Included_MKL
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     MKL
 * Method:    affineTransform
 * Signature: (I[F[FFFFFFF)V
 */
JNIEXPORT void JNICALL Java_MKL_affineTransform
  (JNIEnv *, jclass, jint, jfloatArray, jfloatArray, jfloat, jfloat, jfloat, jfloat, jfloat, jfloat);

/*
 * Class:     MKL
 * Method:    apply
 * Signature: (I[LTransform;)LPoints;
 */
JNIEXPORT jobject JNICALL Java_MKL_apply
  (JNIEnv *, jclass, jint, jobjectArray);

#ifdef __cplusplus
}
#endif
#endif