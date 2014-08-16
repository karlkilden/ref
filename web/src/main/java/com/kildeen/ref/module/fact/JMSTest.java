package com.kildeen.ref.module.fact;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.jms.*;
import java.util.logging.Level;

@Singleton
public class JMSTest {

    @Resource(name = "test")
    private Topic fooTopic;

    @Resource
    private ConnectionFactory connectionFactory;

    Session session;
    MessageProducer producer;

    Connection connection;


    @Schedule(second = "*/1", hour = "*", minute = "*")
    protected void send() throws Exception {

        TextMessage message = session.createTextMessage("Hello World!");
        producer.send(message);


    }


    @PostConstruct
    private void init() {
        java.util.logging.Logger.getLogger("org.apache.geronimo.connector.work.WorkerContext").setLevel(Level.OFF);

        try {

            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(fooTopic);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


    @PreDestroy
    private void close() {
        try {
            session.close();
            connection.close();
            producer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}