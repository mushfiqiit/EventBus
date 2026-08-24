package org.greenrobot.eventbus;

import java.util.List;

final class PendingPost {

    private final static List<PendingPost> pendingPostPool = null;

    Object event;

    Subscription subscription;

    PendingPost next;

    private PendingPost(Object event, Subscription subscription) {
        this.event = event;
        this.subscription = subscription;
    }
}
