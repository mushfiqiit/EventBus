package org.greenrobot.eventbus;

import javax.annotation.Nullable;

final class PendingPostQueue {

    @Nullable
    private PendingPost head;

    @Nullable
    private PendingPost tail;

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
