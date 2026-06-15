package org.greenrobot.eventbus;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.lang.reflect.Method;

public class SubscriberMethod {

    final @Nonnull Method method;

    final @Nonnull ThreadMode threadMode;

    final @Nonnull Class<?> eventType;

    final int priority;

    final boolean sticky;

    @Nullable
    String methodString;

    public SubscriberMethod(@Nonnull Method method, @Nonnull Class<?> eventType, @Nonnull ThreadMode threadMode, int priority, boolean sticky) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
        this.priority = priority;
        this.sticky = sticky;
    }
}
