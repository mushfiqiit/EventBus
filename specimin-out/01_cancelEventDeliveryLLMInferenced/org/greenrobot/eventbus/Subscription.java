package org.greenrobot/eventbus;

final class Subscription {

    final SubscriberMethod subscriberMethod;
    
    public Subscription(@javax.annotation.Nonnull SubscriberMethod subscriberMethod) {
        this.subscriberMethod = subscriberMethod;
    }
}
