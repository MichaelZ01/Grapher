import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleCell extends Cell {

    public RectangleCell(int id, String name) {
        super(id, name);

        Rectangle view = new Rectangle(50, 50);

        view.setStroke(Color.DODGERBLUE);
        view.setFill(Color.DODGERBLUE);

    
        setView(view);
    }
}