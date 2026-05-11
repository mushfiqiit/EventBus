package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
class SubscriberMethodFinder {

    static class FindState {

        @Nullable
        List<SubscriberMethod> subscriberMethods = null;

        @Nullable
        Map<Class, Object> anyMethodByEventType = null;

        @Nullable
        Map<String, Class> subscriberClassByMethodKey = null;

        @Nullable
        StringBuilder methodKeyBuilder = null;

        @Nullable
        Class<?> subscriberClass;

        @Nullable
        Class<?> clazz;

        @javax.annotation.Nonnull
        boolean skipSuperClasses;

        @Nullable
        SubscriberInfo subscriberInfo;

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
