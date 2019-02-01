/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.CrudDAO;

/**
 *
 * @author Oshadi
 */
public interface PrintDAO extends CrudDAO<Print, String> {

    public ArrayList<String> getLoardPrint() throws Exception;

    public Print loardAmount(String did) throws Exception;
    
    public boolean updateQty(Print print) throws Exception;

    

}

