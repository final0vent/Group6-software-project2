import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Random;

public class BlackBox extends JPanel implements BlackBoxConfig
{
    public Graphics g;
    //public int[][][] coordanites = new int [8][8][8];

    public static void main(String args[])                          //Main function
    {
        BlackBox bb = new BlackBox();
        Setter set = new Setter();
        Setter_userSelectAtom setter = new Setter_userSelectAtom();

        set.rand_place();
        setter.manu_place();
        bb.UI();
    }



    public void UI()
    {
        JFrame jf = new JFrame();
        jf.setTitle("Black Box");
        jf.setSize(800,800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jf.setLayout(new BorderLayout());

        /*
        Double check if the user want to close the program.
         */
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
        Dimension DIM = new Dimension(600,600);

        this.setPreferredSize(DIM);                             //This for main part
        this.setBackground(Color.LIGHT_GRAY);

        jf.add(this,BorderLayout.CENTER);
        /*
        This is the part of the next spirit. We didn't finish it yet.

        JPanel jp = new JPanel();
        jp.setPreferredSize(dim2);
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

         */

        jf.setVisible(true);
    }

    /*
    Function to draw a hexagon with the given midpoint coordinate
    */
    public void drawHexagon(Graphics g,double x,double y){
        for(int i = 0 ; i < 6 ; i++){
            g.drawLine((int)(x+r*Math.sin(a*i)),(int)(y+r*Math.cos(a*i)),(int)(x+r*Math.sin(a*(i+1))),(int)(y+r*Math.cos(a*(i+1))));
        }
    }

    /*
     Painting the main black box
     */
    public void paint(Graphics g)
    {
        double up_x,down_x;
        double up_y,down_y;
        double temp=mid_x;

        super.paint(g);
        g.setColor(Color.BLACK);

        for(int j = 1 ; j <= 4 ; j++){
            up_x = mid_x + j*length;
            up_y = y - ((2*j)*length)*Math.sin(a);
            for(int i = 0 ; i<9-j ; i++){
                drawHexagon(g,up_x,up_y);
                up_x += 2*length;
            }
        }
        for(int i = 0 ; i<9 ; i++){
            drawHexagon(g,temp,y);
            temp += 2*(r*Math.sin(a));
        }
        for(int j = 1 ; j <= 4 ; j++){
            down_x = mid_x + j*length;
            down_y = y + ((2*j)*length)*Math.sin(a);
            for(int i = 0 ; i<9-j ; i++){
                drawHexagon(g,down_x,down_y);
                down_x += 2*length;
            }
        }
    }

}
