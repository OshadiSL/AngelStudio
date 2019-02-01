/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.controller;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.CamaraBO;
import lk.ijse.edu.angelStudio.business.custom.DesginBO;
import lk.ijse.edu.angelStudio.business.custom.impl.CamaraBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.DesgineBOImpl;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public class ManageDesignController {
    private static DesginBO desginBO=new DesgineBOImpl();


    public static ArrayList<String> getAllDesign() throws Exception {
        return desginBO.getAllDesign();
    }

    public static ArrayList<DesginDTO> getAllDising() throws Exception {
        return desginBO.getAllDesing();
    }

    public static Desgin loardAmount(String did) throws Exception {
        return desginBO.getLoardAmount(did);
    }

    public static boolean addDising(DesginDTO desgin)throws Exception{
        return desginBO.add(desgin);
    }

    public static boolean delete(String toString)throws Exception{
        return desginBO.delete(toString);
    }

    public static boolean dudate(DesginDTO desgin)throws Exception{
        return desginBO.update(desgin);
    }

    

    
}