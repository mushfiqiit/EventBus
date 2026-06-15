package org.greenrobot.eventbus;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import java.util.List;

final class PendingPost {

    private final static @Nullable List<PendingPost> pendingPostPool;

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
}
