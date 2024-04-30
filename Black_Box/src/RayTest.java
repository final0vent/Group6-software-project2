import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RayTest {

    //test for the ray will straight through the box
    @Test
    void straightThrough(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(0);
        int[] entry1=new int[]{-4,0,4};
        String direction1="E";
        assertEquals("[-4, 4, 0]  +  E", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{-4,0,4};
        String direction2="SE";
        assertEquals("[4, 0, -4]  +  SE", ray.result(atoms,entry2,direction2));
    }

    //rebound test
    @Test
    void rebound(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{-1,-3,4};
        String direction1="E";
        assertEquals("[-1, -3, 4]  +  W", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{4,0,-4};
        String direction2="NW";
        assertEquals("[4, 0, -4]  +  SE", ray.result(atoms,entry2,direction2));
    }

    //rebound test, for ray rebound at the entry
    @Test
    void reboundAtEntry(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{-2,4,-2};
        String direction1="W";
        assertEquals("[-2, 4, -2]  +  E", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{0,4,-4};
        String direction2="SW";
        assertEquals("[0, 4, -4]  +  NE", ray.result(atoms,entry2,direction2));
    }

    //absorb test, ray absorbed by atoms
    @Test
    void absorb(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{0,-4,4};
        String direction1="E";
        assertEquals("[0, -3, 3]  +  ABSORBED", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{4,-1,-3};
        String direction2="NE";
        assertEquals("[0, 3, -3]  +  ABSORBED", ray.result(atoms,entry2,direction2));
    }

    //reflect test, for ray reflected by 60 degrees
    @Test
    void reflect60(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{3,-4,1};
        String direction1="NE";
        assertEquals("[4, -2, -2]  +  SE", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{-4,1,3};
        String direction2="SE";
        assertEquals("[-4, 3, 1]  +  NE", ray.result(atoms,entry2,direction2));
    }

    //reflect test, for ray reflected by 120 degrees
    @Test
    void reflect120(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{2,2,-4};
        String direction1="NW";
        assertEquals("[-3, 4, -1]  +  NE", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{-3,4,-1};
        String direction2="W";
        assertEquals("[-4, 0, 4]  +  NW", ray.result(atoms,entry2,direction2));
    }

    //mix test
    @Test
    void mix(){
        Ray ray=new Ray();
        List<int[]> atoms=new ArrayList<>(6);
        atoms.add(new int[]{-2,-1,3});
        atoms.add(new int[]{-1,0,1});
        atoms.add(new int[]{-1,1,0});
        atoms.add(new int[]{-1,4,-3});
        atoms.add(new int[]{0,-2,2});
        atoms.add(new int[]{0,-1,1});
        int[] entry1=new int[]{-4,2,2};
        String direction1="SE";
        assertEquals("[-2, 4, -2]  +  NE", ray.result(atoms,entry1,direction1));

        int[] entry2=new int[]{4,-3,-1};
        String direction2="NE";
        assertEquals("[1, 3, -4]  +  SE", ray.result(atoms,entry2,direction2));
    }
}
