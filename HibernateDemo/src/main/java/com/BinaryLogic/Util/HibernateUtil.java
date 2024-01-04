package com.BinaryLogic.Util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.BinaryLogic.Model.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null) {
			try {
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				
				properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db");
				properties.put(Environment.USER, "root");
		        properties.put(Environment.PASS, "MySQLInstallerRootAccountPassword123!@#");
		        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		        properties.put(Environment.SHOW_SQL, true);
//		        properties.put(Environment.AUTOCOMMIT, true);
		        properties.put(Environment.HBM2DDL_AUTO, "update");
		        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
	            configuration.setProperties(properties);
	            configuration.addAnnotatedClass(Student.class);
	            
	            ServiceRegistry serviceRegistry  = new StandardServiceRegistryBuilder()
	            		.applySettings(configuration.getProperties())
	            		.build();
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
