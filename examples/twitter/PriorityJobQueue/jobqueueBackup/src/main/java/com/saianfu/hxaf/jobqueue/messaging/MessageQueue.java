package com.saianfu.hxaf.jobqueue.messaging;

public interface MessageQueue {
    void post(Message message);
    void postAt(Message message, long readyNs);
    void cancelMessages(MessagePredicate predicate);
    void stop();
    void consume(MessageQueueConsumer consumer);
    void clear();
}
