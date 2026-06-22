package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public interface SubscriberInfo {

    default SubscriberMethod[] getSubscriberMethods() {
        throw new java.lang.Error();
    }
}
