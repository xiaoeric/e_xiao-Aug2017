package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int row;
	int col;
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	row = Integer.parseInt(cellName.substring(1)) - 1;
    	col = Character.toUpperCase(cellName.charAt(0)) - 'A';
    }
    
    public static boolean isValidLocation(String test) {
    	int temp;
    	try {
    		temp = Integer.parseInt(test.substring(1)) - 1;
    		temp = Character.toUpperCase(test.charAt(0)) - 'A';
    	} catch (Exception e) {
    		return false;
    	}
    	return true;
    }
}
