package textExcel;

public class FormulaCell extends RealCell {

	public FormulaCell(String formula) {
		super(formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		String text = Double.toString(getDoubleValue());
		while(text.length() < 10) {
			text += " ";
		}
		return text.substring(0, 10);
	}

	@Override
	public double getDoubleValue() {
		String formula = userInput.substring(2, userInput.length() - 2);

		double result;
		
		if(formula.startsWith("SUM")) {
			String loc1 = formula.substring(4,formula.indexOf('-'));
			String loc2 = formula.substring(formula.indexOf('-'), formula.length());
			
			double sum = Double.parseDouble(sum(loc1, loc2));
			
			result = sum;
		} else if(formula.startsWith("AVG")) {
			String loc1 = formula.substring(4,formula.indexOf('-'));
			String loc2 = formula.substring(formula.indexOf('-'), formula.length());
			
			double sum = Double.parseDouble(sum(loc1, loc2));
			double count = Double.parseDouble(count(loc1, loc2));
			
			result = sum/count;
		} else {
			result = Double.parseDouble(evaluate(formula));
		}
		
		return result;
	}
	
	private String sum(String str1, String str2) {
		SpreadsheetLocation loc1 = new SpreadsheetLocation(str1);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(str2);
		int sum = 0;
		
		for(int i = loc1.getRow(); i <= loc2.getRow(); i++) {
			for(int j = loc1.getCol(); j <= loc2.getCol(); j++) {
				sum += ((RealCell)TextExcel.spreadsheet.getCell(new SpreadsheetLocation(Character.getName(j + 'A') + i))).getDoubleValue();
			}
		}
		
		return Integer.toString(sum);
	}
	
	private String count(String str1, String str2) {
		SpreadsheetLocation loc1 = new SpreadsheetLocation(str1);
		SpreadsheetLocation loc2 = new SpreadsheetLocation(str2);
		int count = 0;
		
		for(int i = loc1.getRow(); i <= loc2.getRow(); i++) {
			for(int j = loc1.getCol(); j <= loc2.getCol(); j++) {
				count++;
			}
		}
		
		return Integer.toString(count);
	}
	
	private String evaluate(String formula) {
		String[] arguments = formula.split(" "); //without parenthesis
		
		if(arguments.length < 3) {
			return arguments[0];
		}
		
		double firstOperand = getValue(arguments[0]);
		double secondOperand = getValue(arguments[2]);
		String operator = arguments[1];
		
		String result;
		
		if(operator.equals("+")) {
			result = Double.toString(firstOperand + secondOperand);
		} else if(operator.equals("-")) {
			result = Double.toString(firstOperand - secondOperand);
		} else if(operator.equals("*")) {
			result = Double.toString(firstOperand * secondOperand);
		} else if(operator.equals("/")) {
			result = Double.toString(firstOperand / secondOperand);
		} else {
			result = "ERROR";
		}
		
		if(arguments.length > 3) {
			for(int i = 3; i < arguments.length; i++) {
				result += " " + arguments[i];
			}
			return evaluate(result);
		} else {
			return result;
		}
	}
	
	private double getValue(String operand) {
		if(SpreadsheetLocation.isValidLocation(operand)) { //TODO: check if actually a location; "-1" passes
			Cell c = TextExcel.spreadsheet.getCell(new SpreadsheetLocation(operand));
			if(c instanceof RealCell) {
				return ((RealCell) c).getDoubleValue();
			} else {
				return 1;
			}
		} else {
			return Double.parseDouble(operand);
		}
	}
}
