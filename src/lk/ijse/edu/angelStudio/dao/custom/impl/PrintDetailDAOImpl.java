/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.PrintDetailDAO;
import lk.ijse.edu.angelStudio.entity.PrintDetail;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class PrintDetailDAOImpl implements PrintDetailDAO {

    @Override
    public boolean save(PrintDetail printDetail) throws Exception {
        return CrudUtil.executeUpdate("Insert Into printdetails Values(?,?,?,?)",
               printDetail.getPrid(),printDetail.getOid(),printDetail.getQty(),printDetail.getPrice()
        ) > 0;
    }

    @Override
    public boolean update(PrintDetail printDetail) throws Exception {
        return CrudUtil.executeUpdate("Update PrintDetail SET  oid=?,qty=?,price=? WHERE prid=?",
                printDetail.getPrid(),
                printDetail.getOid(),
                printDetail.getQty(),
                printDetail.getPrice()
        ) > 0;
    }

    @Override
    public boolean delete(String prid) throws Exception {
        return CrudUtil.executeUpdate("Delect from printdetails where prid=? ", prid) > 0;
    }

    @Override
    public PrintDetail search(String prid) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from printdetails printdetails where prid=? ", prid);
        if (rst.next()) {
            return new PrintDetail(rst.getString(1), rst.getString(2), (int) rst.getDouble(3), rst.getInt(4));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<PrintDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateQty(PrintDetail printDetail) throws Exception {
        return CrudUtil.executeUpdate("Update PrintDetail SET  qty=? WHERE prid=? ",
                printDetail.getQty(),
                printDetail.getPrid()
        ) > 0;
    }

}
