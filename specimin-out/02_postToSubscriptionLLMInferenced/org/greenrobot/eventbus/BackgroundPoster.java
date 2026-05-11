package org.greenrobot.eventbus;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

final class BackgroundPoster implements Poster {

    @Override
    public void enqueue(@Nonnull Subscription subscription, @Nullable Object event) {
        throw new java.lang.Error();
    }

    public void run() {
        throw new java.lang.Error();
    }
}
