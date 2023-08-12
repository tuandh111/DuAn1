package com.DuAn1.ThoiGian;

import java.awt.Button;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;

//ĐẶNG HOÀNG TUẤN
//MSSV PC05076
public class Time extends Thread {

    private JLabel button;

    public Time(JLabel button) {
        this.button = button;
    }

    @Override
    public void run() {
        SimpleDateFormat SDF = new SimpleDateFormat("hh:mm:ss aa dd/MM/yyyy");
        while (true) {
            Instant instant = Instant.now();

            // Get the current zoned date time in UTC.
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));

            // Get the current zoned date time in Ho Chi Minh.
            ZonedDateTime hoChiMinhZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Ho_Chi_Minh"));

            // Create a new Date object with the current time in Ho Chi Minh.
            Date nowDate = Date.from(hoChiMinhZonedDateTime.toInstant());

            // Format the Date object and set the text of the button
            String gio = SDF.format(nowDate);
            button.setText(gio);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
