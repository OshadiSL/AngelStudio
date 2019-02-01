/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.PaymentDAO;
import lk.ijse.edu.angelStudio.entity.Payment;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment payment) throws Exception {
        return CrudUtil.executeUpdate("Insert Into  payment values(?,?,?,?,?,?,?,?)",
                payment.getPyid(),
                payment.getOid(),
                payment.getTotal(),
                payment.getAdvance(),
                payment.getAmount(),
                payment.getOrderType(),
                payment.getBlance(),
                payment.getPaymentType()
        ) > 0;
    }

    @Override
    public boolean update(Payment payment) throws Exception {
        return CrudUtil.executeUpdate("Update payment SET  Date=?,ammount=?,balance=?,advance=? WHERE pyid=?",
                payment.getOid(),
                payment.getAdvance(),
                payment.getAmount(),
                payment.getOrderType(),
                //payment.getBalance(),
                payment.getPaymentType(),
                payment.getPyid()
        ) > 0;
    }

    @Override
    public boolean delete(String pyid) throws Exception {
        return CrudUtil.executeUpdate("Delect from Payment where pyid=?", pyid) > 0;
    }

    @Override
    public Payment search(String pyid) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
