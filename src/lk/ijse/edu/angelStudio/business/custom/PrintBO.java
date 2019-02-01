/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.SuperDAO;
import lk.ijse.edu.angleStudio.model.PrintDTO;

/**
 *
 * @author Oshadi
 */
public interface PrintBO extends SuperDAO {

    public ArrayList<String> getLoardPrintName() throws Exception;

    public ArrayList<Print> getAll() throws Exception;

    public Print loardAmount(String did) throws Exception;

    public boolean delete(String toString)throws Exception;

    public boolean add(PrintDTO print)throws Exception;

    public boolean update(PrintDTO print)throws Exception;

}
