package com.proyect.proyectintegrador.Main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.proyect.proyectintegrador.View.Login.LoginView;
import java.awt.Color;
import java.awt.Window;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        FlatDarkLaf.setup();
        FlatSVGIcon.ColorFilter.getInstance()
                .add(Color.black, new Color(90, 90, 90), new Color(175, 177, 179));

        SwingUtilities.invokeLater(() -> {
            LoginView ventana = new LoginView();
            /*for (Window window : ventana.getOwnedWindows()) {
                System.out.println(window.getName());
                if (window.getName().equalsIgnoreCase("login")) {
                    window.setVisible(true); //TODO: needs another workaround - medium priority
                }
            };*/
            ventana.setVisible(true);
        });
        
    }
}
