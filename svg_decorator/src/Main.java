
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Shape rectangle = new SolidFillShapeDecorator(new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        }), "green");

        SolidFilledPolygon pentagon = new SolidFilledPolygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        }, "purple");

        Shape ellipse = new SolidFillShapeDecorator(new Ellipse(new Vec2(500, 700), 400, 100), "yellow");

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.save("result.svg");
    }
}
