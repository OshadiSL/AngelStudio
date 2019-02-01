/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angleStudio.model;

/**
 *
 * @author acer
 */
public class ReturnItemDTO {

    private String rid;
    private String cid;
    private String oid;
    private String caid;
    private String name;
    private String NIC;
    private String brand;
    private String LenseBrand;
    private String LenseSize;
    private double price;
    private int qty;
    private double fullTotal;
    private double payAmount;
    private double blance;
    private String damages;

    public ReturnItemDTO() {
    }

    public ReturnItemDTO(String rid, String cid, String oid, String caid, String name, String NIC, String brand, String LenseBrand, String LenseSize, double price, int qty, double fullTotal, double payAmount, double blance, String damages) {
        this.rid = rid;
        this.cid = cid;
        this.oid = oid;
        this.caid = caid;
        this.name = name;
        this.NIC = NIC;
        this.brand = brand;
        this.LenseBrand = LenseBrand;
        this.LenseSize = LenseSize;
        this.price = price;
        this.qty = qty;
        this.fullTotal = fullTotal;
        this.payAmount = payAmount;
        this.blance = blance;
        this.damages = damages;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
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
     * @return the caid
     */
    public String getCaid() {
        return caid;
    }

    /**
     * @param caid the caid to set
     */
    public void setCaid(String caid) {
        this.caid = caid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the LenseBrand
     */
    public String getLenseBrand() {
        return LenseBrand;
    }

    /**
     * @param LenseBrand the LenseBrand to set
     */
    public void setLenseBrand(String LenseBrand) {
        this.LenseBrand = LenseBrand;
    }

    /**
     * @return the LenseSize
     */
    public String getLenseSize() {
        return LenseSize;
    }

    /**
     * @param LenseSize the LenseSize to set
     */
    public void setLenseSize(String LenseSize) {
        this.LenseSize = LenseSize;
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
     * @return the fullTotal
     */
    public double getFullTotal() {
        return fullTotal;
    }

    /**
     * @param fullTotal the fullTotal to set
     */
    public void setFullTotal(double fullTotal) {
        this.fullTotal = fullTotal;
    }

    /**
     * @return the payAmount
     */
    public double getPayAmount() {
        return payAmount;
    }

    /**
     * @param payAmount the payAmount to set
     */
    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
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
     * @return the damages
     */
    public String getDamages() {
        return damages;
    }

    /**
     * @param damages the damages to set
     */
    public void setDamages(String damages) {
        this.damages = damages;
    }

    @Override
    public String toString() {
        return "ReturnItemDTO{" + "rid=" + rid + ", cid=" + cid + ", oid=" + oid + ", caid=" + caid + ", name=" + name + ", NIC=" + NIC + ", brand=" + brand + ", LenseBrand=" + LenseBrand + ", LenseSize=" + LenseSize + ", price=" + price + ", qty=" + qty + ", fullTotal=" + fullTotal + ", payAmount=" + payAmount + ", blance=" + blance + ", damages=" + damages + '}';
    }

   

}
