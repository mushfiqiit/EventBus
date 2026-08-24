package org.greenrobot.eventbus;

final class PendingPostQueue {

    private PendingPost head;

    private PendingPost tail;

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
