package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;

public class EventBus {

    void invokeSubscriber(@Nonnull Subscription subscription, @Nonnull Object event) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, event);
        } catch (InvocationTargetException e) {
            handleSubscriberException(subscription, event, e.getCause());
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        }
    }

    private void handleSubscriberException(@Nonnull Subscription subscription, @Nonnull Object event, @Nonnull Throwable cause) {
        throw new java.lang.Error();
    }
}
