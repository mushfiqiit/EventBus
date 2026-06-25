package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.greenrobot.eventbus.meta.SubscriberInfo;

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
    }
}
