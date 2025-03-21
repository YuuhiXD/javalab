import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class SvgScene {
    private int index = 0;
    private Polygon[] polygons = new Polygon[3];
    private int indexE = 0;
    private Elipse[] elipses = new Elipse[3];
    public void addPolygon(Polygon polygon) {
//        if (index >= polygons.length) {
//            this.index = 0;
//            this.polygons[index] = polygon;
//            this.index++;
//        }
//        else {
//            this.polygons[index] = polygon;
//            this.index++;
//        }
        polygons[(index++) % 3] = polygon;
    }

    private BoundingBox sceneBox() {
        double maxX = 0, maxY = 0;
        for(Polygon polygon: polygons) {
            BoundingBox polygonBB = polygon.boundingBox();
            maxX = Math.max(maxX, polygonBB.x() + polygonBB.width());
            maxY = Math.max(maxY, polygonBB.y() + polygonBB.height());
        }
        return new BoundingBox(0, 0, maxX, maxY);
    }

    public String toSvg()
    {
        BoundingBox boundingBox = this.sceneBox();
        String result = String.format(Locale.ENGLISH,
                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">",
                boundingBox.width(), boundingBox.height());
        for(var polygon : polygons)
        {
            if(polygon != null)
                result += "\n\t" + polygon.toSvg();
        }
        result += "\n";
        for(var elipse : elipses)
        {
            if(elipse != null)
                result += "\n\t" + elipse.toSvg();
        }
        result += "\n</svg>";
        return result;
    }

    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(toSvg());
        writer.close();
    }
    public void addElipse(Elipse elipse){
        elipses[(indexE++) % 3] = elipse;
    }



}
