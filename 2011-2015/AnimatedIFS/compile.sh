#!/bin/bash

#javac MKL.java
#javah MKL

icc -O3 MKL.c -o libMKL.so -shared -fPIC -I"/usr/lib/jvm/java-6-openjdk/include" -L"/opt/intel/composerxe-2011.1.107/mkl" -L"/opt/intel/mkl/lib/ia32" -Wl,--start-group $MKLROOT/lib/ia32/libmkl_intel.a $MKLROOT/lib/ia32/libmkl_intel_thread.a $MKLROOT/lib/ia32/libmkl_core.a -Wl,--end-group -openmp
