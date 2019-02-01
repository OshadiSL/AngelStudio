/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.OrdersDAO;
import lk.ijse.edu.angelStudio.entity.Orders;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class OrderDAOImpl implements OrdersDAO {

    @Override
    public boolean save(Orders orders) throws Exception {
        return CrudUtil.executeUpdate("Insert Into orders Values(?,?,?,?,?)",
                orders.getOid(),
                orders.getCid(),
                orders.getTime(),
                orders.getDate(),
                orders.getStatus()
        ) > 0;
    }

    @Override
    public boolean update(Orders orders) throws Exception {
       return CrudUtil.executeUpdate("Update orders SET cid=?,time=?,date=?,status=? WHERE oid=?",
                 orders.getOid(),
                orders.getCid(),
                orders.getTime(),
                orders.getDate(),
                orders.getStatus()
        ) > 0;
    }

    @Override
    public boolean delete(String oid) throws Exception {
        return CrudUtil.executeUpdate("Delect from Orders where oid=?", oid) > 0;
    }

    @Override
    public Orders search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from Orders  where oid=?", id);
        if (rst.next()) {
            return new Orders(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        } else {
            return null;
      }
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
