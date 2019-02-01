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
public class CategoryDetail {
    private String caId;
    private String cacid ;

    public CategoryDetail() {
    }

    @Override
    public String toString() {
        return "CategoryDetail{" + "caId=" + caId + ", cacid=" + cacid + '}';
    }

    public CategoryDetail(String caId, String cacid) {
        this.caId = caId;
        this.cacid = cacid;
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
     * @return the cacid
     */
    public String getCacid() {
        return cacid;
    }

    /**
     * @param cacid the cacid to set
     */
    public void setCacid(String cacid) {
        this.cacid = cacid;
    }

    
}
