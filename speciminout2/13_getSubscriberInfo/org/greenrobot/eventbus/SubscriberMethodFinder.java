package org.greenrobot.eventbus;

import java.util.List;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder {

  private List<SubscriberInfoIndex> subscriberInfoIndexes;

  private SubscriberInfo getSubscriberInfo(FindState findState) {
    if (findState.subscriberInfo != null
        && findState.subscriberInfo.getSuperSubscriberInfo() != null) {
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

    Class<?> clazz;

    SubscriberInfo subscriberInfo;
  }
}
