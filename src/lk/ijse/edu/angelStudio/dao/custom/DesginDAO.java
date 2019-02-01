/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.dao.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.CrudDAO;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public interface DesginDAO extends CrudDAO<Desgin, String>{

    public ArrayList<String> getAllDesign()throws Exception;

    public ArrayList<DesginDTO> getAllDising()throws Exception;

    public Desgin lodddAllPrice(String price)throws Exception;

    public boolean updateQty(Desgin desgin) throws Exception;

    public boolean add(Desgin desgin)throws Exception;


   
    
}
