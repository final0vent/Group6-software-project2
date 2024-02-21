import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class BlackBox extends JPanel implements BlackBoxConfig
{
    public Graphics g;
    //public int[][][] coordanites = new int [8][8][8];
    public int[][] isAvail = new int [15][15];

    public static void main(String args[])
    {
        BlackBox bb = new BlackBox();
        bb.UI();
    }

    public void UI()
    {
        JFrame jf = new JFrame();
        jf.setTitle("Black Box");
        jf.setSize(800,650);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jf.setLayout(new BorderLayout());

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(jf, "Are you sure you want to close Black Box?", "Confirm Close", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    jf.dispose();
                }
            }
        });

        Dimension dim1 = new Dimension(150, 0);
        Dimension dim3 = new Dimension(550, 0);
        Dimension dim2 = new Dimension(140,40);

        this.setPreferredSize(dim3);
        this.setBackground(Color.LIGHT_GRAY);

        jf.add(this,BorderLayout.CENTER);

        JPanel jp = new JPanel();
        jp.setPreferredSize(dim1);
        jp.setBackground(Color.WHITE);
        jf.add(jp,BorderLayout.EAST);
        jp.setLayout(new FlowLayout());

        String[] butname = {"start new game", "end game"};
        JButton[] button = new JButton[2];

        for(int i = 0; i < butname.length; i ++)
        {
            button[i] = new JButton(butname[i]);
            button[i].setPreferredSize(dim2);
            jp.add(button[i]);
        }

        jf.setVisible(true);
    }


    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(Color.BLACK);
        for(int i = 0; i < row; i ++)
        {
            g.drawLine(x, y + size * i, x + size * (column - 1), y + size * i);
        }

        for(int j = 0; j < column; j ++)
        {
            g.drawLine(x + size * j, y, x + size * j, y + size * (row - 1));
        }
    }

}


/*
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
*/
