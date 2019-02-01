/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.edu.angelStudio.view;

import java.awt.Font;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lk.ijse.edu.angelStudio.IDGenerator.IDGenerator;
import lk.ijse.edu.angelStudio.business.custom.CamaraBO;
import lk.ijse.edu.angelStudio.business.custom.PaymentBO;
import lk.ijse.edu.angelStudio.business.custom.impl.CamaraBOImpl;
import lk.ijse.edu.angelStudio.business.custom.impl.PaymentBOImpl;
import lk.ijse.edu.angelStudio.controller.HomeController;
import lk.ijse.edu.angelStudio.controller.ManageCameraController;

import lk.ijse.edu.angelStudio.controller.ManageDesignController;
import lk.ijse.edu.angelStudio.controller.ManagePrintController;
import lk.ijse.edu.angelStudio.entity.Camara;
import lk.ijse.edu.angelStudio.entity.Desgin;
import lk.ijse.edu.angelStudio.entity.Print;
import lk.ijse.edu.angleStudio.model.CamaraDTO;
import lk.ijse.edu.angleStudio.model.CamaraDetailDTO;
import lk.ijse.edu.angleStudio.model.CameraSubDTO;
import lk.ijse.edu.angleStudio.model.CommonDTO;
import lk.ijse.edu.angleStudio.model.CustomerDTO;
import lk.ijse.edu.angleStudio.model.DesginDTO;
import lk.ijse.edu.angleStudio.model.DesginDetailDTO;
import lk.ijse.edu.angleStudio.model.DesignSubDTO;
import lk.ijse.edu.angleStudio.model.OrdersDTO;
import lk.ijse.edu.angleStudio.model.PaymentDTO;
import lk.ijse.edu.angleStudio.model.PrintDTO;
import lk.ijse.edu.angleStudio.model.PrintDetailDTO;
import lk.ijse.edu.angleStudio.model.PrintSubDTO;
import lk.ijse.edu.angleStudio.model.ReturnItemDTO;

/**
 *
 * @author Oshadi
 */
public class Home extends javax.swing.JFrame {

    String title = "ANGEL STUDIO";
    String subString = "";
    double camaraTotal = 00.0;
    double printTotal = 00.0;
    double disingTotal = 00.0;
    double allTotal = 00.0;
    /**
     *
     * Creates new form Home
     */
    private DefaultTableModel dtmPrint;
    private DefaultTableModel dtmPrintSelect;
    private DefaultTableModel dtmDesigneSelect;
    private DefaultTableModel dtmDesigne;
    private DefaultTableModel dtmCameraSelect;
    private DefaultTableModel dtmCamera;
    private CamaraBO camaraBO;
    private PaymentBO paymentBO;
    private int index;

    public Home() {
        initComponents();
        constructMethod();
        loodAllTotalPrice();
        String paymentMethod = (String) cmbPaymentType.getSelectedItem();
        if (paymentMethod.equals("Full")) {
            txtAdvance.setEnabled(true);
        }

    }

