package org.greenrobot.eventbus.meta;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

public interface SubscriberInfo {

    @Nullable default Class<?> getSubscriberClass() {
        throw new java.lang.Error();
    }

    @Nullable default SubscriberInfo getSuperSubscriberInfo() {
        throw new java.lang.Error();
    }
}
