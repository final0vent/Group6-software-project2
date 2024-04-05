import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;

class Result {
    int[] coordinates;
    String Direction = "";
}

public class Black_box_test extends JPanel implements BlackBoxConfig
{
    public Graphics g;
    private int p=10,q=10,s=10;  //Variables that record the atom place
    private int entry_x,entry_y,entry_num; //Variables that record the x y of the entry.
    int atomCount = 0;
    private final List<int[]> atoms = new ArrayList<>(6); // Define the arrayList "atoms" to store atoms
    private int[] checkIfWin = new int[7];
    private int[][] guessAtoms = new int[7][3];
    private int guessArrIndex = 1, temp = 1;;
    Select_Button sb = new Select_Button();
    private final String[] buttonDirection = sb.entryDirecion();
    int[] Current = new int[3];
    String Direction = "";
    Result result = new Result();
    int Score= 0;
    int experimenterTime = 1,setterTime = 0;                        //Assume we start the game as player experimenter

    public static void main(String[] args)                          //Main function
    {
        //set.rand_place();
        //setter.manu_place();

        Black_box_test bbt = new Black_box_test();
        bbt.mainBox();
    }

    /*
    Method to calculate the rayPath and return the coordinate and direction
     */
    public Result rayPath()
    {
        int[] current = Current;
        String direction = Direction;
        Ray ray = new Ray(4);
        while(ray.isNextCoordinateValid(current,direction)){
            List<String> threeDirections=ray.threeDirectionsAhead(direction);
            List<int[]> threeCoordinates=ray.threeCoordinatesAhead(current,threeDirections);
            direction=ray.nextDirection(threeCoordinates,atoms,direction,threeDirections);
            if(direction.equals("TERMINATE")){
                break;
            }
            current=ray.getNextCoordinate(current,direction);
        }
        Result result = new Result();
        result.coordinates = current;
        result.Direction = direction;

        return result;
    }

