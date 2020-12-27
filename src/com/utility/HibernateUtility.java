package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtility {
                private static final SessionFactory sessionFactory = createSessionFactory();

                public static SessionFactory createSessionFactory() {
                                try {
                                      return new AnnotationConfiguration().configure().buildSessionFactory();
                                } catch (Exception ex) {
                                                System.err.println("SessionFactory creation failed");
                                                throw new ExceptionInInitializerError(ex);
                                }
                }

                /**
                 * @return the sessionfactory
                 */
                public static SessionFactory getSessionFactory() {
                                return sessionFactory;
                }

}
