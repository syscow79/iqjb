package oracle.iqjb.hu.jms;

import interceptor.JMSLoggerInterceptor;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.JMSContext;
import javax.jms.Queue;

@RequestScoped
public class JMSTopicProducer {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/departmentQueue")
    private Queue queue;

    public JMSTopicProducer() {
    }

    //@Interceptors(JMSLoggerInterceptor.class)
    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
    }

}