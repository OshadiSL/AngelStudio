/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.DesginDAO;
import lk.ijse.edu.angelStudio.dbConnection.DBConnection;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.CrudUtil;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public class DesginTypeDAOImpl implements DesginDAO {

    @Override
    public boolean save(Desgin desgin) throws Exception {
        return CrudUtil.executeUpdate("Insert Into desingetype Values(?,?,?,?,?)",
                desgin.getDid(),
                desgin.getType(),
                desgin.getSize(),
                desgin.getPrice(),
                desgin.getQty()
        ) > 0;
    }

    @Override
    public boolean update(Desgin desgin) throws Exception {
        return CrudUtil.executeUpdate("Update desingetype SET type=?,size=?,price =? ,qty =? WHERE did=?",
                desgin.getType(),
                desgin.getSize(),
                desgin.getPrice(),
                desgin.getQty(),
                desgin.getDid()
        ) > 0;

    }

    @Override
    public boolean delete(String did) throws Exception {
        return CrudUtil.executeUpdate("Delete from desingetype where did=?", did) > 0;
    }

    @Override
    public Desgin search(String did) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from desingetype desingetype where did=?", did);
        if (rst.next()) {
            return new Desgin(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Desgin> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DesginDTO> getAllDising() throws Exception {
        ArrayList<DesginDTO> allDisin = new ArrayList<>();
        String SQL = "select *from desingetype";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        while (rst.next()) {
            allDisin.add(new DesginDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5)));
        }
        return allDisin;
    }

    @Override
    public Desgin lodddAllPrice(String did) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select *from desingetype  where did='" + did + "'");
        if (rst.next()) {
            return new Desgin(rst.getString("did"), rst.getString("type"), rst.getString("size"), rst.getDouble("price"), rst.getInt("qty"));
        }
        return null;
    }

    @Override
    public ArrayList<String> getAllDesign() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select did from desingetype");
        ArrayList<String> type = new ArrayList<>();
        while (rst.next()) {
            type.add(rst.getString("did"));

        }
        return type;
    }

    @Override
    public boolean updateQty(Desgin desgin) throws Exception {
        return CrudUtil.executeUpdate("Update desingetype SET qty =qty-? WHERE did=? ",
                desgin.getQty(),
                desgin.getDid()
        ) > 0;
    }

    @Override
    public boolean add(Desgin desgin) throws Exception {
        return CrudUtil.executeUpdate("Insert into desingetype values(?,?,?,?,?)",
                desgin.getDid(),
                desgin.getType(),
                desgin.getSize(),
                desgin.getPrice(),
                desgin.getQty())>0;
    }
}
