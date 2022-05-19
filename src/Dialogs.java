import javax.swing.JOptionPane;

public class Dialogs {
    
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showMessage(String title ,String message) {
        JOptionPane.showMessageDialog(null, message, title, 
        JOptionPane.INFORMATION_MESSAGE);
    }

}