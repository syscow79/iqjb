package oracle.iqjb.hu.jms;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

@MessageDriven(mappedName="jms/departmentQueue", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue")
})
public class DepartmentQueueReceiverMDB implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    private Logger logger = Logger.getLogger(DepartmentQueueReceiverMDB.class.getName());

    @Override
    public void onMessage(Message message) {
        TextMessage tMessage = null;
        if (message instanceof TextMessage) {
            tMessage = (TextMessage) message;
            try {
                logger.info("MESSAGE DRIVEN BEAN: Message received: " + tMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else {
            logger.warning("Message of wrong type: " + message.getClass().getName());
        }
    }

}
