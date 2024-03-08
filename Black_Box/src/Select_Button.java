
public class Select_Button implements BlackBoxConfig {
    public int[][] select_button(){
        Black_box_test bbt = new Black_box_test();

        int loop1_p = -5, loop1_q = 1;
        int loop2_p = -1,loop2_s = 5;
        int loop3_q = -5,loop3_s = 1;
        int loop4_p = 5,loop4_q=-1;
        int loop5_p = 1,loop5_s = -5;
        int loop6_q = 5,loop6_s = -1;
        int[][] ButtonArr = new int[55][2];


        for(int i = 1 ; i<= 9 ; i++){
            if(i % 2 != 0){
                loop1_p +=1;
                loop1_q -=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop1_p,loop1_q,4) - sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop1_p,loop1_q,4) - sg_detY - circleRadius);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop1_p,loop1_q,4) - pl_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop1_p,loop1_q,4) - pl_detY - circleRadius);
            }
        }
        for(int i = 10 ; i<= 18 ; i++){
            if(i % 2 == 0){
                loop2_p +=1;
                loop2_s -=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop2_p,-4,loop2_s) - pl_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop2_p,-4,loop2_s) - pl_detY - circleRadius);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop2_p,-4,loop2_s) - sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop2_p,-4,loop2_s) + sg_detY - circleRadius);
            }
        }
        for(int i = 19 ; i<= 27 ; i++){
            if(i % 2 != 0){
                loop3_q +=1;
                loop3_s -=1;
                ButtonArr[i][0] = (int)(bbt.getX(4,loop3_q,loop3_s) - sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(4,loop3_q,loop3_s) + sg_detY - circleRadius);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(4,loop3_q,loop3_s) + sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(4,loop3_q,loop3_s) + sg_detY - circleRadius);
            }
        }
        for(int i = 28 ; i<= 36 ; i++){
            if(i % 2 == 0){
                loop4_p -=1;
                loop4_q +=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop4_p,loop4_q,-4) + sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop4_p,loop4_q,-4) + sg_detY - circleRadius);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop4_p,loop4_q,-4) + pl_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop4_p,loop4_q,-4) + pl_detY - circleRadius);
            }
        }
        for(int i = 37 ; i<= 45 ; i++){
            if(i % 2 == 0){
                ButtonArr[i][0] = (int)(bbt.getX(loop5_p,4,loop5_s) + sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop5_p,4,loop5_s) - sg_detY - circleRadius);
            }
            else {
                loop5_p -=1;
                loop5_s +=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop5_p,4,loop5_s) + pl_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(loop5_p,4,loop5_s) + pl_detY - circleRadius);
            }
        }
        for(int i = 46 ; i<= 54 ; i++){
            if(i % 2 == 0){
                loop6_q -=1;
                loop6_s +=1;
                ButtonArr[i][0] = (int)(bbt.getX(-4,loop6_q,loop6_s) + sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(-4,loop6_q,loop6_s) - sg_detY - circleRadius);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(-4,loop6_q,loop6_s) - sg_detX - circleRadius);
                ButtonArr[i][1] = (int)(bbt.getY(-4,loop6_q,loop6_s) - sg_detY - circleRadius);
            }
        }
        return ButtonArr;
    }
}
