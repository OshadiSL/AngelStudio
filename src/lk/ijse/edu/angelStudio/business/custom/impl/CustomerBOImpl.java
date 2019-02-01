/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom.impl;

import java.sql.Connection;
import lk.ijse.edu.angelStudio.business.custom.CustomerBO;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDAO;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDetailDAO;
import lk.ijse.edu.angelStudio.dao.custom.CustomerDAO;
import lk.ijse.edu.angelStudio.dao.custom.DesginDAO;
import lk.ijse.edu.angelStudio.dao.custom.DesginDetailDAO;
import lk.ijse.edu.angelStudio.dao.custom.OrdersDAO;
import lk.ijse.edu.angelStudio.dao.custom.PaymentDAO;
import lk.ijse.edu.angelStudio.dao.custom.PrintDAO;
import lk.ijse.edu.angelStudio.dao.custom.PrintDetailDAO;
import lk.ijse.edu.angelStudio.dao.custom.impl.CamaraDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CamaraDetailDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.DesginTypeDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.DesingDetailsDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.OrderDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.PrintDetailDAOImpl;
import lk.ijse.edu.angelStudio.dao.custom.impl.printDAOImpl;
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
import lk.ijse.edu.angleStudio.model.CommonDTO;

/**
 *
 * @author Oshadi
 */
public class CustomerBOImpl implements CustomerBO {

    private static CustomerDAO customerDao = new CustomerDAOImpl();
    private static OrdersDAO ordersDao = new OrderDAOImpl();
    private static PrintDetailDAO printDetail = new PrintDetailDAOImpl();
    private static DesginDetailDAO DesginDetailDAo = new DesingDetailsDAOImpl();
    private static CamaraDetailDAO camaraDetailDAO = new CamaraDetailDAOImpl();
    private static PaymentDAO paymentDAO = new PaymentDAOImpl();
    private static CamaraDAO cameraDAO = new CamaraDAOImpl();
    private static PrintDAO printDAO = new printDAOImpl();
    private static DesginDAO designDAO = new DesginTypeDAOImpl();

    @Override
    public boolean save(CommonDTO common) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        conn.setAutoCommit(false);
        try {
            if (common.isIsCamera() || common.isIsDesign() || common.isIsPrint()) {
                boolean result = customerDao.save(new Customer(common.getCustomer().getCid(), common.getCustomer().getName(), common.getCustomer().getAddress(), common.getCustomer().getmNum(), common.getCustomer().getNic()));
                if (!result) {
                    return false;
                }

                result = ordersDao.save(new Orders(common.getOrder().getOid(), common.getOrder().getCid(), common.getOrder().getTime(), common.getOrder().getDate(), common.getOrder().getStatus()));
                if (!result) {
                    conn.rollback();
                    return false;
                }
                if (common.isIsCamera()) {
                    result = camaraDetailDAO.save(new CamaraDetail(common.getCameraDetail().getCaid(), common.getCameraDetail().getOid(), common.getCameraDetail().getQty(), common.getCameraDetail().getPrice()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }
                    result = cameraDAO.updateQty(new Camara(common.getCameraSub().getCaid(), common.getCameraSub().getQty()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }

                }
                if (common.isIsPrint()) {
                    result = printDetail.save(new PrintDetail(common.getPrintDetail().getPrid(), common.getPrintDetail().getOid(), common.getPrintDetail().getQty(), common.getPrintDetail().getPrice()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }
                    result = printDAO.updateQty(new Print(common.getPrintSub().getPrid(), common.getPrintSub().getQty()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }
                }
                if (common.isIsDesign()) {
                    result = DesginDetailDAo.save(new DesginDetail(common.getDesignDetail().getDid(), common.getDesignDetail().getOid(), common.getDesignDetail().getQty(), common.getDesignDetail().getPrice()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }
                    result = designDAO.updateQty(new Desgin(common.getDesignSub().getDid(), common.getDesignSub().getQty()));
                    if (!result) {
                        conn.rollback();
                        return false;
                    }
                }

                result = paymentDAO.save(new Payment(common.getPayment().getPyid(), common.getPayment().getOid(), common.getPayment().getTotal(), common.getPayment().getAdvance(), common.getPayment().getAmount(), common.getPayment().getOrderType(), common.getPayment().getBlance(), common.getPayment().getPaymentType()));
                if (!result) {
                    conn.rollback();
                    return false;
                }
            }
            conn.commit();
            return true;
        } finally {
            conn.rollback();
            conn.setAutoCommit(true);
        }
    }
}
