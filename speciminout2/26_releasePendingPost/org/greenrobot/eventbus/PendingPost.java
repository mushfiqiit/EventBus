package org.greenrobot.eventbus;

import java.util.List;

final class PendingPost {

  private static final List<PendingPost> pendingPostPool = null;

  Object event;

  Subscription subscription;

  PendingPost next;

  static void releasePendingPost(PendingPost pendingPost) {
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
