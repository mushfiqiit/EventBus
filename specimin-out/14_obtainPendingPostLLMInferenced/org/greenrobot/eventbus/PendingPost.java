package org.greenrobot.eventbus;

import java.util.List;
import javax.annotation.Nullable;

final class PendingPost {

    private final static List<PendingPost> pendingPostPool;

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    @Nullable
    PendingPost next;

    private PendingPost(Object event, Subscription subscription) {
        throw new java.lang.Error();
    }

    static PendingPost obtainPendingPost(@Nullable Subscription subscription, @Nullable Object event) {
        synchronized (pendingPostPool) {
            int size = pendingPostPool.size();
            if (size > 0) {
                PendingPost pendingPost = pendingPostPool.remove(size - 1);
                pendingPost.event = event;
                pendingPost.subscription = subscription;
                pendingPost.next = null;
                return pendingPost;
            }
        }
        return new PendingPost(event, subscription);
    }

}
