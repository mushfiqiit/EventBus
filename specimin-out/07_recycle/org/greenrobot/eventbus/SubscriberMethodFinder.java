package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
class SubscriberMethodFinder {

    static class FindState {

        final List<SubscriberMethod> subscriberMethods;

        final Map<Class, Object> anyMethodByEventType;

        final Map<String, Class> subscriberClassByMethodKey;

        final StringBuilder methodKeyBuilder;

        @Nullable
        Class<?> subscriberClass;

        Class<?> clazz;

        boolean skipSuperClasses;

        @Nullable
        SubscriberInfo subscriberInfo;

        void recycle() {
            subscriberMethods.clear();
            anyMethodByEventType.clear();
            subscriberClassByMethodKey.clear();
            methodKeyBuilder.setLength(0);
            subscriberClass = null;
            clazz = null;
            skipSuperClasses = false;
            subscriberInfo = null;
        }
    }
}
