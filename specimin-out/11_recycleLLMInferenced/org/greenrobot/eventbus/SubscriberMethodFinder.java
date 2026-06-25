package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;

class SubscriberMethodFinder {

    static class FindState {

        final @Nonnull List<SubscriberMethod> subscriberMethods;

        final @Nonnull Map<Class, Object> anyMethodByEventType;

        final @Nonnull Map<String, Class> subscriberClassByMethodKey;

        final @Nonnull StringBuilder methodKeyBuilder;

        @Nullable Class<?> subscriberClass;

        @Nullable Class<?> clazz;

        boolean skipSuperClasses;

        @Nullable SubscriberInfo subscriberInfo;

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
