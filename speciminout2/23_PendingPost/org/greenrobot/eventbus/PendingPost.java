package org.greenrobot.eventbus;

import java.util.List;

final class PendingPost {

  private static final List<PendingPost> pendingPostPool = null;

  Object event;

  Subscription subscription;

  PendingPost next;

  private PendingPost(Object event, Subscription subscription) {
    this.event = event;
    this.subscription = subscription;
  }
}
