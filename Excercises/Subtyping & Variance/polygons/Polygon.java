package polygons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Niklas on 2016-01-19.
 */
public abstract class Polygon extends JComponent{
    Point centerPoint;

    private Polygon(Point center){
        this.centerPoint = center;
    }

    public Polygon(int x, int y){
        this(new Point(x,y));
    }

    @Override
    public abstract void paint(Graphics g)//paint
    ;

    @Override
    public String toString(){
        return "polygons.Polygon{}";
    }

    public void overlaps(Polygon other){
        overlapsHelper("polygons.Polygon", this.toString(), other.toString());
    }

    static void overlapsHelper(String className, String thisType, String otherType){
        System.out.println("" + className + ".overlaps: " + thisType + " vs " + otherType);
    }
}
