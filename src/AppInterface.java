import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AppInterface extends JFrame {
    private static AppInterface frame;
    public static JPanel homeScreen;

    public AppInterface(String titulo) {
        super(titulo);
        setResizable(false);
        setSize(900, 600);
        setLocationRelativeTo(null);
    }

    public JPanel createHomeScreen() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel header = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Operador de autômatos finitos", JLabel.CENTER);
        Font textFont = new Font("Arial", Font.BOLD, 40);
        titulo.setFont(textFont);
        titulo.setForeground(Color.WHITE);
        titulo.setPreferredSize(new Dimension(900, 200));
        titulo.setOpaque(true);
        titulo.setBackground(Color.pink);
        header.add(titulo, BorderLayout.NORTH);
        
        GridButtons buttonsPanel = new GridButtons(frame, 6, 3);
        String[] buttonNames = {"União", "Intersecção", "Concatenação",
                                "Complemento", "Estrela", 
                                "<html><center>Gerar AFD<br/>equivalente</center></html>"};
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        buttonsPanel.setBackground(Color.BLUE);
        buttonsPanel.setButtonFont(buttonFont);
        buttonsPanel.setBorder(border);
        buttonsPanel.setBgColor(Color.WHITE);
        buttonsPanel.setTextColor(Color.BLACK);
        buttonsPanel.addButtons(buttonNames);

        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
        textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        footer.setBackground(Color.BLACK);
        footer.setBorder(BorderFactory.createEmptyBorder(100, 5, 5, 0));
        footer.add(creditos, BorderLayout.WEST);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        return mainPanel;
    }

    private static void createAndShowGUI() {
        frame = new AppInterface("Operador de autômatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Cria tela inicial e seta seu conteudo no frame
        homeScreen = frame.createHomeScreen();
        frame.setContentPane(homeScreen);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}