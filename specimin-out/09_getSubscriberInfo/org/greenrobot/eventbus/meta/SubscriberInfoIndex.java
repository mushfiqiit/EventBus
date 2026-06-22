package org.greenrobot.eventbus.meta;

public interface SubscriberInfoIndex {

    default SubscriberInfo getSubscriberInfo(Class<?> subscriberClass) {
        throw new java.lang.Error();
    }
}
