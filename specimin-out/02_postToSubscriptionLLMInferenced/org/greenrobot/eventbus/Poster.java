package org.greenrobot.eventbus;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Poster {

    default void enqueue(@Nonnull Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }
}
