import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Setter_userSelectAtom {
    public void manu_place(){
        int[][] coordinate_manu = new int[6][3];
        HashMap<String,int[]> letter_to_coordinate=new HashMap<>();
        loadPoint(letter_to_coordinate);
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < 6 ; i++){
            String point = scanner.nextLine();
            coordinate_manu[i]=letter_to_coordinate.get(point.toUpperCase());
        }

        System.out.println(Arrays.deepToString(coordinate_manu));
    }

    public void loadPoint(HashMap<String,int[]> a){
        a.put("A1",new int[]{-4,0,4});
        a.put("A2",new int[]{-4,1,3});
        a.put("A3",new int[]{-4,2,2});
        a.put("A4",new int[]{-4,3,1});
        a.put("A5",new int[]{-4,4,0});

        a.put("B1",new int[]{-3,-1,4});
        a.put("B2",new int[]{-3,0,3});
        a.put("B3",new int[]{-3,1,2});
        a.put("B4",new int[]{-3,2,1});
        a.put("B5",new int[]{-3,3,0});
        a.put("B6",new int[]{-3,4,-1});

        a.put("C1",new int[]{-2,-2,4});
        a.put("C2",new int[]{-2,-1,3});
        a.put("C3",new int[]{-2,0,2});
        a.put("C4",new int[]{-2,1,1});
        a.put("C5",new int[]{-2,2,0});
        a.put("C6",new int[]{-2,3,-1});
        a.put("C7",new int[]{-2,4,-2});

        a.put("D1",new int[]{-1,-3,4});
        a.put("D2",new int[]{-1,-2,3});
        a.put("D3",new int[]{-1,-1,2});
        a.put("D4",new int[]{-1,0,1});
        a.put("D5",new int[]{-1,1,0});
        a.put("D6",new int[]{-1,2,-1});
        a.put("D7",new int[]{-1,3,-2});
        a.put("D8",new int[]{-1,4,-3});

        a.put("E1",new int[]{0,-4,4});
        a.put("E2",new int[]{0,-3,3});
        a.put("E3",new int[]{0,-2,2});
        a.put("E4",new int[]{0,-1,1});
        a.put("E5",new int[]{0,0,0});
        a.put("E6",new int[]{0,1,-1});
        a.put("E7",new int[]{0,2,-2});
        a.put("E8",new int[]{0,3,-3});
        a.put("E9",new int[]{0,4,-4});

        a.put("F1",new int[]{1,-4,3});
        a.put("F2",new int[]{1,-3,2});
        a.put("F3",new int[]{1,-2,1});
        a.put("F4",new int[]{1,-1,0});
        a.put("F5",new int[]{1,0,-1});
        a.put("F6",new int[]{1,1,-2});
        a.put("F7",new int[]{1,2,-3});
        a.put("F8",new int[]{1,3,-4});

        a.put("G1",new int[]{2,-4,2});
        a.put("G2",new int[]{2,-3,1});
        a.put("G3",new int[]{2,-2,0});
        a.put("G4",new int[]{2,-1,-1});
        a.put("G5",new int[]{2,0,-2});
        a.put("G6",new int[]{2,1,-3});
        a.put("G7",new int[]{2,2,-4});

        a.put("H1",new int[]{3,-4,1});
        a.put("H2",new int[]{3,-3,0});
        a.put("H3",new int[]{3,-2,-1});
        a.put("H4",new int[]{3,-1,-2});
        a.put("H5",new int[]{3,0,-3});
        a.put("H6",new int[]{3,1,-4});

        a.put("I1",new int[]{4,-4,0});
        a.put("I2",new int[]{4,-3,-1});
        a.put("I3",new int[]{4,-2,-2});
        a.put("I4",new int[]{4,-1,-3});
        a.put("I5",new int[]{4,0,-4});
    }

    public static void main(String[] args) {
        Setter_userSelectAtom setter = new Setter_userSelectAtom();
        setter.manu_place();
    }
}
