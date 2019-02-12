package oracle.iqjb.hu;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import oracle.iqjb.hu.exception.MyException;
import oracle.iqjb.hu.facade.DepartmentSessionService1;
import oracle.iqjb.hu.facade.DepartmentSessionServiceCDI;
import oracle.iqjb.hu.jms.DepartmentQueueReceiver;
import oracle.iqjb.hu.jms.JMSQueueProducer;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.message.AddDepartmentResponse;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main view contains a simple label element and a template element.
 */
@Route("")
public class MainView extends VerticalLayout {

    @EJB
    private DepartmentSessionService1 departmentSessionService1;

    @Inject
    private DepartmentSessionServiceCDI departmentSessionServiceCDI;

    @Inject
    private JMSQueueProducer JMSQueueProducer;

    @Inject
    private DepartmentQueueReceiver departmentQueueReceiver;

    public MainView() {
        add(getDepartmentSessionService1Layout(), getDepartmentSessionServiceCDILayout(), getJMSQueueProducerLayout(),
                getDepartmentQueueReceiver());
    }

    private HorizontalLayout getDepartmentSessionService1Layout() {
        Text text = new Text("");
        Button button = new Button("Department Session Service",
                event -> {
                    AddDepartmentRequest addDepartmentRequest = new AddDepartmentRequest("department10");
                    try {
                        departmentSessionService1.addDepartment(addDepartmentRequest);
                        text.setText(addDepartmentRequest.getName() + " added");
                    } catch (MyException ex) {
                        text.setText(ex.getClass().getCanonicalName() + ": " + ex.getMessage());
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        return setLayout(text, button);
    }

    private HorizontalLayout getDepartmentSessionServiceCDILayout() {
        Text text = new Text("");
        Button button = new Button("Department Session Service CDI",
                event -> {
                    AddDepartmentRequest addDepartmentRequest = new AddDepartmentRequest("department10");
                    try {
                        departmentSessionServiceCDI.addDepartment(addDepartmentRequest);
                        text.setText(addDepartmentRequest.getName() + " added");
                    } catch (MyException ex) {
                        text.setText(ex.getClass().getCanonicalName() + ": " + ex.getMessage());
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        return setLayout(text, button);
    }

    private HorizontalLayout getJMSQueueProducerLayout() {
        Text text = new Text("");
        Button button = new Button("JMS Queue Producer",
                event -> {
                    int id = new Double(Math.random()).hashCode();
                    JMSQueueProducer.sendMessage("uzenet " + id);
                    text.setText("Sent message: " + id);
                });
        return setLayout(text, button);
    }

    private HorizontalLayout getDepartmentQueueReceiver() {
        Text text = new Text("");
        Button button = new Button("JMS Queue Receiver",
                event -> {
                    text.setText(departmentQueueReceiver.receiveMessage());
                });
        return setLayout(text, button);
    }

    private HorizontalLayout setLayout(Text text, Button button) {
        button.setWidth("300px");
        HorizontalLayout buttonLayout = new HorizontalLayout(button);
        buttonLayout.setWidth("300px");
        HorizontalLayout horizontalLayout = new HorizontalLayout(buttonLayout, new HorizontalLayout(), text);
        horizontalLayout.setAlignItems(Alignment.CENTER);
        horizontalLayout.setMargin(true);
        horizontalLayout.setSpacing(true);
        return horizontalLayout;
    }

}
