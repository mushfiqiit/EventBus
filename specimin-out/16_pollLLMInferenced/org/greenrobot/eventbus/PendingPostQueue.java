package org.greenrobot.eventbus;

import javax.annotation.Nullable;

final class PendingPostQueue {

    private @Nullable PendingPost head;

    private @Nullable PendingPost tail;

    @Nullable
    synchronized PendingPost poll() {
        PendingPost pendingPost = head;
        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
        return pendingPost;
    }
}
