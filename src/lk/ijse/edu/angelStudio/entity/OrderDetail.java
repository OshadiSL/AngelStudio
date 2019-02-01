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
public class OrderDetail {
    private String odId;
    private String rid;
    private String oid;
    private String pid;

    public OrderDetail() {
    }

    public OrderDetail(String odId, String rid, String oid, String pid) {
        this.odId = odId;
        this.rid = rid;
        this.oid = oid;
        this.pid = pid;
    }

    /**
     * @return the odId
     */
    public String getOdId() {
        return odId;
    }

    /**
     * @param odId the odId to set
     */
    public void setOdId(String odId) {
        this.odId = odId;
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
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "odId=" + odId + ", rid=" + rid + ", oid=" + oid + ", pid=" + pid + '}';
    }
    
    
    
}
