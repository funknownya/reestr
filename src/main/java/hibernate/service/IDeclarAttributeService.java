/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.service;

import hibernate.pojo.DeclarAttribute;

import java.util.List;

/**
 * @author Farid Mukhametshin
 */
public interface IDeclarAttributeService
{
    List<DeclarAttribute> selectAll();

    Boolean insertDeclarAttribute(DeclarAttribute declarAttributeObject);


    
}
