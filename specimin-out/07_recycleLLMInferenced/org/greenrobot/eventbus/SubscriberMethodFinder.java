package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

class SubscriberMethodFinder {

    static class FindState {

        @Nullable
        final List<SubscriberMethod> subscriberMethods;

        @Nullable
        final Map<Class, Object> anyMethodByEventType;

        @Nullable
        final Map<String, Class> subscriberClassByMethodKey;

        @Nullable
        final StringBuilder methodKeyBuilder;

        @Nullable
        Class<?> subscriberClass;

        @Nullable
        Class<?> clazz;

        boolean skipSuperClasses;

        @Nullable
        SubscriberInfo subscriberInfo;

        public FindState() {
            this.subscriberMethods = new java.util.ArrayList<>();
            this.anyMethodByEventType = new java.util.HashMap<>();
            this.subscriberClassByMethodKey = new java.util.HashMap<>();
            this.methodKeyBuilder = new StringBuilder();
        }

        void recycle() {
            if (subscriberMethods != null) {
                subscriberMethods.clear();
            }
            if (anyMethodByEventType != null) {
                anyMethodByEventType.clear();
            }
            if (subscriberClassByMethodKey != null) {
                subscriberClassByMethodKey.clear();
            }
            if (methodKeyBuilder != null) {
                methodKeyBuilder.setLength(0);
            }
            subscriberClass = null;
            clazz = null;
            skipSuperClasses = false;
            subscriberInfo = null;
        }
    }
}
