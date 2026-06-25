package org.greenrobot.eventbus.android;
import javax.annotation.Nullable;

import javax.annotation.Nonnull;
import org.greenrobot.eventbus.MainThreadSupport;

public abstract class AndroidComponents {

    public static boolean areAvailable() {
        throw new java.lang.Error();
    }

    @Nullable
    public static AndroidComponents get() {
        throw new java.lang.Error();
    }

    @Nonnull
    public final MainThreadSupport defaultMainThreadSupport;
}
