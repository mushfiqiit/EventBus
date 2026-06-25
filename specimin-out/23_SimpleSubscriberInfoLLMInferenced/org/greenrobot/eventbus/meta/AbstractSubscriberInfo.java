package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractSubscriberInfo implements SubscriberInfo {

    protected AbstractSubscriberInfo(@Nonnull Class subscriberClass, @Nullable Class<? extends SubscriberInfo> superSubscriberInfoClass, boolean shouldCheckSuperclass) {
        throw new java.lang.Error();
    }
}
