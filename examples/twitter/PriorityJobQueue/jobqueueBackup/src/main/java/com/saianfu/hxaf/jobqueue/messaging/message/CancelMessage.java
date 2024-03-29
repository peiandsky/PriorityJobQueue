package com.saianfu.hxaf.jobqueue.messaging.message;

import com.saianfu.hxaf.jobqueue.CancelResult;
import com.saianfu.hxaf.jobqueue.TagConstraint;
import com.saianfu.hxaf.jobqueue.messaging.Message;
import com.saianfu.hxaf.jobqueue.messaging.Type;

public class CancelMessage extends Message {
    private TagConstraint constraint;
    private String[] tags;
    private CancelResult.AsyncCancelCallback callback;

    public CancelMessage() {
        super(Type.CANCEL);
    }

    @Override
    protected void onRecycled() {

    }

    public TagConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(TagConstraint constraint) {
        this.constraint = constraint;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public CancelResult.AsyncCancelCallback getCallback() {
        return callback;
    }

    public void setCallback(CancelResult.AsyncCancelCallback callback) {
        this.callback = callback;
    }
}
