package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import javax.annotation.Nullable;

class SubscriberMethodFinder {

    static class FindState {

        @Nullable
        Class<?> clazz;

        /* @Nonnull */ 
        boolean skipSuperClasses;

        void moveToSuperclass() {
            if (skipSuperClasses) {
                clazz = null;
            } else {
                clazz = clazz.getSuperclass();
                if (clazz != null) {
                    String clazzName = clazz.getName();
                    if (clazzName.startsWith("java.") || clazzName.startsWith("javax.") || clazzName.startsWith("android.") || clazzName.startsWith("androidx.")) {
                        clazz = null;
                    }
                }
            }
        }
    }
}
