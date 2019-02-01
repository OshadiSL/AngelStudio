/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.controller;

import lk.ijse.edu.angelStudio.business.custom.CustomerBO;
import lk.ijse.edu.angelStudio.business.custom.impl.CustomerBOImpl;
import lk.ijse.edu.angleStudio.model.CamaraDetailDTO;
import lk.ijse.edu.angleStudio.model.CommonDTO;
import lk.ijse.edu.angleStudio.model.CustomerDTO;
import lk.ijse.edu.angleStudio.model.DesginDetailDTO;
import lk.ijse.edu.angleStudio.model.OrdersDTO;
import lk.ijse.edu.angleStudio.model.PaymentDTO;
import lk.ijse.edu.angleStudio.model.PrintDetailDTO;

/**
 *
 * @author Oshadi
 */
public class HomeController {
    private static CustomerBO customerBo=new CustomerBOImpl();


    public static boolean SaveDetails(CommonDTO common) throws Exception {
        return customerBo.save(common);
    }
}
