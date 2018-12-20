package com.zks.spring.security.login.components.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.jms.*;

/**
 * Created by Administrator on 2018/12/20.
 */
public class AmqMessageProducer implements InitializingBean {

    private String brokerURL;

    private boolean tx;

    private MessageProducer producer;

    private String queue;

    private Session session;

    private Destination destination;

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    public void setTx(boolean tx) {
        this.tx = tx;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConnectionFactory factory =
                new ActiveMQConnectionFactory(brokerURL);
        Connection connection = factory.createConnection();
        this.session = connection.createSession(tx, Session.AUTO_ACKNOWLEDGE);
        this.destination = session.createQueue(queue);
        this.producer = session.createProducer(destination);
    }

    public void sendMessage(String message) {
        try {
            TextMessage messageSend = session.createTextMessage(message);
            producer.send(messageSend);
            if (tx) {
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.rollback();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }
    }
}
