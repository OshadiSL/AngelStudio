/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom;

import lk.ijse.edu.angelStudio.business.SuperBO;
import lk.ijse.edu.angleStudio.model.CommonDTO;

/**
 *
 * @author Oshadi
 */
public interface CustomerBO extends SuperBO {

    public boolean save(CommonDTO common) throws Exception;
    
}
