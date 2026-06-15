package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import org.greenrobot.eventbus.android.AndroidComponents;

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
