package org.greenrobot.eventbus.meta;

public interface SubscriberInfo {

    default Class<?> getSubscriberClass() {
        throw new java.lang.Error();
    }

    default SubscriberInfo getSuperSubscriberInfo() {
        throw new java.lang.Error();
    }
}
