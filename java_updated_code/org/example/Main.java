package org.example;

import org.apache.catalina.core.ApplicationContext;
import org.example.bean.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        ApplicationContext context = new ApplicationContext("applicationContext.xml");
//        UserConfig config = (UserConfig) context.getBean( "userConfigBean" );
    }
}