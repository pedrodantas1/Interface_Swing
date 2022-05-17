import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class SearchButton extends CustomButton {
    private JTextField textField;
    private int automatonID;

    public SearchButton(int id) {
        super(createIcon("procurar.png"));
        this.automatonID = id;
        setFocusPainted(false);
        setActionCommand("searchFile");
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

    public static ImageIcon createIcon(String path) {
        java.net.URL imgURL = SearchButton.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        }else{
            System.out.println("Não foi possível encontrar o arquivo: " + path);
            return null;
        }
    }

}