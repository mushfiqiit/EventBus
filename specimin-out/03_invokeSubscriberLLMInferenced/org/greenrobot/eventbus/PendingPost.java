package org.greenrobot.eventbus;

import javax.annotation.Nullable;

final class PendingPost {

    @Nullable
    Object event;

    @Nullable
    Subscription subscription;

    static void releasePendingPost(@javax.annotation.Nonnull PendingPost pendingPost) {
        throw new java.lang.Error();
    }
}
