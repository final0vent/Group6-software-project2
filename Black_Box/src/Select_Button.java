import java.util.ArrayList;
import java.util.List;

public class Select_Button implements BlackBoxConfig {
    public int[][] select_button(){
        Black_box_test bbt = new Black_box_test();

        int loop1_p = -5, loop1_q = 1;
        int loop2_p = -1,loop2_s = 5;
        int loop3_q = -5,loop3_s = 1;
        int loop4_p = 5,loop4_q=-1;
        int loop5_p = 1,loop5_s = -5;
        int loop6_q = 5,loop6_s = -1;

        int[][] ButtonArr = new int[55][6];

        for(int i = 1 ; i<= 9 ; i++){
            if(i % 2 != 0){
                loop1_p +=1;
                loop1_q -=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop1_p,loop1_q,4) - sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop1_p,loop1_q,4) - sg_detY);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop1_p,loop1_q,4) - pl_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop1_p,loop1_q,4) - pl_detY);
            }
            ButtonArr[i][2] = loop1_p;
            ButtonArr[i][3] = loop1_q;
            ButtonArr[i][4] = 4;
        }
        for(int i = 10 ; i<= 18 ; i++){
            if(i % 2 == 0){
                loop2_p +=1;
                loop2_s -=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop2_p,-4,loop2_s) - pl_detX );
                ButtonArr[i][1] = (int)(bbt.getY(loop2_p,-4,loop2_s) - pl_detY);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop2_p,-4,loop2_s) - sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop2_p,-4,loop2_s) + sg_detY);
            }
            ButtonArr[i][2] = loop2_p;
            ButtonArr[i][3] = -4;
            ButtonArr[i][4] = loop2_s;
        }
        for(int i = 19 ; i<= 27 ; i++){
            if(i % 2 != 0){
                loop3_q +=1;
                loop3_s -=1;
                ButtonArr[i][0] = (int)(bbt.getX(4,loop3_q,loop3_s) - sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(4,loop3_q,loop3_s) + sg_detY);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(4,loop3_q,loop3_s) + sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(4,loop3_q,loop3_s) + sg_detY);
            }
            ButtonArr[i][2] = 4;
            ButtonArr[i][3] = loop3_q;
            ButtonArr[i][4] = loop3_s;
        }
        for(int i = 28 ; i<= 36 ; i++){
            if(i % 2 == 0){
                loop4_p -=1;
                loop4_q +=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop4_p,loop4_q,-4) + sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop4_p,loop4_q,-4) + sg_detY);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(loop4_p,loop4_q,-4) + pl_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop4_p,loop4_q,-4) + pl_detY);
            }
            ButtonArr[i][2] = loop4_p;
            ButtonArr[i][3] = loop4_q;
            ButtonArr[i][4] = -4;
        }
        for(int i = 37 ; i<= 45 ; i++){
            if(i % 2 == 0){
                ButtonArr[i][0] = (int)(bbt.getX(loop5_p,4,loop5_s) + sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop5_p,4,loop5_s) - sg_detY);
            }
            else {
                loop5_p -=1;
                loop5_s +=1;
                ButtonArr[i][0] = (int)(bbt.getX(loop5_p,4,loop5_s) + pl_detX);
                ButtonArr[i][1] = (int)(bbt.getY(loop5_p,4,loop5_s) + pl_detY);
            }
            ButtonArr[i][2] = loop5_p;
            ButtonArr[i][3] = 4;
            ButtonArr[i][4] = loop5_s;
        }
        for(int i = 46 ; i<= 54 ; i++){
            if(i % 2 == 0){
                loop6_q -=1;
                loop6_s +=1;
                ButtonArr[i][0] = (int)(bbt.getX(-4,loop6_q,loop6_s) + sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(-4,loop6_q,loop6_s) - sg_detY);
            }
            else {
                ButtonArr[i][0] = (int)(bbt.getX(-4,loop6_q,loop6_s) - sg_detX);
                ButtonArr[i][1] = (int)(bbt.getY(-4,loop6_q,loop6_s) - sg_detY);
            }
            ButtonArr[i][2] = -4;
            ButtonArr[i][3] = loop6_q;
            ButtonArr[i][4] = loop6_s;
        }
        return ButtonArr;
    }

    public String[] entryDirecion()
    {
        String[] buttonDirection = new String[56];

        buttonDirection[1] = "SE";
        buttonDirection[2] = "E";
        buttonDirection[3] = "SE";
        buttonDirection[4] = "E";
        buttonDirection[5] = "SE";
        buttonDirection[6] = "E";
        buttonDirection[7] = "SE";
        buttonDirection[8] = "E";
        buttonDirection[9] = "SE";

        buttonDirection[10] = "E";
        buttonDirection[11] = "NE";
        buttonDirection[12] = "E";
        buttonDirection[13] = "NE";
        buttonDirection[14] = "E";
        buttonDirection[15] = "NE";
        buttonDirection[16] = "E";
        buttonDirection[17] = "NE";
        buttonDirection[18] = "E";

        buttonDirection[19] = "NE";
        buttonDirection[20] = "NW";
        buttonDirection[21] = "NE";
        buttonDirection[22] = "NW";
        buttonDirection[23] = "NE";
        buttonDirection[24] = "NW";
        buttonDirection[25] = "NE";
        buttonDirection[26] = "NW";
        buttonDirection[27] = "NE";

        buttonDirection[28] = "NW";
        buttonDirection[29] = "W";
        buttonDirection[30] = "NW";
        buttonDirection[31] = "W";
        buttonDirection[32] = "NW";
        buttonDirection[33] = "W";
        buttonDirection[34] = "NW";
        buttonDirection[35] = "W";
        buttonDirection[36] = "NW";

        buttonDirection[37] = "W";
        buttonDirection[38] = "SW";
        buttonDirection[39] = "W";
        buttonDirection[40] = "SW";
        buttonDirection[41] = "W";
        buttonDirection[42] = "SW";
        buttonDirection[43] = "W";
        buttonDirection[44] = "SW";
        buttonDirection[45] = "W";

        buttonDirection[46] = "SW";
        buttonDirection[47] = "SE";
        buttonDirection[48] = "SW";
        buttonDirection[49] = "SE";
        buttonDirection[50] = "SW";
        buttonDirection[51] = "SE";
        buttonDirection[52] = "SW";
        buttonDirection[53] = "SE";
        buttonDirection[54] = "SW";

        return buttonDirection;
    }
}
