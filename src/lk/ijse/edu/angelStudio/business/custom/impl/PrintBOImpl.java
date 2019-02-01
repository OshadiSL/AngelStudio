/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.PrintBO;
import lk.ijse.edu.angelStudio.dao.custom.PrintDAO;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.dao.DAOFactory;
import lk.ijse.edu.angleStudio.model.PrintDTO;

/**
 *
 * @author Oshadi
 */
public class PrintBOImpl implements PrintBO {

    private PrintDAO printDAO;

    public PrintBOImpl() {
        this.printDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRINT);
    }

    @Override
    public ArrayList<String> getLoardPrintName() throws Exception {
        return printDAO.getLoardPrint();
    }

    @Override
    public ArrayList<Print> getAll() throws Exception {
        ArrayList<PrintDTO> allPrint = new ArrayList<>();
        return printDAO.getAll();
    }

    @Override
    public Print loardAmount(String did) throws Exception {
        return printDAO.loardAmount(did);
    }

    @Override
    public boolean delete(String toString) throws Exception {
        return printDAO.delete(toString);
    }

    @Override
    public boolean add(PrintDTO print) throws Exception {
        return printDAO.save(new Print(print.getPrid(), print.getName(), print.getType(), print.getSize(), print.getPrice(), print.getQty()));
    }

    @Override
    public boolean update(PrintDTO print) throws Exception {
        return printDAO.update(new Print(print.getPrid(), print.getName(), print.getType(), print.getSize(), print.getPrice(), print.getQty()));

    }

}
