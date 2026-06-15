package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;

public interface SubscriberInfo {

    @Nullable
    default SubscriberInfo getSuperSubscriberInfo() {
        throw new java.lang.Error();
    }
}
