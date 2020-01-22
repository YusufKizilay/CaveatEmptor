package org.kizilay.yusuf.caveatemptor.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private  final static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static class Holder{
        static SessionFactory INSTANCE=buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {

                SessionFactory sessionFactory=null;

                final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                try {
                    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
                }
                catch (Exception e) {
                    e.printStackTrace();
                    // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                    // so destroy it manually.
                    StandardServiceRegistryBuilder.destroy( registry );
                }

                return sessionFactory;
            }
            catch (Throwable ex) {
                logger.error("Initial SessionFactory creation failed." , ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
    }

    public  static SessionFactory getSessionFactory(){
        return Holder.INSTANCE;
    }
}
