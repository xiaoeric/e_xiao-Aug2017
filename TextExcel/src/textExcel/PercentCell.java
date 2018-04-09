package textExcel;

public class PercentCell extends RealCell {

	double decimal;
	
	public PercentCell(String percent) {
		super(percent);
		decimal = Double.parseDouble(percent.substring(0, percent.length()-1)) / 100.0;
	}
	
	@Override
	public String abbreviatedCellText() {
		boolean isDecimal = userInput.indexOf(".") >= 0;
		
		String text = userInput.substring(0, isDecimal ? userInput.indexOf(".") : userInput.indexOf("%")) + "%";
		while(text.length() < 10) {
			text += " ";
		}
		return text.substring(0, 10);
	}
	
	@Override
	public String fullCellText() {
		return Double.toString(decimal);
	}

	@Override
	public double getDoubleValue() {
		return decimal;
	}

}
