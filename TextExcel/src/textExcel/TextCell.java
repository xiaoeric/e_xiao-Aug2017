package textExcel;

public class TextCell implements Cell{

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

	@Override
	public int compareTo(Object o) {
		if(o instanceof TextCell) {
			TextCell cell2 = (TextCell) o;
			
			char cell1Char;
			char cell2Char;
			int i = -1;
	
			do {
				i++;
				cell1Char = fullCellText().toLowerCase().charAt(i);
				cell2Char = cell2.fullCellText().toLowerCase().charAt(i);
			} while(cell1Char == cell2Char && i < fullCellText().length() - 1);
			
			if(cell1Char > cell2Char) {
				return 1;
			} else if(cell1Char < cell2Char) {
				return -1;
			} else {
				return 0;
			}
		} else if(o instanceof RealCell) {
			return -1;
		} else {
			return 1;
		}
	}

}
