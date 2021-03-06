import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Cell extends Pane {

    private int cellId;
    private String cellName;
    private Node view;

    private List<Cell> outBound = new ArrayList<>();
    private List<Cell> inBound = new ArrayList<>();

    // Constructor
    public Cell(int cellId, String cellName) {
        this.cellId = cellId;
        this.cellName = cellName;
        this.relocate(500, 500);
    }

    // Set View
    public void setView(Node view) {
        this.view = view;

        Label idText = new Label();
        idText.setText(String.valueOf(cellId));
        idText.setPrefSize(50, 50);
        idText.setAlignment(Pos.CENTER);

        Label nameText = new Label();
        nameText.setText(cellName);
        nameText.setPrefSize(50, 50);
        nameText.setAlignment(Pos.BOTTOM_CENTER);

        getChildren().add(view);
        getChildren().add(idText);
        getChildren().add(nameText);
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

    public int getCellId() {
        return cellId;
    }
}