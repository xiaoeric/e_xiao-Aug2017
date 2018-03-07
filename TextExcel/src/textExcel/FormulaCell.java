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
		return Double.parseDouble(evaluate(formula));
	}
	
	private String evaluate(String formula) {
		String[] arguments = formula.split(" ");
		
		if(arguments.length < 3) {
			return arguments[0];
		}
		
		double firstOperand = Double.parseDouble(arguments[0]);
		double secondOperand = Double.parseDouble(arguments[2]);
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
		if(SpreadsheetLocation.isValidLocation(operand)) {
			
		} else {
			
		}
	}
}
