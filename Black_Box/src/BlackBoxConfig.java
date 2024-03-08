public interface BlackBoxConfig
{
    int size = 40, row = 15, column = 15;
    int r = 50;
    double x = 800, y = 400;
    double a = 2*Math.PI / 6;
    double length = r*Math.sin(a);
    double mid_x = x - 8*r;

    //ver: 2.0
    double Apothem = r*Math.sin(a);
    double det_p = 2*Apothem*Math.sin(a);
    double det_s =-1 *  Apothem;
    double det_q = Apothem;

    int circleRadius = 10;
    double det_Button = r / Math.sqrt(2);
    double ADJ_PARAMS = 1.2;

    //Select_Button
    double sg_detX = (r/2)*ADJ_PARAMS;
    double sg_detY = length*ADJ_PARAMS;
    double pl_detX = r * ADJ_PARAMS;
    double pl_detY = 0;
}
