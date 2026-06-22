package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    protected AbstractSubscriberInfo(Class subscriberClass, Class<? extends SubscriberInfo> superSubscriberInfoClass, boolean shouldCheckSuperclass) {
        throw new java.lang.Error();
    }

    protected SubscriberMethod createSubscriberMethod(String methodName, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        throw new java.lang.Error();
    }
}
