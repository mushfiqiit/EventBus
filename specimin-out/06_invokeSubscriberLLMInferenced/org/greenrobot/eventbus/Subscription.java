package org.greenrobot.eventbus;

import javax.annotation.Nonnull;

final class Subscription {

    final @Nonnull Object subscriber;

    final @Nonnull SubscriberMethod subscriberMethod;
}
