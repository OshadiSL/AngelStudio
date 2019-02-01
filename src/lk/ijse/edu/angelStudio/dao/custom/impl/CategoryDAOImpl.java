/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.CategoryDAO;
import lk.ijse.edu.angelStudio.entity.Category;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class CategoryDAOImpl implements CategoryDAO{

    @Override
    public boolean save(Category category) throws Exception {
        return CrudUtil.executeUpdate("Insert Into  category Values(?,?)",
                category.getCacid(),
                category.getCategoryType()
                )>0;
       
    }

    @Override
    public boolean update(Category category) throws Exception {
        return CrudUtil.executeUpdate("Update Category SET  categoryName=?, WHERE cacid=?", 
                category.getCacid(),
                category.getCategoryType())>0;
        
    }

    @Override
    public boolean delete(String cacid) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Category where cacid=?", cacid) > 0;    }

    @Override
    public Category search(String id) throws Exception {
         ResultSet rst = CrudUtil.executeQuery("Select * from Category where cacid=?", id);
        if (rst.next()) {
            return new Category(rst.getString(1), rst.getString(2));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Category> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
