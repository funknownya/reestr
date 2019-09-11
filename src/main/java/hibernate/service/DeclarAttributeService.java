/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.service;



import hibernate.initialize.JpaSessionFactory;
import hibernate.pojo.DeclarAttribute;
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
public class DeclarAttributeService implements IDeclarAttributeService
{
    private static final Logger logger = LogManager.getLogger(DeclarAttributeService.class.getName());
    private EntityManagerFactory emf = JpaSessionFactory.getEntityManagerFactory();

    @Override
    public List<DeclarAttribute> selectAll()
    {
        List<DeclarAttribute> declarAttributeList = new ArrayList<DeclarAttribute>();;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();
            Query query = em.createQuery("FROM DeclarAttribute");

            declarAttributeList = query.getResultList();

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
        
        return declarAttributeList;
    }


    // сохранение нового контроллера
    // int - ошибка
    // 0 - нет ошибок
    // 1 - есть ошибка
    @Override
    public Boolean insertDeclarAttribute(DeclarAttribute declarAttributeObject)
    {
        Boolean isSuccess = Boolean.FALSE;

        EntityManager em = emf.createEntityManager();
        try 
        {
            em.getTransaction().begin();

            em.persist(declarAttributeObject);

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
