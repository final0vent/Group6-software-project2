import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Setter_userSelectAtom {
    public void manu_place(){
        int[][] coordinate_manu = new int[6][3];
        HashMap<String,int[]> letter_to_coordinate=new HashMap<>();
        letter_to_coordinate.put("A1",new int[]{-3,0,3});
        letter_to_coordinate.put("A2",new int[]{-3,1,2});
        letter_to_coordinate.put("A3",new int[]{-3,2,1});
        letter_to_coordinate.put("A4",new int[]{-3,3,0});
        letter_to_coordinate.put("B1",new int[]{-2,-1,3});
        letter_to_coordinate.put("B2",new int[]{-2,0,2});
        letter_to_coordinate.put("B3",new int[]{-2,1,1});
        letter_to_coordinate.put("B4",new int[]{-2,2,0});
        letter_to_coordinate.put("B5",new int[]{-2,3,-1});
        letter_to_coordinate.put("C1",new int[]{-1,-2,3});
        letter_to_coordinate.put("C2",new int[]{-1,-1,2});
        letter_to_coordinate.put("C3",new int[]{-1,0,1});
        letter_to_coordinate.put("C4",new int[]{-1,1,0});
        letter_to_coordinate.put("C5",new int[]{-1,2,-1});
        letter_to_coordinate.put("C6",new int[]{-1,3,2});
        letter_to_coordinate.put("D1",new int[]{0,-3,3});
        letter_to_coordinate.put("D2",new int[]{0,-2,2});
        letter_to_coordinate.put("D3",new int[]{0,-1,1});
        letter_to_coordinate.put("D4",new int[]{0,0,0});
        letter_to_coordinate.put("D5",new int[]{0,1,-1});
        letter_to_coordinate.put("D6",new int[]{0,2,-2});
        letter_to_coordinate.put("D7",new int[]{0,3,-3});
        letter_to_coordinate.put("E1",new int[]{1,-3,2});
        letter_to_coordinate.put("E2",new int[]{1,-2,1});
        letter_to_coordinate.put("E3",new int[]{1,-1,0});
        letter_to_coordinate.put("E4",new int[]{1,0,-1});
        letter_to_coordinate.put("E5",new int[]{1,1,-2});
        letter_to_coordinate.put("E6",new int[]{1,2,-3});
        letter_to_coordinate.put("F1",new int[]{2,-3,1});
        letter_to_coordinate.put("F2",new int[]{2,-2,0});
        letter_to_coordinate.put("F3",new int[]{2,-1,-1});
        letter_to_coordinate.put("F4",new int[]{2,0,-2});
        letter_to_coordinate.put("F5",new int[]{2,1,-3});
        letter_to_coordinate.put("G1",new int[]{3,-3,0});
        letter_to_coordinate.put("G2",new int[]{3,-2,-1});
        letter_to_coordinate.put("G3",new int[]{3,-1,-2});
        letter_to_coordinate.put("G4",new int[]{3,0,-3});
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < 6 ; i++){
            String point = scanner.nextLine();
            coordinate_manu[i]=letter_to_coordinate.get(point.toUpperCase());
        }

        System.out.println(Arrays.deepToString(coordinate_manu));
    }

    public static void main(String[] args) {
        Setter_userSelectAtom setter = new Setter_userSelectAtom();
        setter.manu_place();
    }
}