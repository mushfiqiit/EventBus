package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;

public interface SubscriberInfo {

    default Class<?> getSubscriberClass() {
        throw new java.lang.Error();
    }

    default @Nullable SubscriberInfo getSuperSubscriberInfo() {
        throw new java.lang.Error();
    }
}
