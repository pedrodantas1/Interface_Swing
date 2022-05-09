import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class SearchButton extends CustomButton {
    private JTextField textField;

    public SearchButton(ImageIcon icon) {
        super(icon);
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void setPathInTextField(String path) {
        textField.setText(path);
    }

}