package org.greenrobot.eventbus;

class AsyncPoster implements Poster {

    public void enqueue(Subscription subscription, Object event) {
        throw new java.lang.Error();
    }

    public void run() {
        throw new java.lang.Error();
    }
}
