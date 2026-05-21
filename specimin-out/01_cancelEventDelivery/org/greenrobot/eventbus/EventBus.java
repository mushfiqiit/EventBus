package org.greenrobot.eventbus;

import javax.annotation.Nullable;
public class EventBus {

    private final ThreadLocal<PostingThreadState> currentPostingThreadState;

    public void cancelEventDelivery(Object event) {
        PostingThreadState postingState = currentPostingThreadState.get();
        if (!postingState.isPosting) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (event == null) {
            throw new EventBusException("Event may not be null");
        } else if (postingState.event != event) {
            throw new EventBusException("Only the currently handled event may be aborted");
        } else if (postingState.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
        postingState.canceled = true;
    }

    final static class PostingThreadState {

        boolean isPosting;

        @Nullable
        Subscription subscription;

        @Nullable
        Object event;

        boolean canceled;
    }
}
