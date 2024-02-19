import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Window");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close Black Box?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Close the window
                }
            }
        });

        frame.setVisible(true);
    }
}