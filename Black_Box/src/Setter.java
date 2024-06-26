import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Setter {
    public int[][] rand_place() {
        //Create instance of random class
        Random random = new Random();

        //Generate random coordinate number array in range 0~4
        int[][] coordinate_rand = new int[6][3];
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 2 ; j++)
            {
                coordinate_rand[i][j] = random.nextInt(9)-4;
            }
            if(coordinate_rand[i][0] + coordinate_rand[i][1] >= -4 && coordinate_rand[i][0] + coordinate_rand[i][1] <=4){
                coordinate_rand[i][2] = -coordinate_rand[i][0] - coordinate_rand[i][1];
            }
            else {
                i--;
            }

        }

        //Print the random coordinate number array
        //System.out.println(Arrays.deepToString(coordinate_rand));
        return coordinate_rand;
    }
    public static void main(String[] args) {
        Setter setter = new Setter();
        setter.rand_place();
    }
}
