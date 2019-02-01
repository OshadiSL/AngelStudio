
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.edu.angelStudio.business.custom.CamaraBO;
import lk.ijse.edu.angelStudio.dao.custom.CamaraDAO;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.ReturnItem;
import lk.ijse.edu.angleStudio.dao.DAOFactory;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.PrintDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public class CamaraBOImpl implements CamaraBO {

    private CamaraDAO camerDAO;

    public CamaraBOImpl() {
        this.camerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CAMARA);
    }

    @Override
    public ArrayList<String> getLoodAllCategory() throws Exception {
        return camerDAO.getLoodAllCategory();
    }

    @Override
    public ArrayList<String> getAllBrand() throws Exception {
        return camerDAO.getAllBrand();
    }

    @Override
    public ArrayList<String> getBrand() throws Exception {
        return camerDAO.getBrand();
    }

    @Override
    public ArrayList<String> getAllType() throws Exception {
        return camerDAO.getAllType();
    }

    @Override
    public ArrayList<String> getLencesType() throws Exception {
        return camerDAO.getLencesType();

    }

    @Override
    public ArrayList<Camara> getAllCamaras() throws Exception {
        ArrayList<CamaraDTO> allCamaras = new ArrayList<>();
        return camerDAO.getAllCamaras();

    }

    @Override
    public boolean save(CamaraDTO camara) throws Exception {
        return camerDAO.save(
                new Camara(
                        camara.getCaid(),
                        camara.getBrand(),
                        camara.getCampany(),
                        camara.getBodyType(),
                        camara.getClour(),
                        camara.getLenseType(),
                        camara.getPixels(),
                        camara.getFlashers(),
                        camara.getRemoteControol(),
                        camara.getWifi(),
                        camara.getBloototh(),
                        camara.getUsb(),
                        camara.getBatreyDuration(),
                        camara.getBattryVotage(),
                        camara.getBattryType(),
                        camara.getLenseBrand(),
                        camara.getLenseSize(),
                        camara.getQty(),
                        camara.getPrice()
                ));
    }

    @Override
    public ArrayList<CamaraDTO> serchCameraBrand(String camaraBrand) throws Exception {
        ArrayList<Camara> camaras = camerDAO.serchCameraBrand(camaraBrand);
        ArrayList<CamaraDTO> array = new ArrayList<>();
        for (Camara camara : camaras) {
            array.add(
                    new CamaraDTO(
                            camara.getCaId(),
                            camara.getBrand(),
                            camara.getCampany(),
                            camara.getBodyType(),
                            camara.getClour(),
                            camara.getLenseType(),
                            camara.getPixels(),
                            camara.getFlashers(),
                            camara.getRemoteControol(),
                            camara.getWifi(),
                            camara.getBloototh(),
                            camara.getUsb(),
                            camara.getBatreyDuration(),
                            camara.getBattryVotage(),
                            camara.getBattryType(),
                            camara.getLenseBrand(),
                            camara.getLenseSize(),
                            camara.getQty(),
                            camara.getPrice()
                    ));
        }
        return array;
    }

    @Override
    public ArrayList<CamaraDTO> serchCameraID(String camaraID) throws Exception {
        ArrayList<Camara> camaras = camerDAO.serchCameraID(camaraID);
        ArrayList<CamaraDTO> array = new ArrayList<>();
        for (Camara camara : camaras) {
            array.add(
                    new CamaraDTO(
                            camara.getCaId(),
                            camara.getBrand(),
                            camara.getCampany(),
                            camara.getBodyType(),
                            camara.getClour(),
                            camara.getLenseType(),
                            camara.getPixels(),
                            camara.getFlashers(),
                            camara.getRemoteControol(),
                            camara.getWifi(),
                            camara.getBloototh(),
                            camara.getUsb(),
                            camara.getBatreyDuration(),
                            camara.getBattryVotage(),
                            camara.getBattryType(),
                            camara.getLenseBrand(),
                            camara.getLenseSize(),
                            camara.getQty(),
                            camara.getPrice()
                    ));
        }
        return array;
    }

    @Override
    public ArrayList<CamaraDTO> serchCameraLancetype(String leanceType) throws Exception {
        ArrayList<Camara> camaras = camerDAO.serchCameraLanceType(leanceType);
        ArrayList<CamaraDTO> array = new ArrayList<>();
        for (Camara camara : camaras) {
            array.add(
                    new CamaraDTO(
                            camara.getCaId(),
                            camara.getBrand(),
                            camara.getCampany(),
                            camara.getBodyType(),
                            camara.getClour(),
                            camara.getLenseType(),
                            camara.getPixels(),
                            camara.getFlashers(),
                            camara.getRemoteControol(),
                            camara.getWifi(),
                            camara.getBloototh(),
                            camara.getUsb(),
                            camara.getBatreyDuration(),
                            camara.getBattryVotage(),
                            camara.getBattryType(),
                            camara.getLenseBrand(),
                            camara.getLenseSize(),
                            camara.getQty(),
                            camara.getPrice()
                    ));
        }
        return array;
    }

    @Override
    public ArrayList<CamaraDTO> serchCamera(String camaraBrand, String leanceType) throws Exception {
        ArrayList<Camara> camaras = camerDAO.serchCamera(camaraBrand, leanceType);
        ArrayList<CamaraDTO> array = new ArrayList<>();
        for (Camara camara : camaras) {
            array.add(
                    new CamaraDTO(
                            camara.getCaId(),
                            camara.getBrand(),
                            camara.getCampany(),
                            camara.getBodyType(),
                            camara.getClour(),
                            camara.getLenseType(),
                            camara.getPixels(),
                            camara.getFlashers(),
                            camara.getRemoteControol(),
                            camara.getWifi(),
                            camara.getBloototh(),
                            camara.getUsb(),
                            camara.getBatreyDuration(),
                            camara.getBattryVotage(),
                            camara.getBattryType(),
                            camara.getLenseBrand(),
                            camara.getLenseSize(),
                            camara.getQty(),
                            camara.getPrice()
                    ));
        }
        return array;
    }

    @Override
    public boolean saveaaaa(CamaraDTO camara) throws Exception {
        return camerDAO.save(new Camara(
                camara.getCaid(),
                camara.getBrand(),
                camara.getCampany(),
                camara.getBodyType(),
                camara.getClour(),
                camara.getLenseType(),
                camara.getPixels(),
                camara.getFlashers(),
                camara.getRemoteControol(),
                camara.getWifi(),
                camara.getBloototh(),
                camara.getUsb(),
                camara.getBatreyDuration(),
                camara.getBattryVotage(),
                camara.getBattryType(),
                camara.getLenseBrand(),
                camara.getLenseSize(),
                camara.getQty(),
                camara.getPrice()
        ));
    }

    @Override
    public boolean delete(String toString) throws Exception {
        return camerDAO.delete(toString);
    }

    @Override
    public boolean update(CamaraDTO camara) throws Exception {
        return camerDAO.update(new Camara(camara.getCaid(),
                camara.getBrand(),
                camara.getCampany(),
                camara.getBodyType(),
                camara.getClour(),
                camara.getLenseType(),
                camara.getPixels(),
                camara.getFlashers(),
                camara.getRemoteControol(),
                camara.getWifi(),
                camara.getBloototh(),
                camara.getUsb(), 
                camara.getBatreyDuration(),
                camara.getBattryVotage(),
                camara.getBattryType(),
                camara.getLenseBrand(),
                camara.getLenseSize(),
                camara.getQty(),
                camara.getPrice()));
    }

    @Override
    public boolean saveReturn(ReturnItemDTO item) throws Exception {
        return camerDAO.saveReturn(new ReturnItem(item.getRid(),item.getCid(),item.getOid(),item.getCaid(),item.getName(),item.getNIC(),item.getBrand(),item.getLenseBrand(),item.getLenseSize(),item.getPrice(),item.getQty(),item.getFullTotal(),item.getPayAmount(),item.getBlance(),item.getDamages()));
    }

    @Override
    public ArrayList<ReturnItemDTO> getAllReturn() throws Exception {
        ArrayList<ReturnItemDTO>allReurn=new ArrayList<>();
        return camerDAO.allReurn();
    }

    @Override
    public ReturnItemDTO SearchBuNic(String nic) throws Exception {
        return camerDAO.SearchBuNic(nic);
    }

    

}
