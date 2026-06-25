package org.greenrobot.eventbus;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class PendingPost {

    @Nonnull
    private final static List<PendingPost> pendingPostPool = new java.util.ArrayList<>();

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    @Nullable
    PendingPost next;

    private PendingPost(@Nullable Object event, @Nullable Subscription subscription) {
        this.event = event;
        this.subscription = subscription;
    }

    // Additional methods and fields as needed...
}
