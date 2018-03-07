package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell[][] cells;
	
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
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
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
					spreadsheet += "          |";
				}
			}
			spreadsheet += "\n";
		}
		
		return spreadsheet;
	}

}
