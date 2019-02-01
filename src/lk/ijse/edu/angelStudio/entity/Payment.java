/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.entity;

import lk.ijse.edu.angleStudio.model.*;

/**
 *
 * @author Oshadi
 */
public class Payment {
     private String pyid;
    private String oid;
    private double total;
    private double advance;
    private double  amount;
    private String orderType;
    private double blance;
    private String paymentType;


    public Payment() {
    }

    public Payment(String pyid, String oid, double total, double advance, double amount, String orderType, double blance, String paymentType) {
        this.pyid = pyid;
        this.oid = oid;
        this.total = total;
        this.advance = advance;
        this.amount = amount;
        this.orderType = orderType;
        this.blance = blance;
        this.paymentType = paymentType;
    }

    /**
     * @return the pyid
     */
    public String getPyid() {
        return pyid;
    }

    /**
     * @param pyid the pyid to set
     */
    public void setPyid(String pyid) {
        this.pyid = pyid;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the orderType
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the blance
     */
    public double getBlance() {
        return blance;
    }

    /**
     * @param blance the blance to set
     */
    public void setBlance(double blance) {
        this.blance = blance;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" + "pyid=" + pyid + ", oid=" + oid + ", total=" + total + ", advance=" + advance + ", amount=" + amount + ", orderType=" + orderType + ", blance=" + blance + ", paymentType=" + paymentType + '}';
    }

   
}
