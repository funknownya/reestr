/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.factory;

import hibernate.service.EntitySpatialDao;
import hibernate.service.EntitySpatialDaoImpl;

/**
 *
 * @author Farid Mukhametshin
 */
public class Factory 
{
    
    private static EntitySpatialDao entitySpatialDao = null;


    private static Factory instance = null;

    public static synchronized Factory getInstance()
    {
        if (instance == null) instance = new Factory();
    
        return instance;
    }


    public EntitySpatialDao getEntitySpatialDao()
    {
        if (entitySpatialDao == null) entitySpatialDao = new EntitySpatialDaoImpl();
        return entitySpatialDao;
    }

    
}
