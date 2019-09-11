/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.service;



import hibernate.initialize.JpaSessionFactory;
import hibernate.pojo.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Farid Mukhametshin
 */
public class CityService implements ICityService
{
    private static final Logger logger = LogManager.getLogger(CityService.class.getName());
    private EntityManagerFactory emf = JpaSessionFactory.getEntityManagerFactory();

    @Override
    public List<City> selectAll()
    {
        List<City> cityList = new ArrayList<City>();;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();
            Query query = em.createQuery("FROM City");

            cityList = query.getResultList();

            em.getTransaction().commit();
        } 
        catch (Exception e)
        { 
            logger.error(e.getMessage());
        } 
        finally
        {
            em.close();
        }
        
        return cityList;
    }


    // сохранение нового контроллера
    // int - ошибка
    // 0 - нет ошибок
    // 1 - есть ошибка
    @Override
    public Boolean insertCity(City cityObject)
    {
        Boolean isSuccess = Boolean.FALSE;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();

            em.persist(cityObject);

            em.getTransaction().commit();

            isSuccess = Boolean.TRUE;

        } 
        catch (Exception e)
        {
            // неизвестная ошибка
            isSuccess = Boolean.FALSE;

            logger.error(e.getMessage());

        }
        finally
        {
            em.close();
        }
        
        return isSuccess;
    }

    
}
