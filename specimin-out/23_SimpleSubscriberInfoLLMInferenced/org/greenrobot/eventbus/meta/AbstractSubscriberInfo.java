package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    protected AbstractSubscriberInfo(@Nonnull Class subscriberClass, @Nullable Class<? extends SubscriberInfo> superSubscriberInfoClass, boolean shouldCheckSuperclass) {
        throw new java.lang.Error();
    }

    @Nonnull
    protected SubscriberMethod createSubscriberMethod(@Nonnull String methodName, @Nonnull Class<?> eventType, @Nonnull ThreadMode threadMode, int priority, boolean sticky) {
        throw new java.lang.Error();
    }
}
