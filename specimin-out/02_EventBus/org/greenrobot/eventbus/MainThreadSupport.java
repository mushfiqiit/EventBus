package org.greenrobot.eventbus;

public interface MainThreadSupport {

    default boolean isMainThread() {
        throw new java.lang.Error();
    }

    default Poster createPoster(EventBus eventBus) {
        throw new java.lang.Error();
    }
}
