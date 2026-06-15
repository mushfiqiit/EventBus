package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class SubscriberMethodFinder {

    static class FindState {

        @Nonnull
        final List<SubscriberMethod> subscriberMethods;

        @Nonnull
        final Map<Class, Object> anyMethodByEventType;

        @Nonnull
        final Map<String, Class> subscriberClassByMethodKey;

        @Nonnull
        final StringBuilder methodKeyBuilder;

        @Nullable
        Class<?> subscriberClass;

        @Nullable
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
