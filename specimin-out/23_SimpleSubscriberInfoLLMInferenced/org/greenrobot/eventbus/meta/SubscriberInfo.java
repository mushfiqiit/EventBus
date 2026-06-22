package org.greenrobot.eventbus.meta;

import javax.annotation.Nonnull;

import org.greenrobot.eventbus.SubscriberMethod;

public interface SubscriberInfo {

    @Nonnull
    default SubscriberMethod[] getSubscriberMethods() {
        throw new java.lang.Error();
    }
}
