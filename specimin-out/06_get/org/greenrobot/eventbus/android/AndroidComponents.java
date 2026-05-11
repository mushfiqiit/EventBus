package org.greenrobot.eventbus.android;

import javax.annotation.Nullable;
public abstract class AndroidComponents {

    @Nullable
    private static final AndroidComponents implementation = null;

    public static AndroidComponents get() {
        return implementation;
    }
}
