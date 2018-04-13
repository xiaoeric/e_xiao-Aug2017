package textExcel;

public abstract class RealCell implements Cell{
	
	protected String userInput;
	
	public RealCell(String input) {
		userInput = input;
	}
	
	@Override
	public String fullCellText() {
		return userInput;
	}
	
	public abstract double getDoubleValue();

	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof RealCell) {
			RealCell arg = (RealCell) arg0;
			if(arg.getDoubleValue() > getDoubleValue()) {
				return -1;
			} else if(arg.getDoubleValue() < getDoubleValue()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 1;
		}
	}
}
