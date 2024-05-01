import java.awt.*;

public class PointHash extends Point {
    int r;

    public PointHash(int x, int y, int r) {
        super(x,y);
        this.r = r;
    }

    @Override
    public boolean equals(Object otherPoint) {
        PointHash p = (PointHash)otherPoint; //cast as PointHash
        if (x == p.x && y == p.y && r == p.r)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        final int a=37;
        int sum = a * a * x;
        sum += a * y;
        sum += r;
        return sum;
    }

}