    public void mainBox()
    {
        /*
        preload atoms inside the box and guessAtoms array, assume you are the experimenter.
         */
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        atomCount = 6;

        for(int i = 0 ; i <guessAtoms.length ; i++){
            checkIfWin[i] = 0;
            for (int j = 0 ; j <3 ; j++){
                guessAtoms[i][j] = 10;
            }
        }

        /*
        Set the detail of the black box
         */
        JFrame jf = new JFrame();
        jf.setTitle("Black Box");
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

        /*
        Set the dimension of the button area background
         */
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension buttonSize = new Dimension(200,100);

        /*
        Set the size and the color of the main box
         */
        jf.setSize((int)(size.getWidth()),(int)(size.getHeight()));
        this.setBackground(Color.LIGHT_GRAY);
        jf.add(this,BorderLayout.CENTER);

        /*
        Set the details of the button and the background of it
         */
        JPanel jp = new JPanel();
        jp.setBackground(Color.WHITE);
        jf.add(jp,BorderLayout.EAST);
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
        //jp.setLayout(new FlowLayout());

        String[] butName = {"<html>new game</html>", "<html>end game</html>"};
        JButton[] button = new JButton[2];

        for(int i = 0; i < butName.length; i ++)
        {
            button[i] = new JButton(butName[i]);
            Font buttonFont =new Font(button[i].getName(),Font.PLAIN,16);
            button[i].setPreferredSize(buttonSize);
            button[i].setFont(buttonFont);
            jp.add(Box.createVerticalStrut(10));
            jp.add(button[i]);
        }
        button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JLabel text1 = new JLabel("Place Atom: 0");
        Font textFont =new Font(text1.getFont().getName(),Font.PLAIN,20);
        text1.setFont(textFont);
        jp.add(text1);

        jp.add(Box.createVerticalStrut(40));                    //Add line spacing to justify text.

        JLabel score = new JLabel("Score: 0");                       //Define the text label to show the score
        score.setFont(textFont);
        jp.add(score);

        jp.add(Box.createVerticalStrut(40));                    //Add line spacing to justify text.

        JLabel infoText = new JLabel("<html>Welcome to black box game<br>Time to guess atoms</html>"); //Define the info label.
        infoText.setFont(textFont);
        jp.add(infoText);

        jp.add(Box.createVerticalStrut(40));                    //Add line spacing to justify text.

        JButton finish = new JButton("Finish!");
        Font buttonFont =new Font(finish.getName(),Font.PLAIN,16);
        finish.setFont(buttonFont);
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                experimenterTime =0;
                setterTime =0;
                int[] checkAtoms2 = new int[3];
                Boolean breakSymbol = false;
                for(int i = 0 ; i < 6; i++){
                    for(int j = 0 ; j <atoms.size() ; j++){
                        if(breakSymbol){
                            breakSymbol = false;
                            break;
                        }
                        int[] checkAtoms1 = atoms.get(j);
                        for(int p = 0; p < guessAtoms.length ; p++){
                            for (int q = 0 ; q < 3 ; q++){
                                checkAtoms2[q] = guessAtoms[p][q];
                            }
                            if(Arrays.equals(checkAtoms1,checkAtoms2) && checkIfWin[j] != 1){
                                checkIfWin[j] = 1;
                                breakSymbol = true;
                                break;
                            }
                        }
                    }
                }
                System.out.println(Arrays.toString(checkIfWin));
                atoms.forEach(array -> System.out.print(Arrays.toString(array)));
                System.out.println(" ");
                System.out.println(Arrays.deepToString(guessAtoms));
                for(int i = 0 ; i<6 ; i++){
                    int[] ATOMS = atoms.get(i);
                    p = ATOMS[0];
                    q = ATOMS[1];
                    s = ATOMS[2];
                    if(checkIfWin[i] != 1){
                        drawAtom(Color.RED);
                    }
                    else if(checkIfWin[i] == 1){
                        drawAtom(Color.GREEN);
                    }
                }
            }
        });
        jp.add(finish);


        /*
        Add mouse listener event
         */
        final JLabel label = new JLabel();
        this.add(label);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if(CheckInside(x,y) && (e.getButton() == MouseEvent.BUTTON1) && atomCount < 6 && setterTime == 1){  //Place atoms
                    drawAtom(Color.black);
                    atomCount+=1;
                    atoms.add(new int[]{p,q,s});
                    text1.setText("Place atom: "+atomCount+"\n");
                }
                if(checkEntry(x,y) && (e.getButton() == MouseEvent.BUTTON1) && experimenterTime == 1){
                    Color color = randomColor();

                    fillEntry(color);
                    label.setText("You choose the entry: "+entry_num);
                    Score++;
                    result = rayPath();
                    if(result.Direction.equals("TERMINATE")){
                        fillEntry(Color.BLACK);
                    }
                    else if( (entry_x ==checkWhichEntry_2(result.coordinates[0],result.coordinates[1],result.coordinates[2],result.Direction,0)) && (entry_y ==checkWhichEntry_2(result.coordinates[0],result.coordinates[1],result.coordinates[2],result.Direction,1)) ){
                        fillEntry(Color.RED);
                    }
                    else{
                        entry_x = checkWhichEntry_2(result.coordinates[0],result.coordinates[1],result.coordinates[2],result.Direction,0);
                        entry_y = checkWhichEntry_2(result.coordinates[0],result.coordinates[1],result.coordinates[2],result.Direction,1);
                        fillEntry(color);
                    }
                }
                else if(CheckInside(x,y) && (e.getButton() == MouseEvent.BUTTON1) && experimenterTime ==1){ //Guess atoms
                    text1.setText("Guess atom: "+guessArrIndex);
                    boolean draw_or_eraser = true;
                    for(int i =1 ; i<=6 ; i++){
                        if((p == guessAtoms[i][0]) && (q == guessAtoms[i][1]) && (s == guessAtoms[i][2]) && guessArrIndex != 1){
                            if( i!= 6 && guessAtoms[i+1][0] == 0 && guessAtoms[i+1][1] == 0 && guessAtoms[i+1][2] == 0){
                                temp = i;
                            }
                            draw_or_eraser = false;
                            guessArrIndex = i;
                            break;
                        }

                    }
                    if(draw_or_eraser && guessArrIndex <= 6){
                        drawAtom(Color.black);
                        guessAtoms[guessArrIndex][0] = p;
                        guessAtoms[guessArrIndex][1] = q;
                        guessAtoms[guessArrIndex][2] = s;
                        if(guessArrIndex < temp){
                            guessArrIndex = temp;
                        }else {
                            temp = guessArrIndex;
                            guessArrIndex++;
                        }
                    }
                    else if(!draw_or_eraser && guessArrIndex <= 6){
                        eraserAtom();
                        guessAtoms[guessArrIndex][0] = 0;
                        guessAtoms[guessArrIndex][1] = 0;
                        guessAtoms[guessArrIndex][2] = 0;
                    }
                    text1.setText("Guess atom: "+guessArrIndex);
                }
                score.setText("Score: "+Score);

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
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                label.setText(String.valueOf(checkWhichEntry(x,y)));
            }


        });

        jf.pack();
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);         //Maximize window
        jf.setVisible(true);
    }

    /*
    Define the method that check if the mouse click in circle
     */
    public boolean isInCircle(int x,int y,int X,int Y,int R){
        double distance = Math.sqrt(Math.pow(x - X, 2) + Math.pow(y - Y, 2));
        return distance <= R;
    }

    /*
    Define the method that check which entry the experimenter select
     */
    public int checkWhichEntry(int x, int y){
        Select_Button sb = new Select_Button();
        int[][] arr = sb.select_button();

        for (int i = 1; i<=54;i++){
            if(isInCircle(x,y,arr[i][0],arr[i][1],circleRadius)){
                return i;
            }
        }
        return 0;
    }
    /*
    Using the coordinates to discriminate the entry selected by the user.
     */
    public int checkWhichEntry_2(int a, int b,int c,String d,int e){
        Select_Button sb = new Select_Button();
        int[][] arr = sb.select_button();

        for (int i = 1; i<=54;i++){
            if((arr[i][2] == a) && (arr[i][3] == b) && (arr[i][4] == c)){
                if( d.equals(directionOpp(buttonDirection[i])) && e ==0){
                    return arr[i][0];
                }
                else if(d.equals(directionOpp(buttonDirection[i])) && e ==1){
                    return arr[i][1];
                }
            }
            else if(d.equals("TERMINATE")){
                if(e == 0){
                    return entry_x;
                }
                else if(e == 1){
                    return entry_y;
                }
            }
        }
        return 0;
    }
    /*
    Get the opposite direction of ray path to get the entry number.
     */
    public String directionOpp(String string){
        return switch (string) {
            case "NW" -> "SE";
            case "W" -> "E";
            case "SW" -> "NE";
            case "SE" -> "NW";
            case "E" -> "W";
            case "NE" -> "SW";
            default -> null;
        };
    }
    /*
    Define the method that return the entry
     */
    public Boolean checkEntry(int x, int y){
        Select_Button sb = new Select_Button();
        int[][] arr = sb.select_button();

        for (int i = 1; i<=54;i++){
            if(isInCircle(x,y,arr[i][0],arr[i][1],circleRadius)){
                entry_x = arr[i][0];
                entry_y = arr[i][1];
                entry_num = i;
                System.arraycopy(arr[i], 2, Current, 0, 3);
                System.out.println(Current[0]+" "+Current[1]+" "+Current[2]);
                Direction = buttonDirection[i];
                return true;
            }
        }
        return false;
    }
    /*
    Define the method that check where the experiment place the atom
     */
    public Boolean CheckInside(int a, int b){
        for(int x = -4 ; x <= 4 ; x++){
            for(int y = -4 ; y <= 4 ; y++){
                int z = -x-y;
                if(z >= -4 && z <= 4){
                    if(isInCircle(a,b,(int)(getX(x,y,z)),(int)(getY(x,y,z)),r)){
                        p = x;
                        q = y;
                        s = z;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    Define two methods to calculate the X,Y coordinates with the p,q,s coordinates input.
     */
    public double getX(double p,double q,double s){
        return x + s*det_s + q*det_q;
    }
    public double getY(double p,double q,double s){
        return y + p*det_p;
    }

    /*
    Function to draw a hexagon with the given midpoint coordinate
    */
    public void drawHexagon(Graphics g,double p,double q,double s){
        double X = getX(p,q,s);
        double Y = getY(p,q,s);
        for(int i = 0 ; i < 6 ; i++){
            g.drawLine((int)(X+r*Math.sin(a*i)),(int)(Y+r*Math.cos(a*i)),(int)(X+r*Math.sin(a*(i+1))),(int)(Y+r*Math.cos(a*(i+1))));
        }
    }

    /*
     Painting the main black box
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);
        int min = -4, max = 4;
        for(int x = min ; x <= max ; x++){
            for(int y = min ; y <= max ; y++){
                int z = -x-y;
                if(z >= -4 && z <= 4){
                    drawHexagon(g,x,y,z);
                }
            }
        }

        g.setColor(Color.red);
        Select_Button sb = new Select_Button();
        int[][] arr = sb.select_button();

        for(int i = 1 ; i <= 54 ; i++){
            g.drawOval(arr[i][0]- circleRadius,arr[i][1]- circleRadius,2*circleRadius,2*circleRadius);
        }
    }

    /*
    Draw the atom
     */
    public void drawAtom(Color color){
        Graphics g = this.getGraphics();
        if(setterTime == 1){
            g.setColor(Color.orange);
        }
        else if(experimenterTime == 1){
            g.setColor(Color.BLACK);
        }
        else {g.setColor(color);}
        g.fillOval((int)(getX(p,q,s))-RayRadius,(int)(getY(p,q,s))-RayRadius,2*RayRadius,2*RayRadius);
    }
    /*
    Eraser the atom (for experimenter)
     */
    public void eraserAtom(){
        Graphics g = this.getGraphics();
        g.setColor(this.getBackground());
        g.fillOval((int)(getX(p,q,s))-RayRadius,(int)(getY(p,q,s))-RayRadius,2*RayRadius,2*RayRadius);
    }
    /*
    Fill the entry select button
     */
    public void fillEntry(Color color){
        Graphics g = this.getGraphics();
        g.setColor(color);
        g.fillOval(entry_x-circleRadius,entry_y-circleRadius,2*circleRadius,2*circleRadius);
    }
    /*
    Get a random color
     */
    public Color randomColor(){
        Random random = new Random();
        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));

    }
}
