package a_e_b;
import java.lang.Math;
public class Ponto {
    private float x, y;

    public void setPontos(float new_x, float new_y) {
        if (new_x < 0) x = 0;
        else x = new_x;

        if (new_y < 0) x = 0;
        else y = new_y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double distEntrePontos(float x1, float y1, float x2, float y2) {
        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return dist;
    }

}
