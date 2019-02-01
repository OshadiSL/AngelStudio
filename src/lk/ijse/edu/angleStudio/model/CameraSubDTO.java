/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angleStudio.model;

/**
 *
 * @author Uvindu Mohotti
 */
public class CameraSubDTO {
    private String caid;
    private int qty;

    public CameraSubDTO() {
    }

    public CameraSubDTO(String caid, int qty) {
        this.caid = caid;
        this.qty = qty;
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
    
}
