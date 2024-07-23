
public class Cell {
  /* CELL DATA */
  private CellType cellType;
  private final int row, col;

  public Cell(int row, int col){
    this.row = row;
    this.col = col;
  }

  public CellType getCellType(){
    return this.cellType;
  }

  public int getRow(){
    return this.row;
  }

  public int getCol(){
    return this.col;
  }

  public void setCellType(CellType type){
    this.cellType = type;
  }

}