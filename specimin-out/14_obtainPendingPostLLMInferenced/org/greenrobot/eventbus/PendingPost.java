package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

import java.util.List;
import javax.annotation.Nullable;

final class PendingPost {

    private final static @Nullable List<PendingPost> pendingPostPool;

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    @Nullable
    PendingPost next;

    private PendingPost(Object event, Subscription subscription) {
        throw new java.lang.Error();
    }

    static @Nonnull PendingPost obtainPendingPost(@Nullable Subscription subscription, @Nullable Object event) {
        synchronized (pendingPostPool) {
            if (pendingPostPool != null) {
                int size = pendingPostPool.size();
                if (size > 0) {
                    PendingPost pendingPost = pendingPostPool.remove(size - 1);
                    pendingPost.event = event;
                    pendingPost.subscription = subscription;
                    pendingPost.next = null;
                    return pendingPost;
                }
            }
        }
        return new PendingPost(event, subscription);
    }

    static void releasePendingPost(@Nonnull PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        synchronized (pendingPostPool) {
            if (pendingPostPool != null && pendingPostPool.size() < 10000) {
                pendingPostPool.add(pendingPost);
            }
        }
    }

}
