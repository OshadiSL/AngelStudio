/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom.impl;

import com.mysql.jdbc.Connection;
import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.PaymentBO;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDAO;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDetailDAO;
import lk.ijse.edu.angelStudio.dao.custom.CustomerDAO;
import lk.ijse.edu.angelStudio.dao.custom.DesginDAO;
import lk.ijse.edu.angelStudio.dao.custom.DesginDetailDAO;
import lk.ijse.edu.angelStudio.dao.custom.OrdersDAO;
import lk.ijse.edu.angelStudio.dao.custom.PaymentDAO;
import lk.ijse.edu.angelStudio.dao.custom.PrintDAO;
import lk.ijse.edu.angelStudio.dao.custom.PrintDetailDAO;
import lk.ijse.edu.angelStudio.dbConnection.DBConnection;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.CamaraDetail;
import lk.ijse.edu.angelStudio.entity.Customer;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.DesginDetail;
import lk.ijse.edu.angelStudio.entity.Orders;
import lk.ijse.edu.angelStudio.entity.Payment;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angelStudio.entity.PrintDetail;
import lk.ijse.edu.angleStudio.dao.DAOFactory;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.CamaraDetailDTO;
import lk.ijse.edu.angleStudio.model.CustomerDTO;
import lk.ijse.edu.angleStudio.model.DesginDTO;
import lk.ijse.edu.angleStudio.model.DesginDetailDTO;
import lk.ijse.edu.angleStudio.model.OrdersDTO;
import lk.ijse.edu.angleStudio.model.PaymentDTO;
import lk.ijse.edu.angleStudio.model.PrintDTO;
import lk.ijse.edu.angleStudio.model.PrintDetailDTO;

/**
 *
 * @author Oshadi
 */
public class PaymentBOImpl implements PaymentBO {

    private final CustomerDAO customerDAO;
    private final OrdersDAO ordersDAO;
    private final PrintDetailDAO printDetailDAO;
    private final DesginDetailDAO desginDetailDAO;
    private final CamaraDetailDAO camaraDetailDAO;
    private final PaymentDAO paymentDAO;
    private final PrintDAO printDAO;
    private final DesginDAO desginDAO;
    private final CamaraDAO camaraDAO;

    public PaymentBOImpl() {
        customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
        ordersDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERS);
        printDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRINTDETAILS);
        desginDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DESINGDETAILS);
        camaraDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CAMARADETAILS);
        paymentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
        printDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PRINT);
        desginDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DESINGTYPE);
        camaraDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CAMARA);
    }

    @Override
    public boolean addTrancation(CustomerDTO customerDTO, OrdersDTO ordersDTO, ArrayList<PrintDetailDTO> printDetailDTO, ArrayList<DesginDetailDTO> desginDetailDTO, ArrayList<CamaraDetailDTO> camaraDetailDTO, PaymentDTO paymentDTO, ArrayList<PrintDTO> printDTO, ArrayList<DesginDTO> desginDTO, ArrayList<CamaraDTO> camaraDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }