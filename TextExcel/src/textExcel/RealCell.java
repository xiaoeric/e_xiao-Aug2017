package textExcel;

public abstract class RealCell implements Cell {
	
	protected String userInput;
	
	public RealCell(String input) {
		userInput = input;
	}
	
	@Override
	public String fullCellText() {
		return userInput;
	}
	
	public abstract double getDoubleValue();

}
