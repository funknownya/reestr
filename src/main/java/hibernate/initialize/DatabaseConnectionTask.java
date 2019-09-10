/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.initialize;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

/**
 *
 * @author Farid Mukhametshin
 * проверка подключения к БД
 */
public class DatabaseConnectionTask implements Callable<Boolean>
{
    private static final Logger logger = LogManager.getLogger(DatabaseConnectionTask.class.getName());

    @Override
    public Boolean call() throws Exception
    {

        Boolean isSuccessConnect = Boolean.FALSE;

        // создаем настройку подключения по Hibernate
        // инициализирует некоторые поля подключения к БД: логин, пароль и прочее
        isSuccessConnect = HibernateSessionFactory.initialize();
                
        return isSuccessConnect;
    }
}
