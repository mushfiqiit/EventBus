package org.greenrobot.eventbus.meta;

public interface SubscriberInfo {

    default SubscriberInfo getSuperSubscriberInfo() {
        throw new java.lang.Error();
    }
}
