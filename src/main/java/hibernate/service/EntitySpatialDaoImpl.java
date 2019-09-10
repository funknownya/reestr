/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.service;


import hibernate.initialize.HibernateSessionFactory;
import hibernate.pojo.EntitySpatial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Farid Mukhametshin
 */
public class EntitySpatialDaoImpl implements EntitySpatialDao
{
    private static final Logger logger = LogManager.getLogger(EntitySpatialDaoImpl.class.getName());

    @Override
    public List<EntitySpatial> selectAll()
    {
        List<EntitySpatial> entitySpatialList = new ArrayList<EntitySpatial>();;
        
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try 
        {
            transaction = session.beginTransaction();
            
            Query query = session.createQuery("FROM EntitySpatial");

            entitySpatialList = query.list();
            
            transaction.commit();
        } 
        catch (Exception e)
        { 
            logger.error(e.getMessage());
        } 
        finally
        {
            session.close();
        }
        
        return entitySpatialList;
    }


    // сохранение нового контроллера
    // int - ошибка
    // 0 - нет ошибок
    // 1 - есть ошибка
    @Override
    public Boolean insertEntitySpatial(String entSys)
    {
        Boolean isSuccess = Boolean.FALSE;
        
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try 
        {
            transaction = session.beginTransaction();

            EntitySpatial entitySpatialObject = new EntitySpatial();
            entitySpatialObject.setEntSys(entSys);

            
            
            session.save(entitySpatialObject);
            session.flush();
            session.clear();

            transaction.commit();

            isSuccess = Boolean.TRUE;

        } 
        catch (Exception e)
        {
            // неизвестная ошибка
            isSuccess = Boolean.FALSE;

            logger.error(e.getMessage());
            
            transaction.rollback();
        }
        finally
        {
            session.close();
        }
        
        return isSuccess;
    }

    
}
