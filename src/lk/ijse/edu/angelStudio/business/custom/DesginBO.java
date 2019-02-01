/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.SuperBO;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.SuperDAO;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public interface DesginBO extends SuperBO{

    public ArrayList<String> getAllDesign()throws Exception;

    public ArrayList<DesginDTO> getAllDesing()throws Exception;

    public Desgin getLoardAmount(String did)throws Exception;

    public boolean add(DesginDTO desgin)throws Exception;

    public boolean delete(String toString)throws Exception;

    public boolean update(DesginDTO desgin)throws Exception;
    
}
