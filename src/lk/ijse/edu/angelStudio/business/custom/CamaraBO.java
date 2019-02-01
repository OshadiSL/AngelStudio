/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.SuperBO;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public interface CamaraBO extends SuperBO{

    public ArrayList<String> getLoodAllCategory()throws Exception;

    public ArrayList<String> getAllBrand()throws Exception;

    public ArrayList<String> getBrand()throws Exception;

    public ArrayList<String> getAllType()throws Exception;

    public ArrayList<String> getLencesType()throws Exception;

    public ArrayList<Camara> getAllCamaras()throws Exception;

    public boolean save(CamaraDTO camara)throws Exception;
    
    public ArrayList<CamaraDTO> serchCameraBrand(String camaraBrand) throws Exception;
    
    public ArrayList<CamaraDTO> serchCameraID(String camaraID) throws Exception;
    
    public ArrayList<CamaraDTO> serchCameraLancetype(String leanceType) throws Exception;
    
    public ArrayList<CamaraDTO> serchCamera(String camaraBrand,String leanceType) throws Exception;

    public boolean saveaaaa(CamaraDTO camara)throws Exception;

    public boolean delete(String toString)throws Exception;

    public boolean update(CamaraDTO camara)throws Exception;

    public boolean saveReturn(ReturnItemDTO item)throws Exception;

    public ArrayList<ReturnItemDTO> getAllReturn()throws Exception;

    public ReturnItemDTO SearchBuNic(String nic)throws Exception;

    
}
