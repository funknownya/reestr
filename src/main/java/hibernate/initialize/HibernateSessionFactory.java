package hibernate.initialize;

/**
 * Фабрика для сессий Hibernate
 * @author Farid Mukhametshin
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory 
{

    private static final Logger logger = LogManager.getLogger(HibernateSessionFactory.class.getName());

    private static SessionFactory sessionFactory = null;

    public static Boolean initialize ()
    {
        logger.info("Запуск функции initialize");
        
        Boolean isSuccessConnect = Boolean.FALSE;

        Configuration configuration = new Configuration();
        configuration.configure();

        try
        {
            sessionFactory = buildSessionFactory(configuration);
            
            if(sessionFactory != null)
            {
                logger.info("База успешно подключена");
                isSuccessConnect = Boolean.TRUE;
            }
            else
            {
                logger.info("База не подключилась");
                isSuccessConnect = Boolean.FALSE;
            }
        

        }
        catch (Exception e)
        {
            logger.error("Ошибка функции initialize. Ошибка: " + e.getMessage());

            isSuccessConnect = Boolean.FALSE;
            return isSuccessConnect;
        }

        return isSuccessConnect;
    }

    protected static SessionFactory buildSessionFactory(Configuration configuration)
    {
        SessionFactory sessionFactory = null;

        // A SessionFactory is set up once for an application!

        // final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        // .applySettings(configuration.getProperties()).build();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .applySettings(configuration.getProperties())
                .build();


        try 
        {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e)
        {
            logger.error("Ошибка функции buildSessionFactory. Ошибка: " + e.getMessage());
        
            //e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );

        }
        return sessionFactory;
    }


    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }

    public static void shutdown() 
    {
        // Close caches and connection pools
        getSessionFactory().close();
        StandardServiceRegistryBuilder.destroy(getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
    }

}
