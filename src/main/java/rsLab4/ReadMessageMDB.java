package rsLab4;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: ReadMessageMDB
 */
@MessageDriven(
        activationConfig = { 
            @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/MyQueue"), 
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
            @ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "true"),
            @ActivationConfigProperty(propertyName = "user", propertyValue = "test"),
            @ActivationConfigProperty(propertyName = "password", propertyValue = "Test123."),
            @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class ReadMessageMDB implements MessageListener {

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("Message received: " + textMessage.getText());
        } catch (JMSException e) {
            System.out.println("Error while trying to consume messages: " + e.getMessage());
        }
    }
}