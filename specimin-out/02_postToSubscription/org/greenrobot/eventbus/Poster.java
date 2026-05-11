package org.greenrobot.eventbus;

public interface Poster {

    default void enqueue(Subscription subscription, Object event) {
        throw new java.lang.Error();
    }
}
