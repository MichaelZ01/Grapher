import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Arrow extends Group {

    private final Line line;

    private static final double arrowLength = 15;
    private static final double arrowWidth = 6;

    public Arrow() {
        this(new Line(), new Line(), new Line());
    }

    private Arrow(Line line, Line arrow1, Line arrow2) {
        super(line, arrow1, arrow2);

        this.line = line;
        // Updates the arrow head when the line is moved
        InvalidationListener updater = o -> {

            double startX = getStartX();
            double startY = getStartY();
            double endX = getEndX();
            double endY = getEndY();

            arrow1.setStartX(endX - 0.5*(endX - startX));
            arrow1.setStartY(endY - 0.5*(endY - startY));
            arrow2.setStartX(endX - 0.5*(endX - startX));
            arrow2.setStartY(endY - 0.5*(endY - startY));

            double factor = arrowLength / Math.hypot(startX - endX, startY - endY);
            double factorO = arrowWidth / Math.hypot(startX - endX, startY - endY);

            double dx = (startX - endX) * factor;
            double dy = (startY - endY) * factor;
            double ox = (startX - endX) * factorO;
            double oy = (startY - endY) * factorO;

            arrow1.setEndX(endX - 0.5*(endX - startX) + dx - oy);
            arrow1.setEndY(endY - 0.5*(endY - startY) + dy + ox);
            arrow2.setEndX(endX - 0.5*(endX - startX) + dx + oy);
            arrow2.setEndY(endY - 0.5*(endY - startY) + dy - ox);           
        };

        startXProperty().addListener(updater);
        startYProperty().addListener(updater);
        endXProperty().addListener(updater);
        endYProperty().addListener(updater);
        updater.invalidated(null);
    }

    // Return position properties
    public final DoubleProperty startXProperty() {
        return line.startXProperty();
    }
    public final DoubleProperty startYProperty() {
        return line.startYProperty();
    }
    public final DoubleProperty endYProperty() {
        return line.endYProperty();
    }
    public final DoubleProperty endXProperty() {
        return line.endXProperty();
    }

    // Getters
    public final double getStartX() {
        return line.getStartX();
    }
    public final double getStartY() {
        return line.getStartY();
    }
    public final double getEndX() {
        return line.getEndX();
    }
    public final double getEndY() {
        return line.getEndY();
    }
}