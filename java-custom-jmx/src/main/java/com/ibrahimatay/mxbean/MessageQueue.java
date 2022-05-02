package com.ibrahimatay.mxbean;

import java.util.Queue;

public class MessageQueue implements MessageQueueMXBean {
    private final Queue<Message> queue;

    public MessageQueue(Queue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public Message getMessage() {
        synchronized (queue) {
            return new Message(queue.peek().getName());
        }
    }
}
