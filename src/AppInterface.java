import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class AppInterface extends JFrame {
    private static AppInterface frame;
    private static JPanel homeScreen;

    public AppInterface(String titulo) {
        super(titulo);
        //setResizable(false);
        setSize(900, 600);
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
        homeScreen = new JPanel(new BorderLayout());
        this.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
                Dimension currentSize = AppInterface.this.getSize();
                Dimension minSize = AppInterface.this.getMinimumSize();
                if (currentSize.width < minSize.width){
                    currentSize.width = minSize.width;
                    setLocationRelativeTo(null);
                }
                if (currentSize.height < minSize.height){
                    currentSize.height = minSize.height;
                    setLocationRelativeTo(null);
                }
                AppInterface.this.setSize(currentSize);
            }
        });
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
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 150));
        GridLayout grid = new GridLayout(0, 3);
        buttonsPanel.setLayout(grid);
        buttonsPanel.setBackground(Color.BLUE);
        grid.setHgap(60);
        grid.setVgap(40);
        JButton b1;
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        b1 = new JButton("União");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(b1);
        
        b1 = new JButton("Intersecção");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(b1);

        b1 = new JButton("Concatenação");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(b1);

        b1 = new JButton("Complemento");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewScreenOneAutomaton panel = new NewScreenOneAutomaton();
                setContentPane(panel);
                setVisible(true);
            }
        });
        buttonsPanel.add(b1);

        b1 = new JButton("Estrela");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(b1);

        b1 = new JButton("<html><center>Gerar AFD<br/>equivalente</center></html>");
        b1.setFont(buttonFont);
        b1.setBorder(border);
        b1.setBackground(Color.WHITE);
        b1.add(Box.createRigidArea(new Dimension(120, 60)));
        buttonsPanel.add(b1);

        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
        textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        footer.setBorder(BorderFactory.createEmptyBorder(150, 5, 5, 0));
        footer.add(creditos, BorderLayout.WEST);

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(footer, BorderLayout.SOUTH);

        return mainPanel;
    }

    private class NewScreenOneAutomaton extends JPanel {

        public NewScreenOneAutomaton() {
            super(new BorderLayout());
            JPanel header = new JPanel(new BorderLayout());
            JLabel titulo = new JLabel("Complemento de um autômato", JLabel.CENTER);
            Font textFont = new Font("Arial", Font.BOLD, 40);
            titulo.setFont(textFont);
            titulo.setForeground(Color.WHITE);
            titulo.setPreferredSize(new Dimension(900, 200));
            titulo.setOpaque(true);
            titulo.setBackground(Color.BLUE);
            header.add(titulo, BorderLayout.CENTER);

            JButton voltar;
            Font voltaFont = new Font("Arial", Font.BOLD, 18);
            titulo.setFont(textFont);
            Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
            voltar = new JButton("Voltar");
            voltar.setFont(voltaFont);
            voltar.setBorder(border3);
            //voltar.setBackground(Color.RED);
            voltar.setForeground(Color.BLACK);
            //voltar.setContentAreaFilled(false);
            voltar.setFocusPainted(false);
            voltar.add(Box.createRigidArea(new Dimension(80, 0)));
            voltar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setContentPane(homeScreen);
                    frame.setVisible(true);
                }
            });
            header.add(voltar, BorderLayout.WEST);

            JPanel operationPanel = new JPanel(new GridBagLayout());
            operationPanel.setBackground(Color.PINK);
            GridBagConstraints gbc = new GridBagConstraints();
            operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

            //Selecionar automato
            //Label
            JLabel automatoText = new JLabel("Autômato:");
            textFont = new Font("Arial", Font.BOLD, 18);
            automatoText.setFont(textFont);
            //gbc.fill =  GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            //gbc.weightx = 0.1;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 0, 10);
            operationPanel.add(automatoText, gbc);

            //TextField (Por enquanto nao editavel; Atualiza com o path apos pesquisar o arquivo)
            JTextField textField = new JTextField(40);
            textField.setEditable(false);
            gbc.fill =  GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipady = 5;
            gbc.weightx = 1;
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets.set(0, 0, 0, 10);
            operationPanel.add(textField, gbc);

            //Botao de pesquisar arquivo (FileChooser)
            JButton b1;
            b1 = new JButton(new ImageIcon(AppInterface.class.getResource("procurar.png")));
            gbc.fill =  GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.FIRST_LINE_END;
            gbc.ipadx = -25;
            gbc.ipady = -2;
            gbc.weightx = 0;
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.insets.set(0, 0, 0, 0);
            operationPanel.add(b1, gbc);

            Font buttonFont = new Font("Arial", Font.BOLD, 16);
            Border border = BorderFactory.createRaisedBevelBorder();

            b1 = new JButton("<html><center>Realizar<br/>operação</center></html>");
            b1.setFont(buttonFont);
            b1.setBorder(border);
            b1.setFocusPainted(false);
            gbc.fill =  GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.ipadx = 80;
            gbc.ipady = 20;
            gbc.weightx = 0;
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.insets.set(50, 0, 0, 10);
            operationPanel.add(b1, gbc);

            JPanel footer = new JPanel(new BorderLayout());
            JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
            textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
            creditos.setFont(textFont);
            creditos.setForeground(Color.BLUE);
            footer.setBorder(BorderFactory.createEmptyBorder(100, 5, 5, 0));
            footer.add(creditos, BorderLayout.WEST);

            add(header, BorderLayout.NORTH);
            add(operationPanel, BorderLayout.CENTER);
            add(footer, BorderLayout.SOUTH);
        }

    }

    private static void createAndShowGUI() {
        frame = new AppInterface("Operador de autômatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //Criar containers e fazer as contruções necessárias
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