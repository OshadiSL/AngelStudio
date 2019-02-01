/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angleStudio.model;

import java.beans.DesignMode;

/**
 *
 * @author Oshadi
 */
public class CommonDTO {
    private CamaraDetailDTO cameraDetail;
    private PrintDetailDTO printDetail;
    private DesginDetailDTO designDetail;
    private CustomerDTO customer;
    private OrdersDTO order;
    private PaymentDTO payment;
    private boolean isCamera;
    private boolean isPrint;
    private boolean isDesign;
    private CameraSubDTO cameraSub;
    private PrintSubDTO printSub;
    private DesignSubDTO designSub;

    public CommonDTO() {
    }

    public CommonDTO(CamaraDetailDTO cameraDetail, PrintDetailDTO printDetail, DesginDetailDTO designDetail, CustomerDTO customer, OrdersDTO order, PaymentDTO payment, boolean isCamera, boolean isPrint, boolean isDesign, CameraSubDTO cameraSub, PrintSubDTO printSub, DesignSubDTO designSub) {
        this.cameraDetail = cameraDetail;
        this.printDetail = printDetail;
        this.designDetail = designDetail;
        this.customer = customer;
        this.order = order;
        this.payment = payment;
        this.isCamera = isCamera;
        this.isPrint = isPrint;
        this.isDesign = isDesign;
        this.cameraSub = cameraSub;
        this.printSub = printSub;
        this.designSub = designSub;
    }

    /**
     * @return the cameraDetail
     */
    public CamaraDetailDTO getCameraDetail() {
        return cameraDetail;
    }

    /**
     * @param cameraDetail the cameraDetail to set
     */
    public void setCameraDetail(CamaraDetailDTO cameraDetail) {
        this.cameraDetail = cameraDetail;
    }

    /**
     * @return the printDetail
     */
    public PrintDetailDTO getPrintDetail() {
        return printDetail;
    }

    /**
     * @param printDetail the printDetail to set
     */
    public void setPrintDetail(PrintDetailDTO printDetail) {
        this.printDetail = printDetail;
    }

    /**
     * @return the designDetail
     */
    public DesginDetailDTO getDesignDetail() {
        return designDetail;
    }

    /**
     * @param designDetail the designDetail to set
     */
    public void setDesignDetail(DesginDetailDTO designDetail) {
        this.designDetail = designDetail;
    }

    /**
     * @return the customer
     */
    public CustomerDTO getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    /**
     * @return the order
     */
    public OrdersDTO getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(OrdersDTO order) {
        this.order = order;
    }

    /**
     * @return the payment
     */
    public PaymentDTO getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    /**
     * @return the isCamera
     */
    public boolean isIsCamera() {
        return isCamera;
    }

    /**
     * @param isCamera the isCamera to set
     */
    public void setIsCamera(boolean isCamera) {
        this.isCamera = isCamera;
    }

    /**
     * @return the isPrint
     */
    public boolean isIsPrint() {
        return isPrint;
    }

    /**
     * @param isPrint the isPrint to set
     */
    public void setIsPrint(boolean isPrint) {
        this.isPrint = isPrint;
    }

    /**
     * @return the isDesign
     */
    public boolean isIsDesign() {
        return isDesign;
    }

    /**
     * @param isDesign the isDesign to set
     */
    public void setIsDesign(boolean isDesign) {
        this.isDesign = isDesign;
    }

    /**
     * @return the cameraSub
     */
    public CameraSubDTO getCameraSub() {
        return cameraSub;
    }

    /**
     * @param cameraSub the cameraSub to set
     */
    public void setCameraSub(CameraSubDTO cameraSub) {
        this.cameraSub = cameraSub;
    }

    /**
     * @return the printSub
     */
    public PrintSubDTO getPrintSub() {
        return printSub;
    }

    /**
     * @param printSub the printSub to set
     */
    public void setPrintSub(PrintSubDTO printSub) {
        this.printSub = printSub;
    }

    /**
     * @return the designSub
     */
    public DesignSubDTO getDesignSub() {
        return designSub;
    }

    /**
     * @param designSub the designSub to set
     */
    public void setDesignSub(DesignSubDTO designSub) {
        this.designSub = designSub;
    }

    
    
}
