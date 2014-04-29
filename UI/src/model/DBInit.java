package model;

import model.UserBeanOperations;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
 
@WebListener
public class DBInit implements ServletContextListener {
 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	
    }
 
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Database connection closed for Application.");
    }
     
}