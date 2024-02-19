import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Window");
        frame.setSize(800, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close Black Box?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });

        frame.setLayout(new BorderLayout());

        Dimension dim1 = new Dimension(150, 0);
        Dimension dim3 = new Dimension(550, 0);
        Dimension dim2 = new Dimension(140,40);

        frame.setPreferredSize(dim3);
        frame.setBackground(Color.LIGHT_GRAY);




        frame.setVisible(true);
    }
}