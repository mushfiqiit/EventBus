package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public class EventBus {

    void invokeSubscriber(PendingPost pendingPost) {
        Object event = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription != null && subscription.active) {
            invokeSubscriber(subscription, event);
        }
    }

    void invokeSubscriber(Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }
}
