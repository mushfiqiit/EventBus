package org.greenrobot.eventbus;

import javax.annotation.Nullable;

public interface MainThreadSupport {

    @Nullable
    default Poster createPoster(EventBus eventBus) {
        throw new java.lang.Error();
    }
}
