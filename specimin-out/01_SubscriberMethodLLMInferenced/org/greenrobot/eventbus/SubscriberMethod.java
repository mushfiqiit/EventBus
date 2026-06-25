package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

public class SubscriberMethod {

    final Method method;

    final ThreadMode threadMode;

    final Class<?> eventType;

    final int priority;

    final boolean sticky;

    @Nullable
    String methodString;

    public SubscriberMethod(Method method, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = eventType;
        this.priority = priority;
        this.sticky = sticky;
    }
}
