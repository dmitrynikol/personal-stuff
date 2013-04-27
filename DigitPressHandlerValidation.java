import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.ui.TextBox;

/**
 * GWT. Check for integer number in GWT text boxes.
 * 
 * @author Dmitry Nikolaenko
 * 
 */
public class DigitPressHandlerValidation implements KeyPressHandler {
	
	private TextBox textField;
	
	public DigitPressHandlerValidation(TextBox textField) {
		this.textField = textField;
	}
	
	@Override
	public void onKeyPress(KeyPressEvent event) {
		int keyCode = event.getNativeEvent().getKeyCode();
		if (!Character.isDigit((char) event.getUnicodeCharCode()) && 
				((char) keyCode != (char) KeyCodes.KEY_BACKSPACE) &&
				((char) keyCode != (char) KeyCodes.KEY_LEFT) &&
				((char) keyCode != (char) KeyCodes.KEY_RIGHT) &&
				((char) keyCode != (char) KeyCodes.KEY_DELETE)) {
			if (!textField.getText().trim().isEmpty()) {
				int value = Integer.valueOf(textField.getText());
				if (KeyUpEvent.isArrow(keyCode) && ((char) keyCode == (char) KeyCodes.KEY_UP) && value <= 999999999) {
					value++;
				}
				if (KeyDownEvent.isArrow(keyCode) && ((char) keyCode == (char) KeyCodes.KEY_DOWN) && value >= 1) {
					value--;
				}
				textField.setText(String.valueOf(value));
			}
			event.preventDefault();
			event.stopPropagation();
		}
	}
}