package com.DuAn1.QuetMaQR;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL E5470
 */
import com.DuAn1.Helper.ShareHelper;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import com.DuAn1.form.SanPham;
import com.DuAn1.form.SoLuong;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class QuetMa extends JDialog {

    public static Webcam webcam; // the webcam object
    private WebcamPanel panel; // the panel to display the webcam image
    private JLabel label; // the label to display the QR code text
    private static final String QR_CODE_PREFIX = "https://www.google.com/products/";
    public static String tenSP = "";
    public static int i = 0;

    public static String Ten = "";

    public static String getSoLuong() {
        return Ten;
    }

    public static void setSoLuong(String soLuong) {
        QuetMa.Ten = soLuong;
    }

    public QuetMa(JTextField txt,JTextField txtGia,JComboBox cbo,JTextField txtNoiNhap) {
        setIconImage(ShareHelper.APP_ICON);
        //super(parent, modal);
        // set the title of the frame
        setLayout(new FlowLayout()); // set the layout of the frame
        // set the default close operation of the frame

        Dimension size = WebcamResolution.QVGA.getSize(); // get the size of the webcam resolution
        webcam = Webcam.getDefault(); // get the default webcam
        webcam.setViewSize(size); // set the view size of the webcam

        panel = new WebcamPanel(webcam); // create a new panel with the webcam
        panel.setPreferredSize(size); // set the preferred size of the panel
        panel.setFPSDisplayed(true); // display the frames per second on the panel

        label = new JLabel(); // create a new label

        add(panel); // add the panel to the frame
        add(label); // add the label to the frame
        setLocationRelativeTo(null);
        pack(); // pack the frame
        setVisible(true); // make the frame visible

        new Thread(new Runnable() { // create a new thread to scan for QR codes
            @Override
            public void run() {
                while (true) { // loop indefinitely
                    try {
                        BufferedImage image = webcam.getImage(); // get the image from the webcam
                        if (image != null) {
                            LuminanceSource source = new BufferedImageLuminanceSource(image); // create a luminance source from the image
                            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); // create a binary bitmap from the luminance source
                            Result result = new MultiFormatReader().decode(bitmap); // decode the bitmap using a multi-format reader
                            String qrText = result.getText(); // get the text from the result
                            label.setText(qrText); // set the text of the label for QR code text to qrText
                            tenSP = qrText;

                            txt.setText(qrText);
                            if(qrText.startsWith("I")){
                                txtGia.setText("29,999,999");
                                txtNoiNhap.setText("Mỹ");
                                cbo.setSelectedItem("Iphone");
                            }else if(qrText.startsWith("Sa")){
                                txtGia.setText("25,999,999");
                                txtNoiNhap.setText("Hàn Quốc");
                                cbo.setSelectedItem("Samsung");
                                
                            }else if(qrText.startsWith("So")){
                                txtGia.setText("19,999,999");
                                txtNoiNhap.setText("Nhật Bản");
                                cbo.setSelectedItem("Samsung");
                            }else{
                                txtGia.setText("14,999,999");
                                txtNoiNhap.setText("Chưa xác định");
                                cbo.setSelectedItem(null);
                            }
                            QuetMa.setSoLuong(qrText);
                            int j;
                            if (txt != null) {
                                j = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn chấp nhận sản phẩm này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                                if (j == 0) {
                                    setVisible(false);
                                    webcam.close();
                                }
                            }

                            i = 1;
                        }
                    } catch (NotFoundException e) {
                        label.setText("No QR code found");
                    }
                }

            }
        }).start(); // start the thread
    }

    public static String getData() {
        return tenSP; // return the text from the text field
    }
}
