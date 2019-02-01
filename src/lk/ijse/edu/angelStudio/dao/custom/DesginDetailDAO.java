/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom;

import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.DesginDetail;
import lk.ijse.edu.angleStudio.dao.CrudDAO;

/**
 *
 * @author Oshadi
 */
public interface DesginDetailDAO extends CrudDAO<DesginDetail, String>{

    public boolean updateQty(DesginDetail desginDetail)throws Exception;
    
}
