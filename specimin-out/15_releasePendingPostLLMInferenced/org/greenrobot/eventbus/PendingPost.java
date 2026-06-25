package org.greenrobot.eventbus;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class PendingPost {

    private final static @Nonnull List<PendingPost> pendingPostPool = new java.util.ArrayList<>(); // Initialize pendingPostPool

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    @Nullable
    PendingPost next;

    static void releasePendingPost(@Nonnull PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        synchronized (pendingPostPool) {
            if (pendingPostPool.size() < 10000) {
                pendingPostPool.add(pendingPost);
            }
        }
    }
}
