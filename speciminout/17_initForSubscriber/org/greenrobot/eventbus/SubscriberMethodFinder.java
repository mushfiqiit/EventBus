package org.greenrobot.eventbus;

import org.greenrobot.eventbus.meta.SubscriberInfo;

class SubscriberMethodFinder {

  static class FindState {

    Class<?> subscriberClass;

    Class<?> clazz;

    boolean skipSuperClasses;

    SubscriberInfo subscriberInfo;

    void initForSubscriber(Class<?> subscriberClass) {
      this.subscriberClass = clazz = subscriberClass;
      skipSuperClasses = false;
      subscriberInfo = null;
    }
  }
}
