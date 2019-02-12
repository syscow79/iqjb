/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author oracle
 */
public class MyClassProducer {
    
    @Produces
    @MyClassQualifier
    public MyClass create(){
        MyClass myClass =  new MyClass();
        myClass.setName("myname");
        myClass.setTitle("mytitle");
        return myClass;
    }
    
    
    
    @Produces
    @Named("aaa")
    public MyClass create1(){
        MyClass myClass =  new MyClass();
        myClass.setName("myname1");
        myClass.setTitle("mytitle1");
        return myClass;
    }
    
    @Produces
    @Named("bbb")
    public MyClass create2(){
        MyClass myClass =  new MyClass();
        myClass.setName("myname2");
        myClass.setTitle("mytitle2");
        return myClass;
    }
    
    
    @Produces
    @Named
    public MyClass create3(){
        MyClass myClass =  new MyClass();
        myClass.setName("myname3");
        myClass.setTitle("mytitle3");
        return myClass;
    }
    
}