    public void constructMethod() {
        try {
            index = 0;
            camaraBO = new CamaraBOImpl();
            paymentBO = new PaymentBOImpl();
            selectWhatToSearchType();
            loardPrintName();
            loodAllPrint();
            loardAllDesigne();
            loodAllDising();
            loodAllCamaraBrand();
            dtmPrintSelect = (DefaultTableModel) tblPrintSelected.getModel();
            dtmPrint = (DefaultTableModel) tblPrint.getModel();
            dtmDesigneSelect = (DefaultTableModel) tblDesigneSelect.getModel();
            dtmDesigne = (DefaultTableModel) tblDesigne.getModel();
            dtmCameraSelect = (DefaultTableModel) tblCameraSelect.getModel();
            dtmCamera = (DefaultTableModel) tblCamera.getModel();
            RunLable();
            setLocalDates();
            setTime();
            loardCameraType();
            loardLencesType();
            loardAllCamera();
            setTotalLableText();
            loodCustomerId();
            loodOrderId();
            loodPaymentId();
            txtDesigneQty.setVisible(false);
            lblQtyDesign.setVisible(false);
            lblDesigneSelect.setVisible(false);
            txtPrintQty.setVisible(false);
            lblQtyPrint.setVisible(false);
            lblPrintSelect.setVisible(false);
            txtCamaraQty.setVisible(false);
            lblQtyCamera.setVisible(false);
            lblSelectCamara.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTotalLableText() {
        txtAdvance.setText("0.00");
        txtBalance.setText("0.00");
        txtCamaraTotal.setText("0.00");
        txtCustPayAmount.setText("0.00");
        txtTotal.setText("0.00");
        lblPrintAmount.setText("0.00");
        lblDesgineAmount.setText("0.00");
        txtDesigneQty.setText("0");
        txtCamaraQty.setText("0");
        txtPrintQty.setText("0");
    }

    private void loodCustomerId() throws IOException {
        try {
            String custID;
            custID = IDGenerator.getNewID("customer", "cid", "C");
            txtCustomerID.setText(custID);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loodPaymentId() throws IOException {
        try {
            String payID;
            payID = IDGenerator.getNewID("payment", "pyid", "PY");
            txtPID.setText(payID);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loodOrderId() throws IOException {
        try {
            String orderID;
            orderID = IDGenerator.getNewID("orders", "oid", "P");
            txtOrderID.setText(orderID);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblClickDesgingne = new javax.swing.JLabel();
        lblClickPhoto = new javax.swing.JLabel();
        lblClickCamera = new javax.swing.JLabel();
        chkPrint = new javax.swing.JCheckBox();
        chkDesign = new javax.swing.JCheckBox();
        chkCamera = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblRUN = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        pnlCamera = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboCamaraType = new javax.swing.JComboBox<>();
        lblSelectSearchCamaraCmb = new javax.swing.JLabel();
        comboLenceType = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        lblSelectCamaraClear = new javax.swing.JLabel();
        lblSelctMorderDetailsCamra = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCameraSelect = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCamera = new javax.swing.JTable();
        lblQtyCamera = new javax.swing.JLabel();
        txtCamaraQty = new javax.swing.JTextField();
        txtReturnID = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        lblSelectCamara = new javax.swing.JLabel();
        lblSelectCameraDrop = new javax.swing.JLabel();
        comboCameraBrand = new javax.swing.JComboBox<>();
        txtCamaraTotal = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        txtCustomerNIC = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCustomerTell = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtAdvance = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtCustPayAmount = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        cmbPaymentType = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        cmbOrdertype = new javax.swing.JComboBox<>();
        lblOrderSearch = new javax.swing.JLabel();
        lblPrintAndPay = new javax.swing.JLabel();
        lblstatus = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtstatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDesigne = new javax.swing.JTable();
        lblDesigneSelect = new javax.swing.JLabel();
        lblDesigneClear = new javax.swing.JLabel();
        txtDesigneQty = new javax.swing.JTextField();
        lblDesgineAmount = new javax.swing.JLabel();
        cmbDesginName = new javax.swing.JComboBox<>();
        lblDesgineCansel = new javax.swing.JLabel();
        lblQtyDesign = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDesigneSelect = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lblPrintAmount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrintSelected = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrint = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        lblPrintSelect = new javax.swing.JLabel();
        txtPrintQty = new javax.swing.JTextField();
        lblQtyPrint = new javax.swing.JLabel();
        lblPrintClear = new javax.swing.JLabel();
        lblPrintCancle = new javax.swing.JLabel();
        comboPrintName = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClickDesgingne.setBackground(new java.awt.Color(255, 51, 102));
        lblClickDesgingne.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClickDesgingne.setForeground(new java.awt.Color(255, 255, 255));
        lblClickDesgingne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClickDesgingne.setText("Manage Desgingne");
        lblClickDesgingne.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 255), new java.awt.Color(51, 255, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        lblClickDesgingne.setOpaque(true);
        lblClickDesgingne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickDesgingneMouseClicked(evt);
            }
        });
        jPanel2.add(lblClickDesgingne, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 180, 40));

        lblClickPhoto.setBackground(new java.awt.Color(255, 51, 102));
        lblClickPhoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClickPhoto.setForeground(new java.awt.Color(255, 255, 255));
        lblClickPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClickPhoto.setText("Manage Print");
        lblClickPhoto.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 255), new java.awt.Color(51, 255, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        lblClickPhoto.setOpaque(true);
        lblClickPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickPhotoMouseClicked(evt);
            }
        });
        jPanel2.add(lblClickPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        lblClickCamera.setBackground(new java.awt.Color(255, 51, 102));
        lblClickCamera.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClickCamera.setForeground(new java.awt.Color(255, 255, 255));
        lblClickCamera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClickCamera.setText("Manage Camara");
        lblClickCamera.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 255), new java.awt.Color(51, 255, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        lblClickCamera.setOpaque(true);
        lblClickCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClickCameraMouseClicked(evt);
            }
        });
        jPanel2.add(lblClickCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 170, 40));

        chkPrint.setText("Print");
        chkPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPrintActionPerformed(evt);
            }
        });
        jPanel2.add(chkPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, -1, -1));

        chkDesign.setText("Design");
        chkDesign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDesignActionPerformed(evt);
            }
        });
        jPanel2.add(chkDesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        chkCamera.setText("Camera");
        chkCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCameraActionPerformed(evt);
            }
        });
        jPanel2.add(chkCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 51, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Return Items");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 255), new java.awt.Color(51, 255, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 160, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1370, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRUN.setBackground(new java.awt.Color(255, 255, 255));
        lblRUN.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblRUN.setForeground(new java.awt.Color(16, 16, 109));
        lblRUN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRUN.setText("           Angel Studio");
        lblRUN.setOpaque(true);
        jPanel3.add(lblRUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 400, 50));

        lblDate.setBackground(new java.awt.Color(255, 255, 255));
        lblDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 102, 102));
        lblDate.setOpaque(true);
        jPanel3.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 370, 50));

        lblTime.setBackground(new java.awt.Color(255, 255, 255));
        lblTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 102, 102));
        lblTime.setOpaque(true);
        jPanel3.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 50));

        jCheckBox1.setText("jCheckBox1");
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCamera.setBackground(new java.awt.Color(204, 204, 204));
        pnlCamera.setEnabled(false);
        pnlCamera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Camera Brand");
        pnlCamera.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, 30));

        jLabel24.setBackground(new java.awt.Color(8, 8, 162));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Customer Select Cameras");
        jLabel24.setOpaque(true);
        pnlCamera.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1010, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Camera ID");
        pnlCamera.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 90, 30));

        comboCamaraType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCamaraTypeItemStateChanged(evt);
            }
        });
        comboCamaraType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCamaraTypeActionPerformed(evt);
            }
        });
        pnlCamera.add(comboCamaraType, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 140, 30));

        lblSelectSearchCamaraCmb.setBackground(new java.awt.Color(0, 0, 153));
        lblSelectSearchCamaraCmb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectSearchCamaraCmb.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectSearchCamaraCmb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectSearchCamaraCmb.setText("Search");
        lblSelectSearchCamaraCmb.setOpaque(true);
        lblSelectSearchCamaraCmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectSearchCamaraCmbMouseClicked(evt);
            }
        });
        pnlCamera.add(lblSelectSearchCamaraCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 100, 30));

        comboLenceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLenceTypeActionPerformed(evt);
            }
        });
        pnlCamera.add(comboLenceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 100, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Lence Type");
        pnlCamera.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 80, 30));

        lblSelectCamaraClear.setBackground(new java.awt.Color(0, 0, 153));
        lblSelectCamaraClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectCamaraClear.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectCamaraClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectCamaraClear.setText("Cansel");
        lblSelectCamaraClear.setOpaque(true);
        pnlCamera.add(lblSelectCamaraClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 290, 100, 30));

        lblSelctMorderDetailsCamra.setBackground(new java.awt.Color(0, 0, 153));
        lblSelctMorderDetailsCamra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelctMorderDetailsCamra.setForeground(new java.awt.Color(255, 255, 255));
        lblSelctMorderDetailsCamra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelctMorderDetailsCamra.setText("More....");
        lblSelctMorderDetailsCamra.setOpaque(true);
        pnlCamera.add(lblSelctMorderDetailsCamra, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 100, 30));

        tblCameraSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Camera Body", "Camer Brand", "Body Type", "Camer Colur", "Lense Type", "Lense Pixel", "Lense  Brand", "Lense Size", "Price", "QTY"
            }
        ));
        jScrollPane3.setViewportView(tblCameraSelect);

        pnlCamera.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 850, 80));

        tblCamera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caid", "Camer Brand", "Camera Body", "Camer Colur", "Lense Type", "Lense Pixel", "Lense  Brand", "Lense Size", "Price", "QTY"
            }
        ));
        jScrollPane4.setViewportView(tblCamera);

        pnlCamera.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 850, 110));

        lblQtyCamera.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQtyCamera.setText("QTY");
        pnlCamera.add(lblQtyCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 30, 30));
        pnlCamera.add(txtCamaraQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 100, 30));
        pnlCamera.add(txtReturnID, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 10, 80, -1));

        jLabel25.setBackground(new java.awt.Color(0, 0, 95));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Rent Camera");
        jLabel25.setOpaque(true);
        pnlCamera.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 30));

        lblSelectCamara.setBackground(new java.awt.Color(0, 0, 153));
        lblSelectCamara.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectCamara.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectCamara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectCamara.setText("Select");
        lblSelectCamara.setOpaque(true);
        lblSelectCamara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectCamaraMouseClicked(evt);
            }
        });
        pnlCamera.add(lblSelectCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 100, 30));

        lblSelectCameraDrop.setBackground(new java.awt.Color(0, 0, 153));
        lblSelectCameraDrop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectCameraDrop.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectCameraDrop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectCameraDrop.setText("Clear");
        lblSelectCameraDrop.setOpaque(true);
        lblSelectCameraDrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSelectCameraDropMouseClicked(evt);
            }
        });
        pnlCamera.add(lblSelectCameraDrop, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, 100, 30));

        comboCameraBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCameraBrandMouseClicked(evt);
            }
        });
        comboCameraBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCameraBrandActionPerformed(evt);
            }
        });
        pnlCamera.add(comboCameraBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, 30));

        txtCamaraTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtCamaraTotal.setOpaque(true);
        pnlCamera.add(txtCamaraTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 120, 30));

        jPanel4.add(pnlCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1010, 340));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Customer ID");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 210, 30));

        txtCustomerNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNICActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustomerNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 210, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Customer NIC");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, 30));

        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 210, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Customer Name");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Customer Add:");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 30));

        txtCustomerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerAddressActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 210, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Customer Tell");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 30));

        txtCustomerTell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerTellActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustomerTell, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 210, 30));

        jLabel27.setBackground(new java.awt.Color(0, 0, 95));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Customer Details");
        jLabel27.setOpaque(true);
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 30));

        txtOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderIDActionPerformed(evt);
            }
        });
        jPanel8.add(txtOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Order ID");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, 30));

        jLabel31.setBackground(new java.awt.Color(0, 0, 95));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Payment");
        jLabel31.setOpaque(true);
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 330, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Advance");
        jPanel8.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 100, 30));

        txtAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdvanceActionPerformed(evt);
            }
        });
        jPanel8.add(txtAdvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 200, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Total");
        jPanel8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 100, 30));

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel8.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 200, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Pay Amount");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 100, 30));

        txtCustPayAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustPayAmountActionPerformed(evt);
            }
        });
        jPanel8.add(txtCustPayAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 200, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Payment Type");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 30));

        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });
        jPanel8.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 200, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Balance");
        jPanel8.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 100, 30));

        cmbPaymentType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbPaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full", "half" }));
        cmbPaymentType.setToolTipText("");
        cmbPaymentType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaymentTypeItemStateChanged(evt);
            }
        });
        jPanel8.add(cmbPaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 200, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Order Type");
        jPanel8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        cmbOrdertype.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbOrdertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Photo Print", "Rent Camara", "Use a Desgine" }));
        jPanel8.add(cmbOrdertype, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 200, 30));

        lblOrderSearch.setBackground(new java.awt.Color(0, 0, 153));
        lblOrderSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOrderSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderSearch.setText("Search");
        lblOrderSearch.setOpaque(true);
        jPanel8.add(lblOrderSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 30));

        lblPrintAndPay.setBackground(new java.awt.Color(0, 0, 153));
        lblPrintAndPay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrintAndPay.setForeground(new java.awt.Color(255, 255, 255));
        lblPrintAndPay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrintAndPay.setText("Pay & print");
        lblPrintAndPay.setOpaque(true);
        lblPrintAndPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintAndPayMouseClicked(evt);
            }
        });
        jPanel8.add(lblPrintAndPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 100, 30));

        lblstatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblstatus.setText("status");
        jPanel8.add(lblstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        jPanel8.add(txtPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 120, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Pay & print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 110, 30));
        jPanel8.add(txtstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 356, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Payment ID");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 330, 670));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(0, 0, 95));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Design");
        jLabel26.setOpaque(true);
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Designe Name");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        jLabel32.setBackground(new java.awt.Color(8, 8, 162));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Choose Print");
        jLabel32.setOpaque(true);
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 30));

        tblDesigne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", " Type", "Size", " Price", "Qty"
            }
        ));
        jScrollPane6.setViewportView(tblDesigne);

        jPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 380, 90));

        lblDesigneSelect.setBackground(new java.awt.Color(0, 0, 153));
        lblDesigneSelect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneSelect.setForeground(new java.awt.Color(255, 255, 255));
        lblDesigneSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneSelect.setText("Select");
        lblDesigneSelect.setOpaque(true);
        lblDesigneSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesigneSelectMouseClicked(evt);
            }
        });
        jPanel7.add(lblDesigneSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 100, 30));

        lblDesigneClear.setBackground(new java.awt.Color(0, 0, 153));
        lblDesigneClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesigneClear.setForeground(new java.awt.Color(255, 255, 255));
        lblDesigneClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesigneClear.setText("Clear");
        lblDesigneClear.setOpaque(true);
        jPanel7.add(lblDesigneClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 100, 30));
        jPanel7.add(txtDesigneQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 60, 30));

        lblDesgineAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblDesgineAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesgineAmount.setOpaque(true);
        jPanel7.add(lblDesgineAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 100, 30));

        cmbDesginName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDesginNameItemStateChanged(evt);
            }
        });
        cmbDesginName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDesginNameActionPerformed(evt);
            }
        });
        jPanel7.add(cmbDesginName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 140, 30));

        lblDesgineCansel.setBackground(new java.awt.Color(0, 0, 153));
        lblDesgineCansel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesgineCansel.setForeground(new java.awt.Color(255, 255, 255));
        lblDesgineCansel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesgineCansel.setText("Cansel");
        lblDesgineCansel.setOpaque(true);
        jPanel7.add(lblDesgineCansel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 100, 30));

        lblQtyDesign.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQtyDesign.setText("QTY");
        jPanel7.add(lblQtyDesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 50, 30));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Full Amount");
        jPanel7.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 80, 30));

        tblDesigneSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", " Type", "Size", " Price", "Qty"
            }
        ));
        jScrollPane5.setViewportView(tblDesigneSelect);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 380, 80));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 510, 300));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrintAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblPrintAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrintAmount.setOpaque(true);
        jPanel6.add(lblPrintAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Print Name");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        tblPrintSelected.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Print ID", "Name", "Type", "Size", "Price", "Qty"
            }
        ));
        jScrollPane1.setViewportView(tblPrintSelected);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 350, 80));

        tblPrint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Print ID", "Name", "Type", "Size", "Price", "Qty"
            }
        ));
        tblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrintMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPrint);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 80));

        jLabel33.setBackground(new java.awt.Color(0, 0, 95));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Print");
        jLabel33.setOpaque(true);
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 30));

        lblPrintSelect.setBackground(new java.awt.Color(0, 0, 153));
        lblPrintSelect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrintSelect.setForeground(new java.awt.Color(255, 255, 255));
        lblPrintSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrintSelect.setText("Select");
        lblPrintSelect.setOpaque(true);
        lblPrintSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintSelectMouseClicked(evt);
            }
        });
        jPanel6.add(lblPrintSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 100, 30));
        jPanel6.add(txtPrintQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 60, 30));

        lblQtyPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQtyPrint.setText("QTY");
        jPanel6.add(lblQtyPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 50, 30));

        lblPrintClear.setBackground(new java.awt.Color(0, 0, 153));
        lblPrintClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrintClear.setForeground(new java.awt.Color(255, 255, 255));
        lblPrintClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrintClear.setText("Clear");
        lblPrintClear.setOpaque(true);
        jPanel6.add(lblPrintClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 100, 30));

        lblPrintCancle.setBackground(new java.awt.Color(0, 0, 153));
        lblPrintCancle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrintCancle.setForeground(new java.awt.Color(255, 255, 255));
        lblPrintCancle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrintCancle.setText("Cancle");
        lblPrintCancle.setOpaque(true);
        jPanel6.add(lblPrintCancle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 100, 30));

        comboPrintName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPrintNameItemStateChanged(evt);
            }
        });
        comboPrintName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPrintNameActionPerformed(evt);
            }
        });
        jPanel6.add(comboPrintName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 140, 30));

        jLabel38.setBackground(new java.awt.Color(8, 8, 162));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Choose Print");
        jLabel38.setOpaque(true);
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 350, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Full Amount");
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 80, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 490, 300));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 1200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblClickPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickPhotoMouseClicked
        ManagePrint n = new ManagePrint();
        n.setVisible(true);
    }//GEN-LAST:event_lblClickPhotoMouseClicked

    private void lblClickDesgingneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickDesgingneMouseClicked
        ManageDesigne n = new ManageDesigne();
        n.setVisible(true);
    }//GEN-LAST:event_lblClickDesgingneMouseClicked

    private void lblClickCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClickCameraMouseClicked
        ManageCamera n = new ManageCamera();
        n.setVisible(true);
    }//GEN-LAST:event_lblClickCameraMouseClicked

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void txtCustomerNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNICActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtCustomerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerAddressActionPerformed

    private void txtCustomerTellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerTellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerTellActionPerformed

    private void txtOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderIDActionPerformed

    private void txtAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtCustPayAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustPayAmountActionPerformed
        double total = Double.parseDouble(txtTotal.getText());
        double amount = Double.parseDouble(txtCustPayAmount.getText());
        double blance = amount - total;
        txtBalance.setText("" + blance);
    }//GEN-LAST:event_txtCustPayAmountActionPerformed

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void tblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrintMouseClicked
        //
    }//GEN-LAST:event_tblPrintMouseClicked

    private void lblPrintSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintSelectMouseClicked
        double price1 = 00.0;
        TableModel tbl = tblPrint.getModel();
        int[] index = tblPrint.getSelectedRows();
        Object[] obj = new Object[6];
        dtmPrintSelect = (DefaultTableModel) tblPrintSelected.getModel();
        for (int i = 0; i < index.length; i++) {
            obj[0] = tbl.getValueAt(index[i], 0);
            obj[1] = tbl.getValueAt(index[i], 1);
            obj[2] = tbl.getValueAt(index[i], 2);
            obj[3] = tbl.getValueAt(index[i], 3);
            obj[4] = tbl.getValueAt(index[i], 4);
            obj[5] = txtPrintQty.getText();
            dtmPrintSelect.addRow(obj);
            double total = 0;
            for (int j = 0; j < tblPrintSelected.getRowCount(); j++) {
                double amount = Double.parseDouble(tblPrintSelected.getValueAt(j, 4).toString());
            }
        }
        DefaultTableModel dtm = (DefaultTableModel) tblPrintSelected.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            price1 = (double) dtm.getValueAt(i, 4);
        }
        int qty = Integer.parseInt(txtPrintQty.getText());
        double all = price1 * qty;
        printTotal = printTotal + all;
        lblPrintAmount.setText("" + printTotal);
        allTotal = allTotal + printTotal;
        txtTotal.setText("" + allTotal);

    }//GEN-LAST:event_lblPrintSelectMouseClicked

    private void comboPrintNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPrintNameItemStateChanged
        try {
            String did = (String) comboPrintName.getSelectedItem();
            Print print = ManagePrintController.loardAmount(did);
            if (print != null) {
                lblPrintAmount.setText("" + print.getPrice());
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_comboPrintNameItemStateChanged

    private void lblDesigneSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesigneSelectMouseClicked
        double price2 = 00.0;
        TableModel tbl = tblDesigne.getModel();
        int[] index = tblDesigne.getSelectedRows();
        Object[] obj = new Object[5];
        dtmDesigneSelect = (DefaultTableModel) tblDesigneSelect.getModel();
        for (int i = 0; i < index.length; i++) {
            obj[0] = tbl.getValueAt(index[i], 0);
            obj[1] = tbl.getValueAt(index[i], 1);
            obj[2] = tbl.getValueAt(index[i], 2);
            obj[3] = tbl.getValueAt(index[i], 3);
            obj[4] = txtDesigneQty.getText();
            dtmDesigneSelect.addRow(obj);
        }
        DefaultTableModel dtm = (DefaultTableModel) tblDesigneSelect.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            price2 = (double) dtm.getValueAt(i, 3);
        }
        int qty = Integer.parseInt(txtDesigneQty.getText());
        double all = price2 * qty;
        disingTotal = disingTotal + all;
        lblDesgineAmount.setText("" + disingTotal);
        allTotal = allTotal + disingTotal;
        txtTotal.setText("" + allTotal);

    }//GEN-LAST:event_lblDesigneSelectMouseClicked

    private void lblSelectCamaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectCamaraMouseClicked
        double price = 00.0;
        TableModel tbl = tblCamera.getModel();
        int[] index = tblCamera.getSelectedRows();
        Object[] obj = new Object[10];
        dtmCameraSelect = (DefaultTableModel) tblCameraSelect.getModel();
        int qty = Integer.parseInt(txtCamaraQty.getText());
        for (int i = 0; i < index.length; i++) {
            obj[0] = tbl.getValueAt(index[i], 0);
            obj[1] = tbl.getValueAt(index[i], 1);
            obj[2] = tbl.getValueAt(index[i], 2);
            obj[3] = tbl.getValueAt(index[i], 3);
            obj[4] = tbl.getValueAt(index[i], 4);
            obj[5] = tbl.getValueAt(index[i], 5);
            obj[6] = tbl.getValueAt(index[i], 6);
            obj[7] = tbl.getValueAt(index[i], 7);
            obj[8] = tbl.getValueAt(index[i], 8);
            obj[9] = qty;
            dtmCameraSelect.addRow(obj);
            txtCamaraQty.setText("");
            setTotal();
        }

        DefaultTableModel dtm = (DefaultTableModel) tblCameraSelect.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            price = (double) dtm.getValueAt(i, 8);
        }
        double all = price * qty;
        camaraTotal = camaraTotal + all;
        txtCamaraTotal.setText("" + camaraTotal);
        allTotal = allTotal + camaraTotal;
        txtTotal.setText("" + allTotal);

    }//GEN-LAST:event_lblSelectCamaraMouseClicked

    private void cmbDesginNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDesginNameItemStateChanged
        try {
            String did = (String) cmbDesginName.getSelectedItem();
            Desgin desgin = ManageDesignController.loardAmount(did);
            if (desgin != null) {
                lblDesgineAmount.setText("" + desgin.getPrice());
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbDesginNameItemStateChanged

    private void lblPrintAndPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintAndPayMouseClicked
        try {
            String custid = txtCustomerID.getText();
            String custName = txtCustomerName.getText();
            String custAddress = txtCustomerAddress.getText();
            String custMobileNum = txtCustomerTell.getText();
            String custNIC = txtCustomerNIC.getText();
            CustomerDTO customer = new CustomerDTO(custid, custName, custAddress, custMobileNum, custNIC);

            String pyId = txtPID.getText();
            String oid = txtOrderID.getText();
            double total = Double.parseDouble(txtTotal.getText());
            double advance = Double.parseDouble(txtAdvance.getText());
            double amount = Double.parseDouble(txtCustPayAmount.getText());
            String orderType = (String) cmbOrdertype.getSelectedItem();
            double balance = Double.parseDouble(txtBalance.getText());
            String paymentType = (String) cmbPaymentType.getSelectedItem();
            PaymentDTO payment = new PaymentDTO(pyId, oid, total, advance, amount, orderType, balance, paymentType);

            CameraSubDTO cameraSub = null;
            CamaraDetailDTO cameraDetail = null;
            DefaultTableModel dtmCam = (DefaultTableModel) tblCameraSelect.getModel();
            for (int i = 0; i < dtmCam.getRowCount(); i++) {
                String caid = (String) dtmCam.getValueAt(i, 0);

                int qty = Integer.parseInt(dtmCam.getValueAt(i, 9).toString());
                double price = (double) dtmCam.getValueAt(i, 8);
                cameraDetail = new CamaraDetailDTO(caid, oid, qty, price);
                cameraSub = new CameraSubDTO(caid, qty);
            }

            PrintDetailDTO printDetail = null;
            PrintSubDTO printsub = null;
            DefaultTableModel dtmPrint = (DefaultTableModel) tblPrintSelected.getModel();
            for (int i = 0; i < dtmPrint.getRowCount(); i++) {
                String prid = (String) dtmPrint.getValueAt(i, 0);
                int qty = Integer.parseInt(dtmPrint.getValueAt(i, 5).toString());
                double price = (double) dtmPrint.getValueAt(i, 4);
                printDetail = new PrintDetailDTO(prid, oid, qty, price);
                printsub = new PrintSubDTO(prid, qty);
            }

            DesginDetailDTO designDetail = null;
            DesignSubDTO desginSub = null;
            DefaultTableModel dtmDesign = (DefaultTableModel) tblDesigneSelect.getModel();
            for (int i = 0; i < dtmDesign.getRowCount(); i++) {
                String did = (String) dtmDesign.getValueAt(i, 0);
                int qty = Integer.parseInt(dtmDesign.getValueAt(i, 4).toString());
                double price = (double) dtmDesign.getValueAt(i, 3);
                designDetail = new DesginDetailDTO(did, oid, qty, price);
                desginSub = new DesignSubDTO(did, qty);
            }

            String time = lblTime.getText();
            String Date = lblDate.getText();
            String stus = txtstatus.getText();
            OrdersDTO orders = new OrdersDTO(oid, custid, time, Date, stus);

            boolean isCamera = false;
            if (chkCamera.isSelected()) {
                isCamera = true;
            }

            boolean isPrint = false;
            if (chkPrint.isSelected()) {
                isPrint = true;
            }

            boolean isDesign = false;
            if (chkDesign.isSelected()) {
                isDesign = true;
            }

            CommonDTO commonDTO = new CommonDTO(cameraDetail, printDetail, designDetail, customer, orders, payment, isCamera, isPrint, isDesign, cameraSub, printsub, desginSub);

            boolean isAdded = HomeController.SaveDetails(commonDTO);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Added Sucessfully");
            } else {
                JOptionPane.showMessageDialog(this, "Added not Sucessfully");
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        String returnid=txtReturnID.getText();
        String custId = txtCustomerID.getText();
        String cusName = txtCustomerName.getText();  
        String nic = txtCustomerNIC.getText();
        String oid = txtOrderID.getText();

        DefaultTableModel dtm = (DefaultTableModel) tblCameraSelect.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            try {
                String camId = (String) dtm.getValueAt(i, 0);
                String camName = (String) dtm.getValueAt(i, 1);
                String lensBrand = (String) dtm.getValueAt(i, 6);
                String lensSize = (String) dtm.getValueAt(i, 7);
                double price = (double) dtm.getValueAt(i, 8);
                int qty = (int) dtm.getValueAt(i, 9);
                double total = Double.parseDouble(txtCamaraTotal.getText());
                double advance = Double.parseDouble(txtAdvance.getText());
                double blance = Double.parseDouble(txtBalance.getText());
                String damage = "ssss";
                ReturnItemDTO item = new ReturnItemDTO(returnid, custId, oid, camId, cusName, nic, camName, lensBrand, lensSize, price, qty, total, advance, blance, damage);
                boolean isAdd=ManageCameraController.saveReturn(item);
            } catch (Exception ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
        }/*cid varchar(10),
    oid varchar(10),
    caid varchar(10),
    name varchar(100),
    NIC varchar(11),
    brand varchar(100),
    LenseBrand varchar(100),
    LenseSize varchar(100),
    price decimal (10,2),
    qty int,
    fullTotal decimal(10,2),
    payAmount decimal(10,2),
    blance decimal(10,2),
    damages varchar(100),*/


    }//GEN-LAST:event_lblPrintAndPayMouseClicked

    private void comboPrintNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPrintNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPrintNameActionPerformed

    private void comboCamaraTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCamaraTypeItemStateChanged

    }//GEN-LAST:event_comboCamaraTypeItemStateChanged

    private void comboCameraBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCameraBrandMouseClicked
        //
    }//GEN-LAST:event_comboCameraBrandMouseClicked

    private void comboCameraBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCameraBrandActionPerformed

        index = 1;
        selectWhatToSearchType();
    }//GEN-LAST:event_comboCameraBrandActionPerformed

    private void comboCamaraTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCamaraTypeActionPerformed
        index = 2;
        selectWhatToSearchType();
    }//GEN-LAST:event_comboCamaraTypeActionPerformed

    private void comboLenceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLenceTypeActionPerformed
        index = 3;
        selectWhatToSearchType();
    }//GEN-LAST:event_comboLenceTypeActionPerformed

    private void lblSelectSearchCamaraCmbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectSearchCamaraCmbMouseClicked
