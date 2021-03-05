import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Graph {

    private Model model;
    private Group canvas;
    private CellLayer cellLayer;

    private ZoomableScrollPane scrollPane;
    private MouseGestures mouseGestures;


    public Graph() {

        this.model = new Model();
        this.canvas = new Group();
        this.cellLayer = new CellLayer();

        this.scrollPane = new ZoomableScrollPane(canvas);
        this. mouseGestures = new MouseGestures(this);

        canvas.getChildren().add(cellLayer);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }

    public ScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public Pane getCellLayer() {
        return this.cellLayer;
    }

    public Model getModel() {
        return model;
    }

    public void beginUpdate() {
    }

    public void endUpdate() {

        getCellLayer().getChildren().addAll(model.getAddedEdges());
        getCellLayer().getChildren().addAll(model.getAddedCells());
        getCellLayer().getChildren().removeAll(model.getRemovedCells());
        getCellLayer().getChildren().removeAll(model.getRemovedEdges());

        for (Cell cell : model.getAddedCells()) {
            mouseGestures.makeDraggable(cell);
        }

        // Each Cell needs a parent
        getModel().attachOrphansToGraphParent(model.getAddedCells());
        getModel().disconnectFromGraphParent(model.getRemovedCells());

        getModel().merge();
    }

    public double getScale() {
        return this.scrollPane.getScaleValue();
    }
}