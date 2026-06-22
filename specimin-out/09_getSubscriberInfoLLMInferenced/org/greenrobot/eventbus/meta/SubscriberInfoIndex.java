package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;

public interface SubscriberInfoIndex {

    default @Nullable SubscriberInfo getSubscriberInfo(Class<?> subscriberClass) {
        throw new java.lang.Error();
    }
}