//        index=4;
//        selectWhatToSearchType();
    }//GEN-LAST:event_lblSelectSearchCamaraCmbMouseClicked

    private void cmbDesginNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDesginNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDesginNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblCameraSelect.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCameraActionPerformed
        if (chkCamera.isSelected()) {
            lblQtyCamera.setVisible(true);
            lblSelectCamara.setVisible(true);
            txtCamaraQty.setVisible(true);
        } else {
            txtCamaraQty.setVisible(false);
            lblQtyCamera.setVisible(false);
            lblSelectCamara.setVisible(false);
        }
    }//GEN-LAST:event_chkCameraActionPerformed

    private void chkPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPrintActionPerformed
        if (chkPrint.isSelected()) {
            lblPrintSelect.setVisible(true);
            lblQtyPrint.setVisible(true);
            txtPrintQty.setVisible(true);
        } else {
            txtPrintQty.setVisible(false);
            lblQtyPrint.setVisible(false);
            lblPrintSelect.setVisible(false);
        }
    }//GEN-LAST:event_chkPrintActionPerformed

    private void chkDesignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDesignActionPerformed
        if (chkDesign.isSelected()) {
            lblDesigneSelect.setVisible(true);
            lblQtyDesign.setVisible(true);
            txtDesigneQty.setVisible(true);
        } else {
            txtDesigneQty.setVisible(false);
            lblQtyDesign.setVisible(false);
            lblDesigneSelect.setVisible(false);
        }
    }//GEN-LAST:event_chkDesignActionPerformed

    private void cmbPaymentTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaymentTypeItemStateChanged
