package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;

class SubscriberMethodFinder {

    static class FindState {

        final List<SubscriberMethod> subscriberMethods = null;

        final Map<Class, Object> anyMethodByEventType = null;

        final Map<String, Class> subscriberClassByMethodKey = null;

        final StringBuilder methodKeyBuilder = null;

        Class<?> subscriberClass;

        Class<?> clazz;

        boolean skipSuperClasses;

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
