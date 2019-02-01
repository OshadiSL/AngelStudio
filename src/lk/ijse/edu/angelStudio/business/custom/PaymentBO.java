/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.SuperBO;
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
public interface PaymentBO extends SuperBO{
    public boolean  addTrancation(
            CustomerDTO customerDTO,
            OrdersDTO ordersDTO,
            ArrayList<PrintDetailDTO> printDetailDTO,
            ArrayList<DesginDetailDTO> desginDetailDTO,
            ArrayList<CamaraDetailDTO> camaraDetailDTO,
            PaymentDTO paymentDTO,
            ArrayList<PrintDTO> printDTO,
            ArrayList<DesginDTO> desginDTO,
            ArrayList<CamaraDTO> camaraDTO
    ) throws Exception;
}
