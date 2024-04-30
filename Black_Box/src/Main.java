import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Setter setter = new Setter();
        //setter.rand_place();
        Scanner scanner=new Scanner(System.in);
        //System.out.println("Please select a ray entry\n***!!! From 1 to 54 !!!***");
        //int a=scanner.nextInt();
        Ray ray=new Ray(4);
        //System.out.println(ray.getEntryNumber());
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});

        int[] current=new int[]{4,0,-4};
        String direction="NE";
        /*
        direction=ray.isRayEntrySurrounded(current,atoms,direction);
        System.out.println(direction);
        while(ray.isNextCoordinateValid(current,direction)){
            List<String> threeDirections=ray.threeDirectionsAhead(direction);
            List<int[]> threeCoordinates=ray.threeCoordinatesAhead(current,threeDirections);
            direction=ray.nextDirection(threeCoordinates,atoms,direction,threeDirections);
            if(direction.equals("TERMINATE")){
                break;
            }
            current=ray.getNextCoordinate(current,direction);
        }
        System.out.println(Arrays.toString(current) +"  +  "+direction);

         */
        System.out.println(ray.result(atoms,current,direction));
    }
}
