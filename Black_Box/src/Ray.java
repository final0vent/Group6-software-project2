import java.util.Arrays;

public class Ray {
    private int entryNumber=0;
    public Ray(int n){
        entryNumber=n;
    }
    public int getEntryNumber(){
        return entryNumber;
    }
    public void a(int[][] a){
        System.out.println(Arrays.deepToString(a));
    }
}
