package textExcel;

public class TextCell implements Cell {

	String text;
	
	public TextCell(String text) {
		if(text.indexOf("\"") >= 0) { //string literal
			this.text = text.substring(1, text.length() - 1);
		} else { //other values
			this.text = text;
		}
	}
	
	@Override
	public String abbreviatedCellText() {
		String spacedText = text;
		while(spacedText.length() < 10) {
			spacedText += " ";
		}
		return spacedText.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return "\"" + text + "\"";
	}

}
