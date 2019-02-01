/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.Global.print;
import lk.ijse.edu.angelStudio.dao.custom.PrintDAO;
import lk.ijse.edu.angelStudio.dbConnection.DBConnection;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class printDAOImpl implements PrintDAO {

    @Override
    public boolean save(Print print) throws Exception {
        return CrudUtil.executeUpdate("Insert Into  print Values(?,?,?,?,?,?)",
                print.getPrid(),
                print.getName(),
                print.getType(),
                print.getSize(),
                print.getPrice(),
                print.getQty()
        ) > 0;

    }

    @Override
    public boolean update(Print print) throws Exception {
        return CrudUtil.executeUpdate("Update Print SET  Name=?,Type=?,Size=?,Price=?,Qty=? WHERE Prid=?",
                print.getName(),
                print.getType(),
                print.getSize(),
                print.getPrice(),
                print.getQty(),
                print.getPrid()
        ) > 0;

    }

    @Override
    public boolean delete(String prid) throws Exception {
        return CrudUtil.executeUpdate("Delete from Print where prid=?", prid) > 0;
    }

    @Override
    public Print search(String prid) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from Print  where prid=?", prid);
        if (rst.next()) {
            return new Print(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getInt(6));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Print> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From print");
        ArrayList<Print> allPrint = new ArrayList<>();

        while (rst.next()) {

            Print customer = new Print(rst.getString("prid"), rst.getString("name"), rst.getString("type"), rst.getString("size"), rst.getDouble("price"), rst.getInt("qty"));
            allPrint.add(customer);
        }
        return allPrint;
    }

    public ArrayList<String> getLoardPrint() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select prid from print");
        ArrayList<String> tid = new ArrayList<>();
        while (rst.next()) {
            tid.add(rst.getString("prid"));

        }
        return tid;
    }

    @Override
    public Print loardAmount(String did) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from print where prid='" + did + "'");
        if (rst.next()) {
            return new Print(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5), rst.getInt(6));
        }
        return null;
        // prid  | name | type | size  | price  | qty
    }

    @Override
    public boolean updateQty(Print print) throws Exception {
        return CrudUtil.executeUpdate("Update Print SET  Qty=qty-? WHERE Prid=? ",
                print.getQty(),
                print.getPrid()
        ) > 0;
    }

}
