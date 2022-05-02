package com.ibrahimatay;

import com.ibrahimatay.mbean.Speaker;
import com.ibrahimatay.mbean.SpeakerMBean;
import com.ibrahimatay.mxbean.Message;
import com.ibrahimatay.mxbean.MessageQueue;
import com.ibrahimatay.mxbean.MessageQueueMXBean;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Member;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main  {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName speakerName = new ObjectName("com.ibrahimatay:type=Speaker");
        SpeakerMBean bean = new Speaker();
        mbs.registerMBean(bean, speakerName);


        ObjectName messageName = new ObjectName("com.ibrahimatay:type=Message");
        Queue<Message> messages = new ArrayBlockingQueue<Message>(10);
        messages.add(new Message("Message 1"));
        messages.add(new Message("Message 2"));
        messages.add(new Message("Message 3"));
        messages.add(new Message("Message 4"));
        MessageQueue messageQueue = new MessageQueue(messages);

        mbs.registerMBean(messageQueue, messageName);

        System.out.println("Started");
        while (true) {

        }
    }
}