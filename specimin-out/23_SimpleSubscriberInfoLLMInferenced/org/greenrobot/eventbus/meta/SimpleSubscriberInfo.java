package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;

import org.greenrobot.eventbus.SubscriberMethod;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {

    @Nonnull
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(@Nonnull Class subscriberClass, boolean shouldCheckSuperclass, @Nonnull SubscriberMethodInfo[] methodInfos) {
        super(subscriberClass, null, shouldCheckSuperclass);
        this.methodInfos = methodInfos;
    }

    @Nonnull
    @Override
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        int length = methodInfos.length;
        @Nonnull SubscriberMethod[] methods = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            @Nonnull SubscriberMethodInfo info = methodInfos[i];
            methods[i] = createSubscriberMethod(info.methodName, info.eventType, info.threadMode, info.priority, info.sticky);
        }
        return methods;
    }
}
