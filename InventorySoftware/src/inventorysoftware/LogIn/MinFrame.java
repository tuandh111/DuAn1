/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventorysoftware.LogIn;

/**
 *
 * @author RoXen
 */
public class MinFrame {
 
    public static void main(String[] args) {
        SpalshScreen screen = new SpalshScreen();
        NewSignin sign = new NewSignin();
        screen.setVisible(true);
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(10);
                screen.loadingnumber.setText(Integer.toString(row)+"%");
                screen.loadingprogress.setValue(row);
                int value = screen.loadingprogress.getValue();
                if (value < 100) {
                     
                    if (value < 10) {
                        screen.loading.setText("Turning on modules...");
                    }
                    if (value == 20) {
                       screen.loading.setText("Loading modules...");
                    }
                    if (value == 50) {
                        screen.loading.setText("Connecting to database...");
                    }
                    if (value == 70) {
                        screen.loading.setText("Connection to successfull...");
                    }
                    if (value == 80) {
                        screen.loading.setText("Launching Application...");
                    }
                    screen.loadingprogress.setValue(value + 1);
                }
                if (row == 100) {
                    
                    screen.setVisible(false);
                    sign.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
