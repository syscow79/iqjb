package oracle.iqjb.hu.jms;

import interceptor.JMSLoggerInterceptor;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

@RequestScoped
public class DepartmentTopicProducer {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/departmentTopic")
    private Topic topic;

    public DepartmentTopicProducer() {
    }

    //@Interceptors(JMSLoggerInterceptor.class)
    public void sendMessage(String message) {
        context.createProducer().send(topic, message);
    }

}