package com.kildeen.ref.module.fact;

import com.kildeen.ref.system.LogManager;
import org.slf4j.Logger;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.lang.IllegalStateException;

@MessageDriven(name = "test",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class TopicConsumer implements MessageListener {
     private static final Logger log = LogManager.getLogger();

    @Override
    public void onMessage(Message message) {
        try {

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                log.info("Received: " + text);
            } else {
                log.info("Received: " + message);
            }
        } catch (JMSException e) {
            throw new IllegalStateException(e);
        }
    }

}