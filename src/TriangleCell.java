import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

// A triangle Graph Node
public class TriangleCell extends Cell {

    public TriangleCell(int id, String name) {
        super(id, name);

        double width = 50;
        double height = 50;

        Polygon view = new Polygon( width / 2, 0, width, height, 0, height);

        view.setStroke(Color.RED);
        view.setFill(Color.RED);

        setView(view);
    }
}