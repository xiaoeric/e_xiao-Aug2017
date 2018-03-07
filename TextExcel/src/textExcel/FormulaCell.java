package textExcel;

public class FormulaCell extends RealCell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "PLACEHOLD";
	}

	@Override
	public double getDoubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
