package model;

import model.UserBeanOperations;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
 
@WebListener
public class DBInit implements ServletContextListener {
 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        ServletContext ctx = servletContextEvent.getServletContext();
//        //create database connection from init parameters and set it to context
//		UserBeanOperations ubo = new UserBeanOperations();
//		ubo.addUser("firstName", "lastName", "email", "password");
//		System.out.println("trying to add user");
//		System.out.println(ubo.checkUser("email", "password"));
//        System.out.println("Database connection initialized for Application.");
    }
 
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Database connection closed for Application.");
    }
     
}