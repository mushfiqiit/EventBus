package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {

    private final @Nullable SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(@Nonnull Class subscriberClass, boolean shouldCheckSuperclass, @Nullable SubscriberMethodInfo[] methodInfos) {
        super(subscriberClass, null, shouldCheckSuperclass);
        this.methodInfos = methodInfos;
    }
}
