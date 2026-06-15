package org.greenrobot.eventbus;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents a pending post.
 */
final class PendingPost {

    private final static List<PendingPost> pendingPostPool = new CopyOnWriteArrayList<>();

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
