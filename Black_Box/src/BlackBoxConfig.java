public interface BlackBoxConfig
{
    int size = 40, row = 15, column = 15;
    int r = 30;
    double x = 300, y = 300;
    double a = 2*Math.PI / 6;
    double length = r*Math.sin(a);
    double mid_x = 300 - 8*r;
}
