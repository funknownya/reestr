/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.service;



import hibernate.initialize.JpaSessionFactory;
import hibernate.pojo.ReestrExtract;
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
public class ReestrExtractService implements IReestrExtractService
{
    private static final Logger logger = LogManager.getLogger(ReestrExtractService.class.getName());
    private EntityManagerFactory emf = JpaSessionFactory.getEntityManagerFactory();

    @Override
    public List<ReestrExtract> selectAll()
    {
        List<ReestrExtract> reestrExtractList = new ArrayList<ReestrExtract>();;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();
            Query query = em.createQuery("FROM ReestrExtract");

            reestrExtractList = query.getResultList();

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
        
        return reestrExtractList;
    }


    // сохранение нового контроллера
    // int - ошибка
    // 0 - нет ошибок
    // 1 - есть ошибка
    @Override
    public Boolean insertReestrExtract(ReestrExtract reestrExtractObject)
    {
        Boolean isSuccess = Boolean.FALSE;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();

            em.persist(reestrExtractObject);

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
