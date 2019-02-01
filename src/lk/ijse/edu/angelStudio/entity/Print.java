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
public class Print {
    private String prid;
    private String name;
    private String type;
    private String size;
    private double price;
    private int qty;

    public Print() {
    }
    
    public Print(String prid,int qty){
        this.prid = prid;
        this.qty = qty;
    }
    public Print(String prid, String name, String type, String size, double price, int qty) {
        this.prid = prid;
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.qty = qty;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
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

    @Override
    public String toString() {
        return "Print{" + "prid=" + prid + ", name=" + name + ", type=" + type + ", size=" + size + ", price=" + price + ", qty=" + qty + '}';
    }
    
    
    
    
}
