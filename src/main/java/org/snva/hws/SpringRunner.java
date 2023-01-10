package org.snva.hws;

import org.snva.hws.beans.User;
import org.snva.hws.config.UsersConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringRunner {
    public static void main( String[] args ){
        /*in the beginning, implementations used or wired dependencies
        1. BeanFactory (deprecated 3x) 6x today
        2. Application context
            - ClassPathXmlApplicationContext
            - FileSystemXmlApplicationContext
            - AnnotationConfigApplicationContext
        */

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //List<User> users = (List<User>) applicationContext.getBean("users");
        //users.forEach(x -> {System.out.println(x);});
        //System.out.println(users);


        //List<Integer> roles = (List<Integer>) applicationContext.getBean("users");
        applicationContext.register(UsersConfig.class);
        applicationContext.refresh();

        List<User> users = (List<User>) applicationContext.getBean("users");
        users.forEach(x -> {System.out.println(x);});

    }
}
