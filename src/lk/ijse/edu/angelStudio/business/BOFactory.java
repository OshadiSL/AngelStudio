/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business;

import lk.ijse.edu.angelStudio.business.custom.impl.CamaraBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.CategoryDetailBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.CustomerBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.OrderBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.OrderDetailBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.PaymentBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.RantPaymentBOImpl;

/**
 *
 * @author Oshadi
 */
public class BOFactory {
    public enum BOType{
        Customer,Camara,Category,CategoryDetail,OrderDetail,Orders,Payment,RantPayment
    }
    private static BOFactory bOFactory;
    public BOFactory() {
    }
    public  static BOFactory getInstance(){
        if(bOFactory==null){
           bOFactory=new BOFactory();
        }
        return bOFactory;
    }
    public <T>T getBO(BOType bOTypes){
        switch(bOTypes){
            case Customer:
                return (T)new CustomerBOImpl();
            case Camara:
                return (T)new CamaraBOImpl();
            case Category:
                return (T)new CategoryDetailBOImpl();
            case CategoryDetail:
                return (T)new CategoryDetailBOImpl();
            case OrderDetail:
                return (T)new OrderDetailBOImpl();
            case Orders:
                return (T)new OrderBOImpl();
            case Payment:
                return (T)new PaymentBOImpl();
            case RantPayment:
                return (T)new RantPaymentBOImpl();
            default:
                return null;
        }
    }
}
