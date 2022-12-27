package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sound.midi.Soundbank;

@WebListener
public class SessionFactoryListener implements ServletContextListener {

    public SessionFactoryListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtil.closeSessionFactory();
    	System.out.println("Close SeesionFactory");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory();
    	System.out.println("Create SessionFactory");
    	
    	
    }
	
}
