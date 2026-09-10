package org.greenrobot.eventbus;

import java.util.List;

final class PendingPost {

  private static final List<PendingPost> pendingPostPool = null;

  Object event;

  Subscription subscription;

  PendingPost next;

  private PendingPost(Object event, Subscription subscription) {
    throw new java.lang.Error();
  }

  static PendingPost obtainPendingPost(Subscription subscription, Object event) {
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
