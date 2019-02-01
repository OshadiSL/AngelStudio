/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.CustomerDAO;
import lk.ijse.edu.angelStudio.entity.Customer;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("Insert Into  customer Values(?,?,?,?,?)", 
             customer.getCid(),
             customer.getName(),
             customer.getAddress(),
             customer.getmNum(),
             customer.getNIC()
        )>0;
        
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("Update customer SET name=?,address=?,mobileNo=?,NIC=? WHERE cid=?",
                customer.getName(),
                customer.getAddress(),
                customer.getmNum(),
                customer.getCid(),
                customer.getNIC()
                )>0;

    }

    @Override
    public boolean delete(String cid) throws Exception {
        return  CrudUtil.executeUpdate("Delect from Customer where cid=?", cid)>0;
    }

    @Override
    public Customer search(String cid) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select *from customer customer where cid=?",cid);
        if (rst.next()) {
            return  new Customer(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
        }else{
        return  null;
        }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
