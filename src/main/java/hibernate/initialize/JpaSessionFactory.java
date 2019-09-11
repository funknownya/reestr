package hibernate.initialize;

/**
 * Фабрика для сессий Hibernate
 * Created by Farid on 5/21/2016.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;


public class JpaSessionFactory
{

//    private static SessionFactory sessionFactory;
    private static EntityManagerFactory entityManagerFactory;

    private static final Logger logger = LogManager.getLogger(JpaSessionFactory.class.getName());


    public static Boolean jpaInitialize ()
    {
        logger.info("Запуск функции jpaInitialize");

        Boolean isSuccessConnect = Boolean.FALSE;



        try
        {


            entityManagerFactory = Persistence.createEntityManagerFactory("reestr");

            if(entityManagerFactory != null)
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
            e.printStackTrace();
            String logText = "Ошибка во время создании сессии Hibernate. Ошибка: " + e.getMessage();
            logger.error(logText);

            isSuccessConnect = Boolean.FALSE;
            return isSuccessConnect;
        }
        
        return isSuccessConnect;
            
    }



    public static void shutdown() 
    {
        // Close caches and connection pools
        //getSessionFactory().close();
        getEntityManagerFactory().close();
    }

    
    public static EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

}
