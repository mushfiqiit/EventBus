package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public class EventBus {

    void invokeSubscriber(@javax.annotation.Nonnull PendingPost pendingPost) {
        Object event = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, event);
        }
    }

    void invokeSubscriber(@javax.annotation.Nonnull Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }
}
