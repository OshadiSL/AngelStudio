/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angleStudio.model;

/**
 *
 * @author Oshadi
 */
public class RantPaymentDTO {
    private String prid;
    private String caId;
    private String date;
    private double  advance;
    private double total;
    private double blance;

    public RantPaymentDTO() {
    }

    public RantPaymentDTO(String prid, String caId, String date, double advance, double total, double blance) {
        this.prid = prid;
        this.caId = caId;
        this.date = date;
        this.advance = advance;
        this.total = total;
        this.blance = blance;
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
     * @return the caId
     */
    public String getCaId() {
        return caId;
    }

    /**
     * @param caId the caId to set
     */
    public void setCaId(String caId) {
        this.caId = caId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "RantPaymentDTO{" + "prid=" + prid + ", caId=" + caId + ", date=" + date + ", advance=" + advance + ", total=" + total + ", blance=" + blance + '}';
    }
    
    
}
