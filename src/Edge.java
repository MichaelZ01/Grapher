import javafx.scene.Group;

// A directed edge represents a connection between two nodes
public class Edge extends Group {

    private int edgeId;

    protected Cell source;
    protected Cell target;

    public Edge(int id, Cell source, Cell target) {

        this.edgeId = id;
        this.source = source;
        this.target = target;

        source.addCellOutBound(target);
        target.addCellInBound(source);

        // Creates a binded arrow edge
        Arrow arrow = new Arrow();
        arrow.startXProperty().bind(source.layoutXProperty().add(source.getBoundsInParent().getWidth() / 2.0));
        arrow.startYProperty().bind(source.layoutYProperty().add(source.getBoundsInParent().getHeight() / 2.0));
        arrow.endXProperty().bind(target.layoutXProperty().add(target.getBoundsInParent().getWidth() / 2.0));
        arrow.endYProperty().bind(target.layoutYProperty().add(target.getBoundsInParent().getHeight() / 2.0));

        getChildren().add(arrow);
    }
}