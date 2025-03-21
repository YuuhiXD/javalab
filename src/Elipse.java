import java.util.Locale;

public class Elipse extends Shape {
    private Point center;
    private double rx;
    private double ry;

    public Elipse(double ry, double rx, Point center) {
        this.ry = ry;
        this.rx = rx;
        this.center = new Point(center);
    }

    public Elipse(Point center, Style style, double rx, double ry) {
        this(rx, ry, center);
        this.style = style;
    }
    @Override
    public String toSvg(){
        return String.format(Locale.ENGLISH, " <ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" %s />", rx, ry, center.getX(), center.getY(),style.toSvg());
    }
    @Override
    public BoundingBox boundingBox(){
        double x = center.getX() - rx;
        double y = center.getY() - ry;
        double height = ry*2;
        double width = rx*2;
        return new BoundingBox(x, y, width, height);
    }
}
