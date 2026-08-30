package org.greenrobot.eventbus.meta;

public interface SubscriberInfo {

  Class<?> getSubscriberClass();

  SubscriberInfo getSuperSubscriberInfo();
}
