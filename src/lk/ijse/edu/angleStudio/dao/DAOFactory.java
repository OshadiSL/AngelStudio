/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angleStudio.dao;

import lk.ijse.edu.angelStudio.dao.custom.impl.CamaraDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CamaraDetailDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CategoryDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CategoryDetailDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.DesginTypeDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.DesingDetailsDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.OrderDAOImpl;

import lk.ijse.edu.angelStudio.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.PrintDetailDAOImpl;

import lk.ijse.edu.angelStudio.dao.custom.impl.RantPaymentDAOImpl;

import lk.ijse.edu.angelStudio.dao.custom.impl.printDAOImpl;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.Category;
import lk.ijse.edu.angelStudio.entity.CategoryDetail;
import lk.ijse.edu.angelStudio.entity.Customer;
import lk.ijse.edu.angelStudio.entity.OrderDetail;
import lk.ijse.edu.angelStudio.entity.Orders;
import lk.ijse.edu.angelStudio.entity.Payment;

import lk.ijse.edu.angelStudio.entity.RantPayment;

/**
 *
 * @author Oshadi
 */
public class DAOFactory {

    public enum DAOTypes {
        CUSTOMER,CAMARA,CATEGORY,CATEGORYDETAIL,ORDERDETAIL,ORDERS,PAYMENT,DESINGDETAILS,DESINGTYPE,
        RANTPAYMENT,PRINT,PRINTDETAILS,CAMARADETAILS
    }
    private static DAOFactory dAOFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public <T> T getDAO(DAOTypes dAOTypes) {
        switch (dAOTypes) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case CAMARA:
                return (T) new CamaraDAOImpl();
            case CATEGORY:
                return (T) new CategoryDAOImpl();
            case CATEGORYDETAIL:
                return (T) new CategoryDetailDAOImpl();
           
            case ORDERS:
                return (T) new OrderDAOImpl();
            case PAYMENT:
                return (T) new PaymentDAOImpl();
            case DESINGDETAILS:
                return (T) new DesingDetailsDAOImpl();
            case DESINGTYPE:
                return (T) new DesginTypeDAOImpl();
            case RANTPAYMENT:
                return (T) new RantPaymentDAOImpl();
            case PRINT:
                return (T) new printDAOImpl();
            case PRINTDETAILS:
                return (T) new PrintDetailDAOImpl();
            case CAMARADETAILS:
                return (T) new CamaraDetailDAOImpl();
            default:
                return null;
        }
    }
}
