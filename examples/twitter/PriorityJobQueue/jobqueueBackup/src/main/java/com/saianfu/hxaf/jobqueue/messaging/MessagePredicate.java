package com.saianfu.hxaf.jobqueue.messaging;

public interface MessagePredicate {
    boolean onMessage(Message message);
}
