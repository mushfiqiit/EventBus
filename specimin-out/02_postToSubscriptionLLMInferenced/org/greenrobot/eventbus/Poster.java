package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

public interface Poster {

    default void enqueue(@Nonnull Subscription subscription, @Nonnull Object event) {
        throw new java.lang.Error();
    }
}
