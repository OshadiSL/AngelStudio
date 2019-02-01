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
public class Customer {
    private String cid;
    private String name;
    private String address;
    private String mNum;
    private String NIC;

    public Customer() {
    }

    public Customer(String cid, String name, String address, String mNum, String NIC) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.mNum = mNum;
        this.NIC = NIC;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the mNum
     */
    public String getmNum() {
        return mNum;
    }

    /**
     * @param mNum the mNum to set
     */
    public void setmNum(String mNum) {
        this.mNum = mNum;
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

    
}
