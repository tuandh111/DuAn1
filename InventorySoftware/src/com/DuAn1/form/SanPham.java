/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.DongMayDAO;
import com.DuAn1.Dao.GiamGiaDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.QuetMaQR.NewClass1;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import com.DuAn1.main.Main;
import com.tuandhpc05076.Form.ChuyenDe;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.CPUModel;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.GiamGiaModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.RamModel;
import com.DuAn1.Model.SanPhamModel;
import static com.tuandhpc05076.Form.NguoiHoc.listNH;
import com.tuandhpc05076.Object.O_NguoiHoc;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL E5470
 */
public class SanPham extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    SanPhamDAO Dao = new SanPhamDAO();
    DienThoaiDao DaoDT = new DienThoaiDao();
    DongMayDAO daoDongMay = new DongMayDAO();
    // the webcam object
    private WebcamPanel panel;

    public SanPham() {
        initComponents();
//        dateChooser.addEventDateChooser(new EventDateChooser() {
//            @Override
//            public void dateSelected(SelectedAction action, SelectedDate date) {
//                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
//                if (action.getAction() == SelectedAction.DAY_SELECTED) {
//                    dateChooser.hidePopup();
//                }
//            }
//        });
        tblUser.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUser.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblUser.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblUser.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblUser.getColumnModel().getColumn(4).setPreferredWidth(0);

//        TieuDe();
        filltable();
        setLayout(new FlowLayout()); // set the layout of the frame
        // set the default close operation of the frame
        LoadCombobox();
        LoaiSanPham.setBorder(new TitledBorder("Loại sản phẩm"));
    }

    void LoadCombobox() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        GiamGiaDao daoGiamGia = new GiamGiaDao();
        ArrayList<GiamGiaModel> listGiamGia = (ArrayList<GiamGiaModel>) daoGiamGia.select();
        for (GiamGiaModel gg : listGiamGia) {
            comboboxmodel.addElement(gg.getMaGG().trim() + "-" + gg.getPhanTram());
        }
        cboKhuyenMai.setModel(comboboxmodel);
        cboKhuyenMai.setSelectedIndex(-1);
    }

    void LoadComboboxCPU() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<CPUModel> listCPU = (ArrayList<CPUModel>) daoDongMay.selectCPU(cboString);
        for (CPUModel cpu : listCPU) {
            comboboxmodel.addElement(cpu.getMaCPU());
        }
        cboCPU.setModel(comboboxmodel);
        cboCPU.setSelectedIndex(-1);
    }

    void LoadComboboxRam() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<RamModel> listRam = (ArrayList<RamModel>) daoDongMay.selectRam(cboString);
        System.out.println(listRam);
        for (RamModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaRam());
        }
        cboRam.setModel(comboboxmodel1);
        cboRam.setSelectedIndex(-1);
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<SanPhamModel> list = Dao.select();
            System.out.println(list.size());
            for (SanPhamModel nv : list) {
                Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), String.format("%.0f", nv.getGia()), nv.getSoLuong(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh(), nv.getMaGiamGia()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    SanPhamModel getFormSP() {
        SanPhamModel cd = new SanPhamModel();
        cd.setMaSP(txtMaSP.getText());
        cd.setTenSP(txtTenSP.getText());
        cd.setMau((String) cboMau.getSelectedItem());
        cd.setGia(Double.parseDouble(txtGia.getText()));
        cd.setLoaiSP((String) cboLoaiSanPham.getSelectedItem());
        cd.setNgayNhap(txtNgayNhap.getText());
        cd.setNoiNhap(txtNoiNhap.getText());
        cd.setSoLuong(Integer.parseInt((String) txtSoLuong.getValue()));
        cd.setTrangThai(true);
        cd.setHinh(txtHinh.getToolTipText());
        cd.setMaNV(ShareHelper.USER.getMaNV());
        cd.setMaGiamGia((String) cboKhuyenMai.getSelectedItem());
        return cd;
    }

    DienThoaiModel getFormDT() {
        DienThoaiModel dt = new DienThoaiModel();
        dt.setMaDT(txtMaSP.getText());
        dt.setCPU((String) cboCPU.getSelectedItem());
        dt.setMangHinh((String) cboMangHinh.getSelectedItem());
        dt.setBoNho((String) cboBoNho.getSelectedItem());
        dt.setMoTa(txtMoTa.getText());
        dt.setCamera((String) cboCamera.getSelectedItem());
        dt.setPin((String) cboPin.getSelectedItem());
        dt.setRam((String) cboRam.getSelectedItem());
        return dt;
    }

    void setFormSP(SanPhamModel sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        cboMau.setSelectedItem(sp.getMau());
        txtGia.setText(String.valueOf(sp.getGia()));
        cboLoaiSanPham.setSelectedItem(sp.getLoaiSP());
        txtNgayNhap.setText(sp.getNgayNhap());
        txtNoiNhap.setText(sp.getNoiNhap());
        txtSoLuong.setValue(sp.getSoLuong());
        if (sp.getHinh() != null) {
            txtHinhAnh.setToolTipText(sp.getHinh());
            txtHinhAnh.setIcon(ShareHelper.readLogo(sp.getHinh()));
        }
        cboKhuyenMai.setSelectedItem(sp.getMaGiamGia());

    }

    void setFormDT(DienThoaiModel dt) {
        cboCPU.setSelectedItem(dt.getCPU());
        cboMangHinh.setSelectedItem(dt.getCPU());
        cboBoNho.setSelectedItem(dt.getCPU());
        cboCamera.setSelectedItem(dt.getCPU());
        cboPin.setSelectedItem(dt.getCPU());
        cboRam.setSelectedItem(dt.getCPU());
        txtMoTa.setText(dt.getMoTa());

    }

    void them() {
        try {
            SanPhamModel model = getFormSP();
            DienThoaiModel modeldt = getFormDT();
            Dao.insert(model);
            DaoDT.insert(modeldt);
            DialogHelper.alert(this, "Thêm dữ liệu thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }

    public void btnInDanhSach() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Sản phẩm");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblUser.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblUser.getColumnName(i));
                }

                for (int j = 0; j < tblUser.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblUser.getColumnCount(); k++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(k);
                        if (tblUser.getValueAt(j, k) != null) {
                            cell.setCellValue(tblUser.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                OpenFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public void OpenFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new com.raven.swing.table.Table();
        txtNgayNhap = new com.DuAn1.Swing.TextField();
        txtTenSP = new com.DuAn1.Swing.TextField();
        txtGia = new com.DuAn1.Swing.TextField();
        txtNoiNhap = new com.DuAn1.Swing.TextField();
        txtMoTa = new com.DuAn1.Swing.TextField();
        cboMau = new com.DuAn1.Swing.Combobox();
        cboKhuyenMai = new com.DuAn1.Swing.Combobox();
        cboLoaiSanPham = new com.DuAn1.Swing.Combobox();
        txtSoLuong = new com.DuAn1.Swing.Spinner();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        jPanel1 = new javax.swing.JPanel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        cboSapXep = new com.DuAn1.Swing.Combobox();
        jPanel2 = new javax.swing.JPanel();
        btnTang = new com.DuAn1.Swing.Button();
        btnGiam = new com.DuAn1.Swing.Button();
        LoaiSanPham = new javax.swing.JPanel();
        cboCPU = new com.DuAn1.Swing.Combobox();
        cboRam = new com.DuAn1.Swing.Combobox();
        cboBoNho = new com.DuAn1.Swing.Combobox();
        cboCamera = new com.DuAn1.Swing.Combobox();
        cboMangHinh = new com.DuAn1.Swing.Combobox();
        cboPin = new com.DuAn1.Swing.Combobox();
        btnTimKiem = new com.DuAn1.Swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCuoi = new com.DuAn1.Swing.Button();
        btnDau = new com.DuAn1.Swing.Button();
        btnLui = new com.DuAn1.Swing.Button();
        btnToi = new com.DuAn1.Swing.Button();
        txtHinh = new swing.PanelShadow();
        txtHinhAnh = new javax.swing.JLabel();
        txtMaSP = new com.DuAn1.Swing.TextField();
        switchButton1 = new com.DuAn1.swing0.SwitchButton();
        jLabel3 = new javax.swing.JLabel();
        button15 = new com.DuAn1.Swing.Button();

        dateChooser.setTextRefernce(txtNgayNhap);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1058, 741));
        setPreferredSize(new java.awt.Dimension(1058, 741));
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                formCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên sản phẩm", "Giá", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setName(""); // NOI18N
        jScrollPane1.setViewportView(tblUser);

        txtNgayNhap.setLabelText("Ngày nhập");
        txtNgayNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayNhapMouseClicked(evt);
            }
        });
        txtNgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayNhapActionPerformed(evt);
            }
        });

        txtTenSP.setLabelText("Tên ");
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        txtGia.setLabelText("Giá");

        txtNoiNhap.setLabelText("Nơi nhập");

        txtMoTa.setLabelText("Mô tả");

        cboMau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đen", "Trắng", "Xanh", "Vàng" }));
        cboMau.setSelectedIndex(-1);
        cboMau.setLabeText("Màu sắc");

        cboKhuyenMai.setLabeText("Chọn khuyến mại");

        cboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Iphone", "Samsung", "Sony" }));
        cboLoaiSanPham.setSelectedIndex(-1);
        cboLoaiSanPham.setLabeText("Loại sản phẩm");
        cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSanPhamActionPerformed(evt);
            }
        });

        txtSoLuong.setLabelText("Số lượng");

        txtTimKiem.setHint("Tìm kiếm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Ngày nhập", "Số lượng" }));
        cboSapXep.setSelectedIndex(-1);
        cboSapXep.setLabeText("Sắp xếp theo");
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiến hành sắp xếp theo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        btnTang.setBackground(new java.awt.Color(153, 153, 255));
        btnTang.setText("Tăng");
        btnTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangActionPerformed(evt);
            }
        });

        btnGiam.setBackground(new java.awt.Color(153, 153, 255));
        btnGiam.setText("Giảm");
        btnGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        LoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        LoaiSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại sản phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        cboCPU.setLabeText("CPU");

        cboRam.setLabeText("Ram");

        cboBoNho.setLabeText("Bộ nhớ trong");

        cboCamera.setLabeText("Camera");

        cboMangHinh.setLabeText("Màng hình");

        cboPin.setLabeText("Pin");

        javax.swing.GroupLayout LoaiSanPhamLayout = new javax.swing.GroupLayout(LoaiSanPham);
        LoaiSanPham.setLayout(LoaiSanPhamLayout);
        LoaiSanPhamLayout.setHorizontalGroup(
            LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoaiSanPhamLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPin, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCamera, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(cboRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(cboMangHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LoaiSanPhamLayout.setVerticalGroup(
            LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoaiSanPhamLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMangHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnTimKiem.setBackground(new java.awt.Color(153, 153, 255));
        btnTimKiem.setText("Tìm kiếm");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Số lượng bản ghi:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("1 trên 10");

        btnCuoi.setBackground(new java.awt.Color(153, 153, 255));
        btnCuoi.setText(">|");

        btnDau.setBackground(new java.awt.Color(153, 153, 255));
        btnDau.setText("|<");

        btnLui.setBackground(new java.awt.Color(153, 153, 255));
        btnLui.setText("<<");

        btnToi.setBackground(new java.awt.Color(153, 153, 255));
        btnToi.setText(">>");

        txtHinh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhMouseClicked(evt);
            }
        });
        txtHinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnhMouseClicked(evt);
            }
        });
        txtHinh.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 140));

        txtMaSP.setLabelText("Mã sản phẩm");
        txtMaSP.setLineColor(new java.awt.Color(102, 102, 255));
        txtMaSP.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        switchButton1.setSelectedAnimate(false);
        switchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switchButton1MouseClicked(evt);
            }
        });

        jLabel3.setText("Quét bằng mã");

        button15.setBackground(new java.awt.Color(153, 153, 255));
        button15.setText("In thành file excel");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53)
                                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(412, 412, 412))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(txtNoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(LoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(9, 9, 9)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addComponent(txtNoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(170, 170, 170)))
        );

        add(jPanel3, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayNhapActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNgayNhapActionPerformed

    private void txtNgayNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayNhapMouseClicked
        dateChooser.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayNhapMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them();
        System.out.println(ShareHelper.ThoiGianHoatDong + "tuan");
// TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        String name = (String) cboLoaiSanPham.getSelectedItem();
        LoaiSanPham.setBorder(new TitledBorder(name));
        LoadComboboxCPU();
        LoadComboboxRam();
    }//GEN-LAST:event_cboLoaiSanPhamActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void btnTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTangActionPerformed

    private void btnGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGiamActionPerformed
    String strHinh = null;
    private void txtHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhMouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
                }

                strHinh = file.getName();
                txtHinhAnh.setText("");

                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh.setToolTipText(file.getName());
                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhMouseClicked

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void formCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formCaretPositionChanged

    private void switchButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_switchButton1MouseClicked
        NewClass1 n = null;
        if (switchButton1.isSelected()) {
            // close the webcam if it is not null
            if (NewClass1.webcam != null) {
                NewClass1.webcam.close();
            }
            // close the form if it is not null
            if (n != null) {
                n.dispose();
                n.setVisible(false);
            }
        } else {
            // create and display a new form

            NewClass1 n1 = new NewClass1(Main.getMain(), true);
            // n1.setVisible(true);
            txtTenSP.setText(NewClass1.getSoLuong());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_switchButton1MouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMoiActionPerformed
//   public void tuDongTangMa() {
//        String name = "";
//        int i = 0;
//        O_NguoiHoc nh = listNH.get(listNH.size() - 1);
//
//        name = nh.getMaNH().trim();
//        String[] tbl = name.split("P");
//        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
//        String ten = "SP";
//        for (int j = 0; j <= 4 - so.length(); j++) {
//            ten += "0";
//        }
//        ten = ten + so;
//        txtMaNguoiHoc.setText(ten);
//
//    }
    private void txtHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnhMouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
                }

                strHinh = file.getName();
                txtHinhAnh.setText("");

                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh.setToolTipText(file.getName());
                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnhMouseClicked

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        btnInDanhSach();        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoaiSanPham;
    private com.DuAn1.Swing.Button btnCuoi;
    private com.DuAn1.Swing.Button btnDau;
    private com.DuAn1.Swing.Button btnGiam;
    private com.DuAn1.Swing.Button btnLui;
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnTang;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnTimKiem;
    private com.DuAn1.Swing.Button btnToi;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Button button15;
    private com.DuAn1.Swing.Combobox cboBoNho;
    private com.DuAn1.Swing.Combobox cboCPU;
    private com.DuAn1.Swing.Combobox cboCamera;
    private com.DuAn1.Swing.Combobox cboKhuyenMai;
    private com.DuAn1.Swing.Combobox cboLoaiSanPham;
    private com.DuAn1.Swing.Combobox cboMangHinh;
    private com.DuAn1.Swing.Combobox cboMau;
    private com.DuAn1.Swing.Combobox cboPin;
    private com.DuAn1.Swing.Combobox cboRam;
    private com.DuAn1.Swing.Combobox cboSapXep;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.DuAn1.swing0.SwitchButton switchButton1;
    private com.raven.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField txtGia;
    private swing.PanelShadow txtHinh;
    private javax.swing.JLabel txtHinhAnh;
    private com.DuAn1.Swing.TextField txtMaSP;
    private com.DuAn1.Swing.TextField txtMoTa;
    private com.DuAn1.Swing.TextField txtNgayNhap;
    private com.DuAn1.Swing.TextField txtNoiNhap;
    private com.DuAn1.Swing.Spinner txtSoLuong;
    private com.DuAn1.Swing.TextField txtTenSP;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
