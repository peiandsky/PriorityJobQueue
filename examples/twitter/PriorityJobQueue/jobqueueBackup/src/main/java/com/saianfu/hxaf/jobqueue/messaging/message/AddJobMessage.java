package com.saianfu.hxaf.jobqueue.messaging.message;

import com.saianfu.hxaf.jobqueue.Job;
import com.saianfu.hxaf.jobqueue.messaging.Message;
import com.saianfu.hxaf.jobqueue.messaging.Type;

public class AddJobMessage extends Message {
    private Job job;
    public AddJobMessage() {
        super(Type.ADD_JOB);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    protected void onRecycled() {
        job = null;
    }
}
