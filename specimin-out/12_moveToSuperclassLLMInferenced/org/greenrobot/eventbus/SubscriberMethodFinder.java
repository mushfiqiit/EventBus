package org.greenrobot.eventbus;

import javax.annotation.Nullable;

class SubscriberMethodFinder {

    static class FindState {

        @Nullable
        Class<?> clazz;

        boolean skipSuperClasses;

        void moveToSuperclass() {
            if (skipSuperClasses) {
                clazz = null;
            } else {
                clazz = clazz != null ? clazz.getSuperclass() : null;
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
