package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import javax.annotation.Nullable;

public class EventBus {

    @Nullable
    private final Poster mainThreadPoster;

    @Nullable
    private final BackgroundPoster backgroundPoster;

    @Nullable
    private final AsyncPoster asyncPoster;

    private void postToSubscription(@Nonnull Subscription subscription, @Nullable Object event, boolean isMainThread) {
        switch(subscription.subscriberMethod.threadMode) {
            case POSTING:
                invokeSubscriber(subscription, event);
                break;
            case MAIN:
                if (isMainThread) {
                    invokeSubscriber(subscription, event);
                } else {
                    if (mainThreadPoster != null) {
                        mainThreadPoster.enqueue(subscription, event);
                    }
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
                    if (backgroundPoster != null) {
                        backgroundPoster.enqueue(subscription, event);
                    }
                } else {
                    invokeSubscriber(subscription, event);
                }
                break;
            case ASYNC:
                if (asyncPoster != null) {
                    asyncPoster.enqueue(subscription, event);
                }
                break;
            default:
                throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    void invokeSubscriber(@Nonnull Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }
}
