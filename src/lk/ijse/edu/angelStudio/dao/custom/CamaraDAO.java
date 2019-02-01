/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.ReturnItem;
import lk.ijse.edu.angleStudio.dao.CrudDAO;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public interface CamaraDAO extends CrudDAO<Camara, String>{

    public ArrayList<String> getLoodAllCategory()throws Exception;

    public ArrayList<String> getAllBrand()throws Exception;

    public ArrayList<String> getBrand()throws Exception;

    public ArrayList<String> getAllType()throws Exception;

    public ArrayList<String> getLencesType()throws Exception;

    public ArrayList<Camara> getAllCamaras()throws Exception;
    //new
    public ArrayList<Camara> serchCameraBrand(String camaraBrand) throws Exception;
    
    public ArrayList<Camara> serchCameraID(String camaraID) throws Exception;
    
    public ArrayList<Camara> serchCameraLanceType(String lanceType) throws Exception;
    
    public ArrayList<Camara> serchCamera(String camaraBrand,String leanceType) throws Exception;

    public boolean updateCam(Camara camara)throws Exception;

    public boolean updateQty(Camara camara)throws Exception;

    public boolean saveReturn(ReturnItem returnItem)throws Exception;

    public ArrayList<ReturnItemDTO> allReurn()throws Exception;

    public ReturnItemDTO SearchBuNic(String nic)throws Exception;

  




    
    
    
}
