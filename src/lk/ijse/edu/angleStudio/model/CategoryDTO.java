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
public class CategoryDTO {
      private String cacid;
    private String categoryType;


    public CategoryDTO() {
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "cacid=" + cacid + ", categoryType=" + categoryType + '}';
    }

    public CategoryDTO(String cacid, String categoryType) {
        this.cacid = cacid;
        this.categoryType = categoryType;
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

    /**
     * @return the categoryType
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType the categoryType to set
     */
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

}
