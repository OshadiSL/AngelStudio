/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.DesginBO;
import lk.ijse.edu.angelStudio.dao.custom.DesginDAO;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.DAOFactory;
import lk.ijse.edu.angleStudio.model.DesginDTO;

/**
 *
 * @author Oshadi
 */
public class DesgineBOImpl implements DesginBO{
    private DesginDAO desginDAO;
    public DesgineBOImpl(){
        this.desginDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DESINGTYPE);
    }
    /*
    
    public ArrayList<String> getLoardPrintName() throws Exception {
        return printDAO.getLoardPrint();
    }
    */
    @Override
    public ArrayList<String> getAllDesign() throws Exception {
        return desginDAO.getAllDesign();
    }

    @Override
    public ArrayList<DesginDTO> getAllDesing() throws Exception {
        ArrayList<DesginDTO>addDising=new ArrayList<>();
        return desginDAO.getAllDising();
        
    }

    @Override
    public Desgin getLoardAmount(String did) throws Exception {
        return desginDAO.lodddAllPrice(did); 

    }

    @Override
    public boolean add(DesginDTO desgin) throws Exception {
        return desginDAO.add(new Desgin(desgin.getDid(),
                desgin.getType(),
                desgin.getSize(),
                desgin.getPrice(),
                desgin.getQty()
        ));
    }

    @Override
    public boolean delete(String toString) throws Exception {
        return desginDAO.delete(toString);
    }

    @Override
    public boolean update(DesginDTO desgin) throws Exception {
                return desginDAO.update(new Desgin(
                        desgin.getDid(),
                        desgin.getType(),
                        desgin.getSize(),
                        desgin.getPrice(),
                        desgin.getQty()
                ));

    }
    
}
