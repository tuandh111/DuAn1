package QuetMaQR;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL E5470
 */
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class NewClass1 extends JDialog {

    private Webcam webcam; // the webcam object
    private WebcamPanel panel; // the panel to display the webcam image
    private JLabel label; // the label to display the QR code text
    private static final String QR_CODE_PREFIX = "https://www.google.com/products/";
    public static String tenSP = "ten";
    public static int i = 0;

    public NewClass1() {
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
                        LuminanceSource source = new BufferedImageLuminanceSource(image); // create a luminance source from the image
                        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); // create a binary bitmap from the luminance source
                        Result result = new MultiFormatReader().decode(bitmap); // decode the bitmap using a multi-format reader
                        String qrText = result.getText(); // get the text from the result
                        label.setText(qrText); // set the text of the label for QR code text to qrText
                        System.out.println("Hình ảnh là:" + result);
//                        String[] parts = qrText.split("[:/]"); // cắt chuỗi s theo dấu hai chấm hoặc dấu gạch chéo
//                        String sub = parts[3]; // lấy phần tử thứ 4 của mảng parts
//                        System.out.println(sub);
                        tenSP = qrText;
                        System.out.println(tenSP);
                        int i=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn chấp nhận sản phẩm này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                            if(i==0){
                                setVisible(false);
                                webcam.close();
                            }
                       
                    } catch (NotFoundException e) {
                        label.setText("No QR code found");
// set the text of the label to indicate no QR code was found
                    }
                }
            }
        }).start(); // start the thread
    }

    public static void main(String[] args) {
        new NewClass1(); // create a new instance of QRCodeScanner
    }
}
