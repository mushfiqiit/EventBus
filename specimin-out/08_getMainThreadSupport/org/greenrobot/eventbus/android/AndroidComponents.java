package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.MainThreadSupport;

public abstract class AndroidComponents {

    public static boolean areAvailable() {
        throw new java.lang.Error();
    }

    public static AndroidComponents get() {
        throw new java.lang.Error();
    }

    public final MainThreadSupport defaultMainThreadSupport;
}
