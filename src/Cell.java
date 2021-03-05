import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Cell extends Pane {

    private String cellId;
    private Node view;

    private List<Cell> outBound = new ArrayList<>();
    private List<Cell> inBound = new ArrayList<>();

    // Constructor
    public Cell(String cellId) {
        this.cellId = cellId;
        this.relocate(500, 500);
    }

    // Set View
    public void setView(Node view) {
        this.view = view;
        getChildren().add(view);
    }

    // Graph List Representation
    public void addCellOutBound(Cell cell) {
        outBound.add(cell);
    }

    public void removeCellOutBound(Cell cell) {
        outBound.remove(cell);
    }

    public void addCellInBound(Cell cell) {
        inBound.add(cell);
    }

    public List<Cell> getCellInBound() {
        return inBound;
    }

    public String getCellId() {
        return cellId;
    }
}