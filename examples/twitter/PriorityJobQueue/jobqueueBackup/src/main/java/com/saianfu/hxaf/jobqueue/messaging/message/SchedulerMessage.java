package com.saianfu.hxaf.jobqueue.messaging.message;

import androidx.annotation.NonNull;
import com.saianfu.hxaf.jobqueue.messaging.Message;
import com.saianfu.hxaf.jobqueue.messaging.Type;
import com.saianfu.hxaf.jobqueue.scheduling.SchedulerConstraint;

/**
 * The messages with the scheduler
 */
public class SchedulerMessage extends Message {
    public static final int START = 1;
    public static final int STOP = 2;

    private int what;
    @SuppressWarnings("NullableProblems")
    @NonNull
    private SchedulerConstraint constraint;

    public SchedulerMessage() {
        super(Type.SCHEDULER);
    }

    public void set(int what, @NonNull SchedulerConstraint constraint) {
        this.what = what;
        this.constraint = constraint;
    }

    public int getWhat() {
        return what;
    }

    @NonNull
    public SchedulerConstraint getConstraint() {
        return constraint;
    }

    @Override
    protected void onRecycled() {
        //noinspection ConstantConditions
        constraint = null;
    }
}
