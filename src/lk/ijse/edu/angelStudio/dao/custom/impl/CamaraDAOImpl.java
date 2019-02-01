/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom.impl;

import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDAO;
import lk.ijse.edu.angelStudio.dbConnection.DBConnection;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.Customer;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angelStudio.entity.ReturnItem;
import lk.ijse.edu.angleStudio.dao.CrudUtil;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public class CamaraDAOImpl implements CamaraDAO {

    @Override
    public boolean save(Camara camara) throws Exception {
        return CrudUtil.executeUpdate("Insert Into Camara Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                camara.getCaId(),
                camara.getBrand(),
                camara.getCampany(),
                camara.getBodyType(),
                camara.getClour(),
                camara.getLenseType(),
                camara.getPixels(),
                camara.getFlashers(),
                camara.getRemoteControol(),
                camara.getWifi(),
                camara.getBloototh(),
                camara.getUsb(),
                camara.getBatreyDuration(),
                camara.getBattryVotage(),
                camara.getBattryType(),
                camara.getLenseBrand(),
                camara.getLenseSize(),
                camara.getQty(),
                camara.getPrice()
        )>0;
    }

    @Override
    public boolean update(Camara camara) throws Exception {
        return CrudUtil.executeUpdate("Update camera SET brand=?,campany=?,bodyType =? ,clour =?,lenseType =?,pixels =?,Flashers =?,RemoteControol =?,wifi =?,bloototh =?,usb =?,BatreyDuration =?,battryVotage =?,battryType =?,LenseBrand =?,LenseSize =?,qty =?,price =?WHERE caId=?",
                camara.getCaId(),
                camara.getBrand(),
                camara.getCampany(),
                camara.getBodyType(),
                camara.getClour(),
                camara.getLenseType(),
                camara.getPixels(),
                camara.getFlashers(),
                camara.getRemoteControol(),
                camara.getWifi(),
                camara.getBloototh(),
                camara.getUsb(),
                camara.getBatreyDuration(),
                camara.getBattryVotage(),
                camara.getBattryType(),
                camara.getLenseBrand(),
                camara.getLenseSize(),
                camara.getQty(),
                camara.getPrice(),
                 camara.getCaId()
        ) > 0;
    }

    @Override
    public boolean delete(String caId) throws Exception {
        //return CrudUtil.executeUpdate("Delete from camara where caid='"   +caId+"'")>0;
                
        return CrudUtil.executeUpdate("DELETE From camara where caId=?", caId) > 0;
    }

    @Override
    public Camara search(String caId) throws Exception {
            ResultSet rst = CrudUtil.executeQuery("Select * from camera where caId=?", caId);
        if (rst.next()) {
            return new Camara(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9), 
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16),
                    rst.getString(17),
                    rst.getInt(18),
                    rst.getDouble(19));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Camara> getAll() throws Exception {
        ArrayList<CamaraDTO> getAll = new ArrayList<>();
        String SQL = "select *from Camara";
        Connection conn = DBConnection.getInstance().getConnection();
//        Statement stm=conn.createStatement();
//        ResultSet rst= stm.executeU
return  null;

    }

    @Override
    public ArrayList<String> getLoodAllCategory() throws Exception {
       Connection connection=DBConnection.getInstance().getConnection();
       java.sql.Statement stm=connection.createStatement();
       ResultSet rst=stm.executeQuery("select categoryType from camCategory");
       ArrayList<String>tid=new ArrayList<>();
        while (rst.next()) {
            tid.add(rst.getString("categoryType"));
            
        }
        return tid;
    }

    @Override
    public ArrayList<String> getAllBrand() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        java.sql.Statement stm=connection.createStatement();
//        ResultSet rst=stm.executeQuery("select  camara from   brand")
        return null;
    }

    @Override
    public ArrayList<String> getBrand() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       java.sql.Statement stm=connection.createStatement();
       ResultSet rst=stm.executeQuery("select brand from camara");
       ArrayList<String>brand=new ArrayList<>();
        while (rst.next()) {
            brand.add(rst.getString("brand"));
            
        }
        return brand;
    }

    @Override
    public ArrayList<String> getAllType() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       java.sql.Statement stm=connection.createStatement();
       ResultSet rst=stm.executeQuery("select caid from camara");
       ArrayList<String>campany=new ArrayList<>();
        while (rst.next()) {
            campany.add(rst.getString("caid"));
            
        }
        return campany;
    }

    @Override
    public ArrayList<String> getLencesType() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
       java.sql.Statement stm=connection.createStatement();
       ResultSet rst=stm.executeQuery("select lenseType from camara");
       ArrayList<String>lenseType=new ArrayList<>();
        while (rst.next()) {
            lenseType.add(rst.getString("lenseType"));
            
        }
        return lenseType;
    }

    @Override
    public ArrayList<Camara> getAllCamaras() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From camara");
        ArrayList<Camara> allCamara = new ArrayList<>();

        while (rst.next()) {

            Camara camara = new Camara(
                rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16), 
                    rst.getString(17),
                    rst.getInt(18),
                    rst.getDouble(19)
            );
            allCamara.add(camara);
        }
        return allCamara;
    }

    @Override
    public ArrayList<Camara> serchCameraBrand(String camaraBrand) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from camara where brand=?",camaraBrand);
        ArrayList<Camara> allCamara = new ArrayList<>();
        while (rst.next()) {
            Camara camara = new Camara(
                    rst.getString(1), 
                    rst.getString(2), 
                    rst.getString(3), 
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14),
                    rst.getString(15),
                    rst.getString(16), 
                    rst.getString(17),
                    rst.getInt(18),
                    rst.getDouble(19)
            );
            allCamara.add(camara);
        }
        return allCamara;
    }

    @Override
    public ArrayList<Camara> serchCameraID(String camaraID) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from camara where caid=?",camaraID);
        ArrayList<Camara> allCamara = new ArrayList<>();
        while (rst.next()) {
            Camara camara = new Camara(
                    rst.getString("caid"), 
                    rst.getString("brand"), 
                    rst.getString("campany"), 
                    rst.getString("bodyType"),
                    rst.getString("clour"),
                    rst.getString("lenseType"),
                    rst.getString("pixels"),
                    rst.getString("Flashers"),
                    rst.getString("RemoteControol"),
                    rst.getString("wifi"),
                    rst.getString("bloototh"),
                    rst.getString("usb"),
                    rst.getString("BatreyDuration"),
                    rst.getString("battryVotage"),
                    rst.getString("battryType"),
                    rst.getString("LenseBrand"), 
                    rst.getString("LenseSize"),
                    rst.getInt("qty"),
                    rst.getDouble("price")
            );
            allCamara.add(camara);
        }
        return allCamara;
    }

    @Override
    public ArrayList<Camara> serchCameraLanceType(String lanceType) throws Exception {
        System.out.println("00000LT-->"+lanceType);
        ResultSet rst = CrudUtil.executeQuery("Select * from camara where lenseType=?",lanceType);
        ArrayList<Camara> allCamara = new ArrayList<>();
        while (rst.next()) {
            Camara camara = new Camara(
                    rst.getString("caid"), 
                    rst.getString("brand"), 
                    rst.getString("campany"), 
                    rst.getString("bodyType"),
                    rst.getString("clour"),
                    rst.getString("lenseType"),
                    rst.getString("pixels"),
                    rst.getString("Flashers"),
                    rst.getString("RemoteControol"),
                    rst.getString("wifi"),
                    rst.getString("bloototh"),
                    rst.getString("usb"),
                    rst.getString("BatreyDuration"),
                    rst.getString("battryVotage"),
                    rst.getString("battryType"),
                    rst.getString("LenseBrand"), 
                    rst.getString("LenseSize"),
                    rst.getInt("qty"),
                    rst.getDouble("price")
            );
            allCamara.add(camara);
        }
        return allCamara;
    }

    @Override
    public ArrayList<Camara> serchCamera(String camaraBrand, String leanceType) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * from camara where brand=? AND lenseType=?;",camaraBrand,leanceType);
        ArrayList<Camara> allCamara = new ArrayList<>();
        while (rst.next()) {
            Camara camara = new Camara(
                    rst.getString("caid"), 
                    rst.getString("brand"), 
                    rst.getString("campany"), 
                    rst.getString("bodyType"),
                    rst.getString("clour"),
                    rst.getString("lenseType"),
                    rst.getString("pixels"),
                    rst.getString("Flashers"),
                    rst.getString("RemoteControol"),
                    rst.getString("wifi"),
                    rst.getString("bloototh"),
                    rst.getString("usb"),
                    rst.getString("BatreyDuration"),
                    rst.getString("battryVotage"),
                    rst.getString("battryType"),
                    rst.getString("LenseBrand"), 
                    rst.getString("LenseSize"),
                    rst.getInt("qty"),
                    rst.getDouble("price")
            );
            allCamara.add(camara);
        }
        return allCamara;
    }

    @Override
    public boolean updateCam(Camara camara) throws Exception {
       return CrudUtil.executeUpdate("Update camara SET  Qty=qty-? WHERE caid=? ",
                camara.getQty(),
                camara.getCaId()
        ) > 0;
    }

    @Override
    public boolean updateQty(Camara camara) throws Exception {
        return CrudUtil.executeUpdate("update camara set qty=qty-? where caid=?", camara.getQty(),camara.getCaId())>0;
    }

    @Override
    public boolean saveReturn(ReturnItem returnItem) throws Exception {
        return CrudUtil.executeUpdate("Insert into ReturnItem values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",returnItem.getRid(),returnItem.getCid(),returnItem.getOid(),returnItem.getCaid(),returnItem.getName(),returnItem.getNIC(),returnItem.getBrand(),returnItem.getLenseBrand(),returnItem.getLenseSize(),returnItem.getPrice(),returnItem.getQty(),returnItem.getFullTotal(),returnItem.getPayAmount(),returnItem.getBlance(),returnItem.getDamages())>0;
    }

    @Override
    public ArrayList<ReturnItemDTO> allReurn() throws Exception {
        ResultSet rst=CrudUtil.executeQuery("select *from ReturnItem");
        ArrayList<ReturnItemDTO>allReurn=new ArrayList<>();
        while (rst.next()) {            
            ReturnItemDTO returnItemDTO=new ReturnItemDTO(rst.getString(1),
            rst.getString(2),
            rst.getString(3),
            rst.getString(4),
            rst.getString(5),
            rst.getString(6),
            rst.getString(7),
            rst.getString(8),
            rst.getString(9),
            rst.getDouble(10),
            rst.getInt(11),
            rst.getDouble(12), 
            rst.getDouble(13),
            rst.getDouble(14),
            rst.getString(15)
            
            
            
            
            );
            allReurn.add(returnItemDTO);
        }
        return allReurn;
    }

    @Override
    public ReturnItemDTO SearchBuNic(String nic) throws Exception {
       return  null;
    }

}
