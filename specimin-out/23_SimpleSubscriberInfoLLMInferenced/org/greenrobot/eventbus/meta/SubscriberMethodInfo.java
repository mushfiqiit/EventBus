package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo {

    @Nonnull
    public final String methodName;

    @Nonnull
    public final ThreadMode threadMode;

    @Nonnull
    public final Class<?> eventType;

    public final int priority = 0;

    public final boolean sticky = false;

    public SubscriberMethodInfo(@Nonnull String methodName, @Nonnull ThreadMode threadMode, @Nonnull Class<?> eventType) {
        this.methodName = methodName;
        this.threadMode = threadMode;
        this.eventType = eventType;
    }
}
