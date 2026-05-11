package org.greenrobot.eventbus.android;

import javax.annotation.Nullable;

/**
 * 
 */
@javax.annotation.Nonnull
public abstract class AndroidComponents {

    @Nullable
    private static final AndroidComponents implementation = null;

    @Nullable
    public static AndroidComponents get() {
        return implementation;
    }
}
