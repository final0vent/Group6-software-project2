import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ray {
    private int entryNumber=0;
    public Ray(int n){
        entryNumber=n;
    }
    public int getEntryNumber(){
        return entryNumber;
    }
    public int[] getNextCoordinate(int[] current,String direction){
        int[] afterMove=new int[3];
        switch (direction) {
            case "NE":
                afterMove = new int[]{current[0]-1, current[1]+1, current[2]};
                break;
            case "E":
                afterMove = new int[]{current[0], current[1]+1, current[2]-1};
                break;
            case "SE":
                afterMove = new int[]{current[0]+1, current[1], current[2]-1};
                break;
            case "SW":
                afterMove = new int[]{current[0]+1, current[1]-1, current[2]};
                break;
            case "W":
                afterMove = new int[]{current[0], current[1]-1, current[2]+1};
                break;
            case "NW":
                afterMove = new int[]{current[0]-1, current[1], current[2]+1};
                break;
        }
        return afterMove;
    }
    public boolean isNextCoordinateValid(int[] current,String direction){
        int[] next=getNextCoordinate(current,direction);
        if(next[0]<-4 || next[0]>4) return false;
        if(next[1]<-4 || next[1]>4) return false;
        if(next[2]<-4 || next[2]>4) return false;
        return true;
    }
    public List<String> threeDirectionsAhead(String direction){
        List<String> threeDirection=new ArrayList<>(3);
        switch (direction) {
            case "NE":
                threeDirection.add("NW");
                threeDirection.add(direction);
                threeDirection.add("E");
                break;
            case "E":
                threeDirection.add("NE");
                threeDirection.add(direction);
                threeDirection.add("SE");
                break;
            case "SE":
                threeDirection.add("E");
                threeDirection.add(direction);
                threeDirection.add("SW");
                break;
            case "SW":
                threeDirection.add("SE");
                threeDirection.add(direction);
                threeDirection.add("W");
                break;
            case "W":
                threeDirection.add("SW");
                threeDirection.add(direction);
                threeDirection.add("NW");
                break;
            case "NW":
                threeDirection.add("W");
                threeDirection.add(direction);
                threeDirection.add("NE");
                break;
        }
        return threeDirection;
    }
    public List<int[]> threeCoordinatesAhead(int[] current, List<String> threeDirection){
        List<int[]> threeCoordinates=new ArrayList<>(3);
        for(String direction:threeDirection){
            threeCoordinates.add(getNextCoordinate(current,direction));
        }
        return threeCoordinates;
    }
    public String oppositeDirection(String direction){
        String oppoDirection=direction;
        switch(direction){
            case "NE":
                oppoDirection="SW";
                break;
            case "E":
                oppoDirection="W";
                break;
            case "SE":
                oppoDirection="NW";
                break;
            case "SW":
                oppoDirection="NE";
                break;
            case "W":
                oppoDirection="E";
                break;
            case "NW":
                oppoDirection="SE";
                break;
        }
        return oppoDirection;
    }
    public String nextDirection(List<int[]> threeCoordinate, List<int[]> atoms, String currentDirection, List<String> threeDirection) {
        boolean[] atomAhead=new boolean[3];
        for(int i=0;i<3;i++){
            for(int[] atom:atoms){
                if (Arrays.equals(threeCoordinate.get(i), atom)) {
                    atomAhead[i] = true;
                    break;
                }
            }
        }
        if(!atomAhead[0] && !atomAhead[1] && !atomAhead[2]) return currentDirection;
        if(atomAhead[0] && atomAhead[1] && atomAhead[2]) return oppositeDirection(currentDirection);
        if(atomAhead[0] && !atomAhead[1] && atomAhead[2]) return oppositeDirection(currentDirection);
        if(atomAhead[0] && !atomAhead[1] && !atomAhead[2]) return threeDirection.get(2);
        if(!atomAhead[0] && !atomAhead[1] && atomAhead[2]) return threeDirection.get(0);
        if(atomAhead[0] && atomAhead[1] && !atomAhead[2]) return oppositeDirection(threeDirection.get(0));
        if(!atomAhead[0] && atomAhead[1] && atomAhead[2]) return oppositeDirection(threeDirection.get(2));
        return "TERMINATE";
    }
}
