package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

class SubscriberMethodFinder {

    static class FindState {

        @Nonnull
        Class<?> subscriberClass;

        @Nonnull
        Class<?> clazz;

        boolean skipSuperClasses;

        @Nullable
        SubscriberInfo subscriberInfo;

        void initForSubscriber(@Nonnull Class<?> subscriberClass) {
            this.subscriberClass = clazz = subscriberClass;
            skipSuperClasses = false;
            subscriberInfo = null;
        }

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
