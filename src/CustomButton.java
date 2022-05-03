import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CustomButton extends JButton {

    public CustomButton() {
        super();
    }

    public CustomButton(String nome) {
        super(nome);
    }

    public CustomButton(Icon icon) {
        super(icon);
    }

    public CustomButton(String nome, Icon icon) {
        super(nome, icon);
    }

}