package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.MainThreadSupport;
import javax.annotation.Nullable;

public abstract class AndroidComponents {

    public static boolean areAvailable() {
        throw new java.lang.Error();
    }

    public static AndroidComponents get() {
        throw new java.lang.Error();
    }

    public @Nullable MainThreadSupport defaultMainThreadSupport;
}
