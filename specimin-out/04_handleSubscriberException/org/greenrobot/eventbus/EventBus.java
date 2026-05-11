package org.greenrobot.eventbus;

import java.util.logging.Level;
import javax.annotation.Nullable;
public class EventBus {

    private final boolean throwSubscriberException = false;

    private final boolean logSubscriberExceptions = false;

    private final boolean sendSubscriberExceptionEvent = false;

    private final Logger logger = null;

    public void post(Object event) {
        throw new java.lang.Error();
    }

    private void handleSubscriberException(Subscription subscription, @Nullable Object event, @Nullable Throwable cause) {
        if (event instanceof SubscriberExceptionEvent) {
            if (logSubscriberExceptions) {
                logger.log(Level.SEVERE, "SubscriberExceptionEvent subscriber " + subscription.subscriber.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent exEvent = (SubscriberExceptionEvent) event;
                logger.log(Level.SEVERE, "Initial event " + exEvent.causingEvent + " caused exception in " + exEvent.causingSubscriber, exEvent.throwable);
            }
        } else {
            if (throwSubscriberException) {
                throw new EventBusException("Invoking subscriber failed", cause);
            }
            if (logSubscriberExceptions) {
                logger.log(Level.SEVERE, "Could not dispatch event: " + event.getClass() + " to subscribing class " + subscription.subscriber.getClass(), cause);
            }
            if (sendSubscriberExceptionEvent) {
                SubscriberExceptionEvent exEvent = new SubscriberExceptionEvent(this, cause, event, subscription.subscriber);
                post(exEvent);
            }
        }
    }
}
