package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells;

	public Spreadsheet() {
		cells = new Cell[20][12];
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 12; j++) {
				cells[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		String[] arguments = command.split(" ");
		
		if(command.toLowerCase().startsWith("clear")) { //clearing
			if(arguments.length > 1) { //clearing a particular cell
				SpreadsheetLocation loc = new SpreadsheetLocation(arguments[1]);
				cells[loc.getRow()][loc.getCol()] = new EmptyCell();
			} else { //clearing the entire sheet
				for(int i = 0; i < getRows(); i++) {
					for(int j = 0; j < getCols(); j++) {
						cells[i][j] = new EmptyCell();
					}
				}			
			}
			return getGridText();
		} else if(command.toLowerCase().startsWith("sort")) { //sorting
			String range = arguments[1];
			
			String str1 = range.substring(0, range.indexOf('-'));
			String str2 = range.substring(range.indexOf('-') + 1, range.length());
			
			SpreadsheetLocation loc1 = new SpreadsheetLocation(str1);
			SpreadsheetLocation loc2 = new SpreadsheetLocation(str2);
			
			boolean isAscend = command.toLowerCase().charAt(4) == 'a';
			
			if(getCell(loc1) instanceof TextCell) {
				sortText(loc1, loc2, isAscend);
			} else if(getCell(loc1) instanceof RealCell) {
				sortReal(loc1, loc2, isAscend);
			}
			
			return getGridText();
		} else {
			if(command.indexOf("=") >= 0) { //assignment
				SpreadsheetLocation loc = new SpreadsheetLocation(arguments[0]);
				if(arguments[2].indexOf("\"") >= 0) { //string literals
					cells[loc.getRow()][loc.getCol()] = new TextCell(command.substring(command.indexOf("=") + 2));
				} else if(arguments[2].indexOf("%") >= 0) { //percent values
					cells[loc.getRow()][loc.getCol()] = new PercentCell(arguments[2]);
				} else if(arguments[2].indexOf("(") >= 0) { //formula values
					cells[loc.getRow()][loc.getCol()] = new FormulaCell(command.substring(command.indexOf("=") + 2), this);
				} else { //double values
					cells[loc.getRow()][loc.getCol()] = new ValueCell(arguments[2]);
				}
				return getGridText();
			} else if(SpreadsheetLocation.isValidLocation(command)) { //cell inspection
				SpreadsheetLocation loc = new SpreadsheetLocation(arguments[0]);
				Cell c = getCell(loc);
				return c.fullCellText();
			} else {
				return "";
			}
		}
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cells[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String spreadsheet = "";
		for(int i = 0; i <= 20; i++) {
			for(char j = 'A'; j <= 'L'; j++) {
				if(i == 0) {
					if(j == 'A') {
						spreadsheet += "   |";
					}
					spreadsheet += String.format("%-10c|", j);
				} else {
					if(j == 'A') {
						spreadsheet += String.format("%-3d|", i);
					}
					spreadsheet += cells[i - 1][j - 'A'].abbreviatedCellText() + "|";
				}
			}
			spreadsheet += "\n";
		}
		
		return spreadsheet;
	}
	
	private void sortReal(SpreadsheetLocation loc1, SpreadsheetLocation loc2, boolean isAscend) {
		//TODO implement
	}
	
	private void sortText(SpreadsheetLocation loc1, SpreadsheetLocation loc2, boolean isAscend) {
		int rowEnd = loc2.getRow();
		int colEnd = loc2.getCol();
		
		boolean hasSwapped;
		
		do {
			hasSwapped = false;
			for(int rowStart = loc1.getRow(); rowStart <= rowEnd; rowStart++) {
				for(int colStart = loc1.getCol(); colStart <= colEnd; colStart++) {
					boolean lastInRow = colStart == colEnd;
					
					SpreadsheetLocation location1 = new SpreadsheetLocation(rowStart, colStart);
					SpreadsheetLocation location2 = new SpreadsheetLocation(!lastInRow ? rowStart : (rowStart + 1), !lastInRow ? (colStart + 1) : loc1.getCol());
	
					TextCell cell1 = (TextCell) getCell(location1);
					TextCell cell2 = (TextCell) getCell(location2);
	
					char cell1Char;
					char cell2Char;
					int i = -1;
	
					do {
						i++;
						cell1Char = cell1.fullCellText().toLowerCase().charAt(i);
						cell2Char = cell2.fullCellText().toLowerCase().charAt(i);
					} while(cell1Char == cell2Char);
	
					if((cell1Char > cell2Char && isAscend) || (cell1Char < cell2Char && !isAscend)) {
						//not alphabetized
						swapCells(location1, location2);
						hasSwapped = true;
					}
				}
			}
		} while(hasSwapped);
	}

	private void swapCells(SpreadsheetLocation loc1, SpreadsheetLocation loc2) {
		Cell temp = getCell(loc1);
		cells[loc1.getRow()][loc1.getCol()] = getCell(loc2);
		cells[loc2.getRow()][loc2.getCol()] = temp;
	}
}