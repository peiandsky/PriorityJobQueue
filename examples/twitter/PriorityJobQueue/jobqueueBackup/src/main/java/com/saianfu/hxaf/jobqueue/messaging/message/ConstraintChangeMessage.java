package com.saianfu.hxaf.jobqueue.messaging.message;

import com.saianfu.hxaf.jobqueue.messaging.Message;
import com.saianfu.hxaf.jobqueue.messaging.Type;

public class ConstraintChangeMessage extends Message {
    private boolean forNextJob;
    public ConstraintChangeMessage() {
        super(Type.CONSTRAINT_CHANGE);
    }

    @Override
    protected void onRecycled() {
        forNextJob = false;
    }

    public boolean isForNextJob() {
        return forNextJob;
    }

    public void setForNextJob(boolean forNextJob) {
        this.forNextJob = forNextJob;
    }
}
