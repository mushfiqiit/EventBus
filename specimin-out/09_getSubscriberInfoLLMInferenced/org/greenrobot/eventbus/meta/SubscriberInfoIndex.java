package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public interface SubscriberInfoIndex {

    @Nullable default SubscriberInfo getSubscriberInfo(@Nullable Class<?> subscriberClass) {
        throw new java.lang.Error();
    }
}
