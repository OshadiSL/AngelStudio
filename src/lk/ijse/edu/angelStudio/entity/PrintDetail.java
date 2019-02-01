/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.entity;

/**
 *
 * @author Oshadi
 */
public class PrintDetail {
     private String prid;
    private String oid;
    private int qty;
    private double price;

    public PrintDetail() {
    }

    public PrintDetail(String prid, String oid, int qty, double price) {
        this.prid = prid;
        this.oid = oid;
        this.qty = qty;
        this.price = price;
    }

    /**
     * @return the prid
     */
    public String getPrid() {
        return prid;
    }

    /**
     * @param prid the prid to set
     */
    public void setPrid(String prid) {
        this.prid = prid;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PrintDetail{" + "prid=" + prid + ", oid=" + oid + ", qty=" + qty + ", price=" + price + '}';
    }
    
    
}
