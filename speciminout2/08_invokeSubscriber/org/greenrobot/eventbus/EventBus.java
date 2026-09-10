package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;

public class EventBus {

  void invokeSubscriber(Subscription subscription, Object event) {
    try {
      subscription.subscriberMethod.method.invoke(subscription.subscriber, event);
    } catch (InvocationTargetException e) {
      handleSubscriberException(subscription, event, e.getCause());
    } catch (IllegalAccessException e) {
      throw new IllegalStateException("Unexpected exception", e);
    }
  }

  private void handleSubscriberException(Subscription subscription, Object event, Throwable cause) {
    throw new java.lang.Error();
  }
}
