/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.CategoryDetailDAO;
import lk.ijse.edu.angelStudio.entity.CamaraDetail;
import lk.ijse.edu.angelStudio.entity.CategoryDetail;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class CategoryDetailDAOImpl implements CategoryDetailDAO{

    @Override
    public boolean save(CategoryDetail categoryDetail) throws Exception {
        return CrudUtil.executeUpdate("Insert Into categorydetail (?,?)",
                categoryDetail.getCaId(),
                categoryDetail.getCacid()
                )>0;
    }

    @Override
    public boolean update(CategoryDetail categoryDetail) throws Exception {
         return CrudUtil.executeUpdate("Update categorydetail SET caid=? WHERE cacid=?",
                categoryDetail.getCaId(),
                categoryDetail.getCacid()
                )>0;

    }

    @Override
    public boolean delete(String cacid) throws Exception {
        return CrudUtil.executeUpdate("DELETE From CategoryDetail where cacid=?", cacid) > 0;
    }

    @Override
    public CategoryDetail search(String cacid) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select *from CategoryDetail CategoryDetail where cacid=?",cacid);
        if (rst.next()) {
            return  new CategoryDetail(rst.getString(1),rst.getString(2));
        }else{
        return  null;
        }
    }

    @Override
    public ArrayList<CategoryDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
