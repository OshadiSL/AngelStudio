/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom;

import lk.ijse.edu.angelStudio.entity.PrintDetail;
import lk.ijse.edu.angleStudio.dao.CrudDAO;

/**
 *
 * @author Oshadi
 */
public interface PrintDetailDAO extends CrudDAO<PrintDetail, String>{
    public boolean  updateQty(PrintDetail printDetail)throws Exception;
}
