package org.greenrobot.eventbus;
import javax.annotation.Nonnull;

class AsyncPoster implements Poster {

    @Override
    public void enqueue(@Nonnull Subscription subscription, @Nonnull Object event) {
        throw new java.lang.Error();
    }

    public void run() {
        throw new java.lang.Error();
    }
}
