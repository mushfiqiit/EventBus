package org.greenrobot.eventbus;

import org.greenrobot.eventbus.android.AndroidComponents;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class EventBusBuilder {

    @Nullable
    MainThreadSupport mainThreadSupport;

    @Nullable
    MainThreadSupport getMainThreadSupport() {
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        } else if (AndroidComponents.areAvailable()) {
            return AndroidComponents.get().defaultMainThreadSupport;
        } else {
            return null;
        }
    }
}
