package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;
import javax.annotation.Nullable;
import org.jspecify.annotations.NullUnmarked;

public abstract class AndroidComponents {

    @Nullable private static final AndroidComponents implementation;

    static {
        implementation = AndroidDependenciesDetector.isAndroidSDKAvailable()
            ? AndroidDependenciesDetector.instantiateAndroidComponents()
            : null;
    }

    public static boolean areAvailable() {
        return implementation != null;
    }

    @NullUnmarked public static AndroidComponents get() {
        return implementation;
    }

    public final Logger logger;
    public final MainThreadSupport defaultMainThreadSupport;

    public AndroidComponents(Logger logger, MainThreadSupport defaultMainThreadSupport) {
        this.logger = logger;
        this.defaultMainThreadSupport = defaultMainThreadSupport;
    }
}
