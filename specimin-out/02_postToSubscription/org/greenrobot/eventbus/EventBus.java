package org.greenrobot.eventbus;

import javax.annotation.Nullable;
public class EventBus {

    @Nullable
    private final Poster mainThreadPoster;

    private final BackgroundPoster backgroundPoster;

    private final AsyncPoster asyncPoster;

    private void postToSubscription(Subscription subscription, Object event, boolean isMainThread) {
        switch(subscription.subscriberMethod.threadMode) {
            case POSTING:
                invokeSubscriber(subscription, event);
                break;
            case MAIN:
                if (isMainThread) {
                    invokeSubscriber(subscription, event);
                } else {
                    mainThreadPoster.enqueue(subscription, event);
                }
                break;
            case MAIN_ORDERED:
                if (mainThreadPoster != null) {
                    mainThreadPoster.enqueue(subscription, event);
                } else {
                    invokeSubscriber(subscription, event);
                }
                break;
            case BACKGROUND:
                if (isMainThread) {
                    backgroundPoster.enqueue(subscription, event);
                } else {
                    invokeSubscriber(subscription, event);
                }
                break;
            case ASYNC:
                asyncPoster.enqueue(subscription, event);
                break;
            default:
                throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    void invokeSubscriber(Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }
}
