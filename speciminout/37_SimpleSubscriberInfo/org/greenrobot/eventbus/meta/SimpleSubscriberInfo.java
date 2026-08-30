package org.greenrobot.eventbus.meta;

public class SimpleSubscriberInfo extends AbstractSubscriberInfo {

  private final SubscriberMethodInfo[] methodInfos;

  public SimpleSubscriberInfo(
      Class subscriberClass, boolean shouldCheckSuperclass, SubscriberMethodInfo[] methodInfos) {
    super(subscriberClass, null, shouldCheckSuperclass);
    this.methodInfos = methodInfos;
  }
}
