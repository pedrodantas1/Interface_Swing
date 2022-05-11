import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class SearchButton extends CustomButton {
    private JTextField textField;
    private int automatonID;

    public SearchButton(ImageIcon icon, int id) {
        super(icon);
        this.automatonID = id;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void setPathInTextField(String path) {
        textField.setText(path);
    }

    public int getAutomatonID() {
        return automatonID;
    }

}