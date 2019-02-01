/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.controller;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.PrintBO;
import lk.ijse.edu.angelStudio.business.custom.impl.PrintBOImpl;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.model.PrintDTO;

/**
 *
 * @author Oshadi
 */
public class ManagePrintController {
    private static PrintBO printBO=new PrintBOImpl();
    public static ArrayList<String> getAllLoardPrintName() throws Exception {
        return printBO.getLoardPrintName();
    }

    public static ArrayList<Print> getAll() throws Exception {
        return printBO.getAll();
    }

    public static Print loardAmount(String did) throws Exception {
        return printBO.loardAmount(did);
    }

    public static boolean delete(String toString)throws Exception{
        return printBO.delete(toString);
    }

    public static boolean add(PrintDTO print)throws Exception{
        return printBO.add(print);
    }

    public static boolean update(PrintDTO print)throws Exception{
        return printBO.update(print);
    }

   

   
    
}
