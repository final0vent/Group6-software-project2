import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TEST extends JFrame {
    public TEST() {
        setTitle("Highlight Hexagon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        // Create panels to represent the hexagons
        JPanel[][] hexagons = new JPanel[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                hexagons[i][j] = createHexagon(Color.WHITE);
                hexagons[i][j].addMouseListener(createMouseListener(hexagons[i][j]));
                add(hexagons[i][j]);
            }
        }

        // Set layout
        setLayout(new GridLayout(5, 6));
    }

    // Method to create a hexagon panel with specified color
    private JPanel createHexagon(Color color) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int[] xPoints = {getWidth() / 4, 3 * getWidth() / 4, getWidth(), 3 * getWidth() / 4, getWidth() / 4, 0};
                int[] yPoints = {0, 0, getHeight() / 2, getHeight(), getHeight(), getHeight() / 2};
                g.setColor(color);
                g.fillPolygon(xPoints, yPoints, 6);
            }
        };
    }

    // Method to create a mouse listener for the hexagon
    private MouseListener createMouseListener(JPanel hexagon) {
        return new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                hexagon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
            }

            public void mouseExited(MouseEvent e) {
                hexagon.setBorder(null);
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TEST().setVisible(true);
            }
        });
    }
}
