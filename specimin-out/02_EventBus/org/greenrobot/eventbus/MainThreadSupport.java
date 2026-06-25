package org.greenrobot.eventbus;

public interface MainThreadSupport {

    default Poster createPoster(EventBus eventBus) {
        throw new java.lang.Error();
    }
}
