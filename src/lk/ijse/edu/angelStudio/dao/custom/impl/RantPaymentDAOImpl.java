/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.RantPaymentDAO;
import lk.ijse.edu.angelStudio.entity.RantPayment;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class RantPaymentDAOImpl implements RantPaymentDAO{

    @Override
    public boolean save(RantPayment rantPayment) throws Exception {
        return CrudUtil.executeUpdate("Insert Into rentpayment values(?,?,?,?,?,?)", 
                 rantPayment.getPrid(),
                 rantPayment.getCaId(),
                 rantPayment.getDate(),
                 rantPayment.getAdvance(),
                 rantPayment.getTotal(),
                rantPayment.getBlance())>0
                ;
    }

    @Override
    public boolean update(RantPayment rentPayment) throws Exception {
        
         return CrudUtil.executeUpdate("Update rentpayment SET  caId=?,Date=?,advance=?,total_ammount=? ,balance=? WHERE prid=?", 
               rentPayment.getCaId(),
               rentPayment.getDate(),
               rentPayment.getAdvance(),
               rentPayment.getTotal(),
               rentPayment.getBlance(),
               rentPayment.getPrid()
                )>0;
        
    }

    @Override
    public boolean delete(String cid) throws Exception {
        return CrudUtil.executeUpdate("Delect from rentpayment where prid=?", cid)>0;
    }

    @Override
    public RantPayment search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select *from rentpayment  where prid=?",id);
        if (rst.next()) {
            return new RantPayment(rst.getString(1),rst.getString(2),rst.getString(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6));
        }else{
        return  null;
        }
    }

    @Override
    public ArrayList<RantPayment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
