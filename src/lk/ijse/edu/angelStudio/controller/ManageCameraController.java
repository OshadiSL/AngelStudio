/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.Camera;
import lk.ijse.edu.angelStudio.business.custom.CamaraBO;
import lk.ijse.edu.angelStudio.business.custom.impl.CamaraBOImpl;
import lk.ijse.edu.angelStudio.dbConnection.DBConnection;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public class ManageCameraController {

    private static CamaraBO camaraBO = new CamaraBOImpl();

    public static ArrayList<String> getLoardAllCategory() throws Exception {
        return camaraBO.getLoodAllCategory();

    }

    public static ArrayList<String> getAllBrand() {
        return null;
//       return camaraBO.getAllBrand();
    }

    public static ArrayList<String> getBrand() throws Exception {
       return camaraBO.getBrand();
    }

    public static ArrayList<String> getAllTypes() throws Exception {
        return camaraBO.getAllType();
    }

    public static ArrayList<String> getLencesTypes() throws Exception {
        return camaraBO.getLencesType();
    }

    public static ArrayList<Camara> getAllCamaras() throws Exception {
        return camaraBO.getAllCamaras();
        
    }

    public static boolean save(CamaraDTO camara)throws Exception{
        return camaraBO.save(camara);
    }

    public static boolean saveaaaa(CamaraDTO camara)throws Exception{
        return camaraBO.saveaaaa(camara);
    }

    public static boolean delete(String toString) throws Exception {
        return camaraBO.delete(toString);
    }

    public static boolean Update(CamaraDTO camara) throws Exception {
        return camaraBO.update(camara);
    }

    public static boolean saveReturn(ReturnItemDTO item)throws Exception{
        return camaraBO.saveReturn(item);
    }

    public static ArrayList<ReturnItemDTO> getAllReturn()throws Exception{
        return camaraBO.getAllReturn();
    }

    public static ReturnItemDTO SearchBuNic(String nic)throws Exception{
        Connection connection=DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery("Select *from ReturnItem where NIC='"+nic+"'");
        if (rst.next()) {
            return new ReturnItemDTO(rst.getString(1),
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
        }
        return null;
    }

}
