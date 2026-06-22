package org.greenrobot.eventbus;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import java.util.List;

class SubscriberMethodFinder {

    private @Nullable List<SubscriberInfoIndex> subscriberInfoIndexes;

    private @Nullable SubscriberInfo getSubscriberInfo(@Nonnull FindState findState) {
        if (findState.subscriberInfo != null && findState.subscriberInfo.getSuperSubscriberInfo() != null) {
            SubscriberInfo superclassInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superclassInfo.getSubscriberClass()) {
                return superclassInfo;
            }
        }
        if (subscriberInfoIndexes != null) {
            for (SubscriberInfoIndex index : subscriberInfoIndexes) {
                SubscriberInfo info = index.getSubscriberInfo(findState.clazz);
                if (info != null) {
                    return info;
                }
            }
        }
        return null;
    }

    static class FindState {

        @Nullable Class<?> clazz;

        @Nullable SubscriberInfo subscriberInfo;
    }
}
