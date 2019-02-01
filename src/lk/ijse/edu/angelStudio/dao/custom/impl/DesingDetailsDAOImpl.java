/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.DesginDetailDAO;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.DesginDetail;
import lk.ijse.edu.angleStudio.dao.CrudUtil;

/**
 *
 * @author Oshadi
 */
public class DesingDetailsDAOImpl implements DesginDetailDAO {

    @Override
    public boolean save(DesginDetail desginDetail) throws Exception {
        return CrudUtil.executeUpdate("Insert Into desingdetail Values(?,?,?,?)",
                desginDetail.getDid(), desginDetail.getOid(), desginDetail.getQty(), desginDetail.getPrice()
        ) > 0;

    }

    @Override
    public boolean update(DesginDetail desginDetail) throws Exception {
        return CrudUtil.executeUpdate("Update DesginDetail SET  oid=?,qty=?,price=? WHERE did=?",
                desginDetail.getDid(),
                desginDetail.getOid(),
                desginDetail.getPrice(),
                desginDetail.getQty()
        ) > 0;

    }

    @Override
    public boolean delete(String did) throws Exception {
        return CrudUtil.executeUpdate("Delect from desingdetail where did=?", did) > 0;
    }

    @Override
    public DesginDetail search(String did) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select *from desingdetail desingdetail where did=?", did);
        if (rst.next()) {
            return new DesginDetail(rst.getString(1), rst.getString(2), (int) rst.getDouble(3), rst.getInt(4));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<DesginDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateQty(DesginDetail desginDetail) throws Exception {
        return CrudUtil.executeUpdate("Update DesginDetail SET qty=?  WHERE did=? ",
                desginDetail.getQty(),
                desginDetail.getDid()
        ) > 0;
    }

}
