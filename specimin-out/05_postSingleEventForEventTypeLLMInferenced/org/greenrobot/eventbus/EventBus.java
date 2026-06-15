package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {

    private final @Nonnull Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;

    private boolean postSingleEventForEventType(@Nonnull Object event, @Nonnull PostingThreadState postingState, @Nonnull Class<?> eventClass) {
        @Nullable CopyOnWriteArrayList<Subscription> subscriptions;
        synchronized (this) {
            subscriptions = subscriptionsByEventType.get(eventClass);
        }
        if (subscriptions != null && !subscriptions.isEmpty()) {
            for (@Nonnull Subscription subscription : subscriptions) {
                postingState.event = event;
                postingState.subscription = subscription;
                boolean aborted;
                try {
                    postToSubscription(subscription, event, postingState.isMainThread);
                    aborted = postingState.canceled;
                } finally {
                    postingState.event = null;
                    postingState.subscription = null;
                    postingState.canceled = false;
                }
                if (aborted) {
                    break;
                }
            }
            return true;
        }
        return false;
    }

    private void postToSubscription(@Nonnull Subscription subscription, @Nonnull Object event, boolean isMainThread) {
        throw new java.lang.Error();
    }

    final static class PostingThreadState {

        boolean isMainThread;

        @Nullable Subscription subscription;

        @Nullable Object event;

        boolean canceled;
    }

}
