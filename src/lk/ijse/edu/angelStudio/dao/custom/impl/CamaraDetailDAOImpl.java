/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDetailDAO;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.CamaraDetail;
import lk.ijse.edu.angelStudio.entity.Customer;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class CamaraDetailDAOImpl implements CamaraDetailDAO {

    @Override
    public boolean save(CamaraDetail camaraDetail) throws Exception {
        return CrudUtil.executeUpdate("Insert Into  cameradetail Values(?,?,?,?) ", camaraDetail.getCaid(), camaraDetail.getOid(), camaraDetail.getQty(), camaraDetail.getPrice()) > 0;
    }

    @Override
    public boolean update(CamaraDetail camaraDetail) throws Exception {
        return CrudUtil.executeUpdate("Update cameradetail SET oid=?,qty=?,price=?WHERE ca=?",
                camaraDetail.getCaid(),
                camaraDetail.getOid(),
                camaraDetail.getQty(),
                camaraDetail.getPrice()) > 0;

    }

    @Override
    public boolean delete(String caId) throws Exception {
        return CrudUtil.executeUpdate("DELETE From camera where caId=?", caId) > 0;
    }

    @Override
    public CamaraDetail search(String caId) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from cameradetail cameradetail where caId=?", caId);
        if (rst.next()) {
            return new CamaraDetail(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<CamaraDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
