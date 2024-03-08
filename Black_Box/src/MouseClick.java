import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseClick {
    public void click(JFrame frame){
        final JLabel label = new JLabel();
        frame.add(label);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    label.setText("Left click");
                }
                else if(e.getButton() == MouseEvent.BUTTON2){
                    label.setText("Middle click");
                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                    label.setText("Right click");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
