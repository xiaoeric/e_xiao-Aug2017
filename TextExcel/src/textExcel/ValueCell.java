package textExcel;

public class ValueCell extends RealCell {

	double value;
	
	public ValueCell(String value) {
		super(value);
		this.value = Double.parseDouble(value);
	}
	
	@Override
	public double getDoubleValue() {
		return value;
	}

	@Override
	public String abbreviatedCellText() {
		String text = Double.toString(getDoubleValue());
		while(text.length() < 10) {
			text += " ";
		}
		return text.substring(0, 10);
	}

}