//        String paymentMethod=(String) cmbPaymentType.getSelectedItem();
//        if (paymentMethod.equals("half")) {
//            txtAdvance.setEnabled(true);
//        }
    }//GEN-LAST:event_cmbPaymentTypeItemStateChanged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ManageReturnItem r = new ManageReturnItem();
        r.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblSelectCameraDropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSelectCameraDropMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tblCameraSelect.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_lblSelectCameraDropMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkCamera;
    private javax.swing.JCheckBox chkDesign;
    private javax.swing.JCheckBox chkPrint;
    private javax.swing.JComboBox<String> cmbDesginName;
    private javax.swing.JComboBox<String> cmbOrdertype;
    private javax.swing.JComboBox<String> cmbPaymentType;
    private javax.swing.JComboBox<String> comboCamaraType;
    private javax.swing.JComboBox<String> comboCameraBrand;
    private javax.swing.JComboBox<String> comboLenceType;
    private javax.swing.JComboBox<String> comboPrintName;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblClickCamera;
    private javax.swing.JLabel lblClickDesgingne;
    private javax.swing.JLabel lblClickPhoto;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDesgineAmount;
    private javax.swing.JLabel lblDesgineCansel;
    private javax.swing.JLabel lblDesigneClear;
    private javax.swing.JLabel lblDesigneSelect;
    private javax.swing.JLabel lblOrderSearch;
    private javax.swing.JLabel lblPrintAmount;
    private javax.swing.JLabel lblPrintAndPay;
    private javax.swing.JLabel lblPrintCancle;
    private javax.swing.JLabel lblPrintClear;
    private javax.swing.JLabel lblPrintSelect;
    private javax.swing.JLabel lblQtyCamera;
    private javax.swing.JLabel lblQtyDesign;
    private javax.swing.JLabel lblQtyPrint;
    private javax.swing.JLabel lblRUN;
    private javax.swing.JLabel lblSelctMorderDetailsCamra;
    private javax.swing.JLabel lblSelectCamara;
    private javax.swing.JLabel lblSelectCamaraClear;
    private javax.swing.JLabel lblSelectCameraDrop;
    private javax.swing.JLabel lblSelectSearchCamaraCmb;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JPanel pnlCamera;
    private javax.swing.JTable tblCamera;
    private javax.swing.JTable tblCameraSelect;
    private javax.swing.JTable tblDesigne;
    private javax.swing.JTable tblDesigneSelect;
    private javax.swing.JTable tblPrint;
    private javax.swing.JTable tblPrintSelected;
    private javax.swing.JTextField txtAdvance;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCamaraQty;
    private javax.swing.JLabel txtCamaraTotal;
    private javax.swing.JTextField txtCustPayAmount;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtCustomerNIC;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerTell;
    private javax.swing.JTextField txtDesigneQty;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPrintQty;
    private javax.swing.JTextField txtReturnID;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtstatus;
    // End of variables declaration//GEN-END:variables

    private void loardPrintName() {
        try {
            ArrayList<String> array = ManagePrintController.getAllLoardPrintName();
            for (String printID : array) {
                comboPrintName.addItem(printID);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loardAllDesigne() {
        try {
            ArrayList<String> array = ManageDesignController.getAllDesign();
            for (String type : array) {
                cmbDesginName.addItem(type);

            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loodAllCamaraBrand() {
        try {
            ArrayList<String> array = ManageCameraController.getBrand();
            for (String type : array) {
                comboCameraBrand.addItem(type);

            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void RunLable() {
        setFont(new Font("Areal", 3, 12));
        setTitle(" \" ANGEL STUDIO   \'1.5 VERSION\' \"");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        new Thread() {
            public void run() {
                for (int i = 0; i < title.length() + 1; i++) {
                    try {
                        if (i == title.length()) {
                            i = 0;
                            subString = "";
                        }
                        subString += title.substring(i, i + 1);
                        lblRUN.setText(subString);
                        sleep(500);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(Home.this, "Database Error...");
                    }
                }
            }
        }.start();
    }

    private void setLocalDates() {
        LocalDate date = LocalDate.now();
        String sDate = date.toString();
        lblDate.setText(sDate);
    }

    private void setTime() {

        new Thread(() -> {
            while (true) {
                Date date = new Date();
                String currentdate = new SimpleDateFormat("hh:mm:ss aa").format(date);
                lblTime.setText(currentdate);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }).start();
    }

    private void loardCameraType() {
        try {
            ArrayList<String> array = ManageCameraController.getAllTypes();
            for (String type : array) {
                comboCamaraType.addItem(type);

            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
 
     */
    private void loardLencesType() {
        try {
            ArrayList<String> array = ManageCameraController.getLencesTypes();
            for (String type : array) {
                comboLenceType.addItem(type);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loardAllCamera() {
        try {
            ArrayList<Camara> allPrint = ManageCameraController.getAllCamaras();
            DefaultTableModel dtm = (DefaultTableModel) tblCamera.getModel();
            dtm.setRowCount(0);
            for (Camara camara : allPrint) {
                Object[] row = {
                    camara.getCaId(),
                    camara.getBrand(),
                    camara.getBodyType(),
                    camara.getClour(),
                    camara.getLenseType(),
                    camara.getPixels(),
                    camara.getLenseBrand(),
                    camara.getLenseSize(),
                    camara.getPrice(),
                    camara.getQty()

                };
                dtm.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loodAllDising() {
        try {
            ArrayList<DesginDTO> allDining = ManageDesignController.getAllDising();
            DefaultTableModel dtm = (DefaultTableModel) tblDesigne.getModel();
            for (DesginDTO desgin : allDining) {
                Object[] rowDate = {
                    desgin.getDid(),
                    desgin.getType(),
                    desgin.getSize(),
                    desgin.getPrice(),
                    desgin.getQty()
                };
                dtm.addRow(rowDate);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loodAllPrint() {
        try {
            ArrayList<Print> allPrint = ManagePrintController.getAll();
            DefaultTableModel dtm = (DefaultTableModel) tblPrint.getModel();
            dtm.setRowCount(0);
            for (Print printDTO : allPrint) {
                Object[] row = {printDTO.getPrid(),
                    printDTO.getName(),
                    printDTO.getType(),
                    printDTO.getSize(),
                    printDTO.getPrice(),
                    printDTO.getQty()
                };
                dtm.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cmbSetAlllenceType() {
        String camaraId = comboLenceType.getSelectedItem().toString();
        DefaultTableModel dtm = (DefaultTableModel) tblCamera.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<CamaraDTO> array = camaraBO.serchCameraLancetype(camaraId);

            for (CamaraDTO camara : array) {
                Object[] rowData = {
                    camara.getCaid(),
                    camara.getBrand(),
                    camara.getBodyType(),
                    camara.getClour(),
                    camara.getLenseType(),
                    camara.getPixels(),
                    camara.getLenseBrand(),
                    camara.getLenseSize(),
                    camara.getQty(),
                    camara.getPrice()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cmbGetAllCamaraBrand() {
        String camaraBrand = comboCameraBrand.getSelectedItem().toString();
        DefaultTableModel dtm = (DefaultTableModel) tblCamera.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<CamaraDTO> array = camaraBO.serchCameraBrand(camaraBrand);

            for (CamaraDTO camara : array) {
                Object[] rowData = {
                    camara.getCaid(),
                    camara.getBrand(),
                    camara.getBodyType(),
                    camara.getClour(),
                    camara.getLenseType(),
                    camara.getPixels(),
                    camara.getLenseBrand(),
                    camara.getLenseSize(),
                    camara.getPrice(),
                    camara.getQty()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cmbGetAllCamaraType() {
        String camaraId = comboCamaraType.getSelectedItem().toString();
        DefaultTableModel dtm = (DefaultTableModel) tblCamera.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<CamaraDTO> array = camaraBO.serchCameraID(camaraId);

            for (CamaraDTO camara : array) {
                Object[] rowData = {
                    camara.getCaid(),
                    camara.getBrand(),
                    camara.getBodyType(),
                    camara.getClour(),
                    camara.getLenseType(),
                    camara.getPixels(),
                    camara.getLenseBrand(),
                    camara.getLenseSize(),
                    camara.getPrice(),
                    camara.getQty()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cmbAllSearch() {
        String camaraBrand = comboCameraBrand.getSelectedItem().toString();
        String camaraLanceType = comboLenceType.getSelectedItem().toString();
        DefaultTableModel dtm = (DefaultTableModel) tblCamera.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<CamaraDTO> array = camaraBO.serchCamera(camaraBrand, camaraLanceType);

            for (CamaraDTO camara : array) {
                Object[] rowData = {
                    camara.getCaid(),
                    camara.getBrand(),
                    camara.getBodyType(),
                    camara.getClour(),
                    camara.getLenseType(),
                    camara.getPixels(),
                    camara.getLenseBrand(),
                    camara.getLenseSize(),
                    camara.getPrice(),
                    camara.getQty()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectWhatToSearchType() {
        switch (index) {
//            case 0:loodAllCamara();break;
            case 1:
                cmbGetAllCamaraBrand();
                break;
            case 2:
                cmbGetAllCamaraType();
                break;
            case 3:
                cmbSetAlllenceType();
                break;
            case 4:
                cmbAllSearch();
                break;
        }
    }

    private void setTotal() {

    }

    private void loodAllTotalPrice() {
        double camara = Double.parseDouble(txtCamaraTotal.getText());
        double print = Double.parseDouble(lblPrintAmount.getText());
        double desing = Double.parseDouble(lblDesgineAmount.getText());
        double allTotal = camara + print + desing;
        txtTotal.setText("" + allTotal);
    }

}
