package org.greenrobot.eventbus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

final class PendingPost {

    private static @Nonnull List<PendingPost> pendingPostPool = new java.util.ArrayList<>();

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    @Nullable
    PendingPost next;

    private PendingPost(@Nullable Object event, @Nullable Subscription subscription) {
        throw new java.lang.Error();
    }

    @Nonnull
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
