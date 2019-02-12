package oracle.iqjb.hu.jms;

import interceptor.JMSLoggerInterceptor;
import interceptor.LoggerInterceptor;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class DepartmentQueueReceiver {

    private static final Logger logger =
            Logger.getLogger("com.example.DepartmentQueueReceiver");

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/departmentQueue")
    private Queue queue;

    public DepartmentQueueReceiver() {
    }

    //@Interceptors(JMSLoggerInterceptor.class)
    public String receiveMessage() {
        String result = null;
        try (JMSConsumer consumer = context.createConsumer(queue)) {
            logger.log(Level.INFO, "Waiting for 10 sec ");
            Message m = consumer.receive(10000);
            if (m != null) {
                result = m.getBody(String.class);
                logger.log(Level.INFO, "Received message " + result);
            } else {
                logger.log(Level.INFO, "Received no message - likely timed out.");
            }
        } catch (JMSException ex) {
            logger.log(Level.INFO,"exception" + ex);
        }
        return result;
    }

}
