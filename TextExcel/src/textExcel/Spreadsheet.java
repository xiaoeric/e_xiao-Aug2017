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
			
			String loc1 = range.substring(5,range.indexOf('-'));
			String loc2 = range.substring(range.indexOf('-') + 1, range.length());
			
			
			
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
	
	private void sortReal() {
		//TODO implement
	}
	
	private void sortText(String str1, String str2) {
		SpreadsheetLocation loc1 = new SpreadsheetLocation(str1);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(str2);
	
	
	}

}
