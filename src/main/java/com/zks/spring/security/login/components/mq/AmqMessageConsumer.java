package com.zks.spring.security.login.components.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2018/12/20.
 */
public class AmqMessageConsumer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory =
                new ActiveMQConnectionFactory("tcp://192.168.31.65:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("login-queue");
        MessageConsumer consumer = session.createConsumer(destination);
        TextMessage message = (TextMessage) consumer.receive();
        System.out.println("最近一次登录： " + message.getText());
        session.commit();
    }
}
