LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := rdesktop.c \
                   bitmap.c \
                   pstcache.c \
                   cache.c \
                   tcp.c \
                   iso.c \
                   mcs.c \
                   ssl.c \
                   licence.c \
                   orders.c \
                   mppc.c \
                   rdp5.c \
                   rdp.c \
                   secure.c \
                   channels.c \
                   
LOCAL_SHARED_LIBRARIES := \
			libssl \
			libcrypto
LOCAL_C_INCLUDES := \
	$(NDK_PROJECT_PATH) \
	$(NDK_PROJECT_PATH)/include
	
LOCAL_MODULE := freerdp

LOCAL_CFLAGS := -DMONOLITH
          
include $(BUILD_SHARED_LIBRARY)
