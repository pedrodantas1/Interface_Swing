import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenOneAutomaton extends JPanel implements ActionListener {
    private AppInterface controller;
    private String title;
    private GridBagConstraints gbc;

    private Font textFont;
    private Font buttonFont;
    private Border border;

    private boolean selectedAFD;

    private JButton readyButton;
    private JButton backButton;
    private JPanel typeAutBox;

    public ScreenOneAutomaton(AppInterface frame) {
        super(new BorderLayout());
        this.controller = frame;
        this.title = "Título indefinido";
        this.gbc = new GridBagConstraints();

        buttonFont = new Font("Arial", Font.BOLD, 16);
        border = BorderFactory.createRaisedBevelBorder();
        
        createButtons();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void createButtons() {
        //Botao de realizar operacao
        readyButton = new JButton("<html><center>Realizar<br/>operação</center></html>");
        readyButton.setFont(buttonFont);
        readyButton.setForeground(Color.BLACK);
        readyButton.setBorder(border);
        readyButton.setFocusPainted(false);

        //Botao de voltar a tela inicial
        backButton = new JButton("Voltar");
        backButton.setFont(buttonFont);
        backButton.setBorder(border);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setContentPane(AppInterface.homeScreen);
                controller.setVisible(true);
            }
        });

        //Criar botoes de escolha entre AFD e AFN
        textFont = new Font("Arial", Font.BOLD|Font.ITALIC, 18);
        JLabel typeAut = new JLabel("Tipo do autômato:");
        typeAut.setFont(textFont);
        typeAut.setForeground(Color.BLACK);

        Font radioFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 15);
        JRadioButton afdButton = new JRadioButton("AFD");
        afdButton.setFocusPainted(false);
        afdButton.setFont(radioFont);
        afdButton.setBackground(Color.PINK);
        afdButton.setForeground(Color.BLACK);
        afdButton.setActionCommand("typeAFD");
        afdButton.setSelected(true);
        selectedAFD = true;
        afdButton.addActionListener(this);

        JRadioButton afnButton = new JRadioButton("AFN");
        afnButton.setFocusPainted(false);
        afnButton.setFont(radioFont);
        afnButton.setBackground(Color.PINK);
        afnButton.setForeground(Color.BLACK);
        afnButton.setActionCommand("typeAFN");
        afnButton.addActionListener(this);

        //Agrupar botoes
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(afdButton);
        typeGroup.add(afnButton);

        //Organizar box completa
        typeAutBox = new JPanel();
        typeAutBox.setBackground(Color.PINK);
        typeAutBox.setLayout(new BoxLayout(typeAutBox, BoxLayout.LINE_AXIS));
        typeAutBox.add(Box.createRigidArea(new Dimension(10, 40)));
        typeAutBox.add(typeAut);
        typeAutBox.add(Box.createRigidArea(new Dimension(20, 0)));
        typeAutBox.add(afdButton);
        typeAutBox.add(Box.createRigidArea(new Dimension(40, 0)));
        typeAutBox.add(afnButton);
        typeAutBox.add(Box.createRigidArea(new Dimension(10, 0)));
        typeAutBox.setBorder(BorderFactory.createCompoundBorder(
                             BorderFactory.createRaisedBevelBorder(),
                             BorderFactory.createLoweredBevelBorder()));
    }

    public void createScreenOne() {
        createHeader();
        createBodyOneAut();
        createFooter();
    }

    public void createScreenTwo() {
        createHeader();
        createBodyTwoAut();
        createFooter();
    }

    private void createHeader() {
        JPanel main = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel(title, JLabel.CENTER);
        Font textFont = new Font("Arial", Font.BOLD, 40);
        titulo.setFont(textFont);
        titulo.setForeground(Color.WHITE);
        titulo.setPreferredSize(new Dimension(900, 150));
        titulo.setOpaque(true);
        titulo.setBackground(Color.BLUE);
        main.add(titulo, BorderLayout.CENTER);

        add(main, BorderLayout.NORTH);
    }

    private void createBodyOneAut() {
        JPanel operationPanel = new JPanel(new GridBagLayout());
        operationPanel.setBackground(Color.PINK);
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

        //Selecionar automato
        //Label
        textFont = new Font("Arial", Font.BOLD, 18);
        JLabel automatoText = new JLabel("Autômato:");
        automatoText.setFont(textFont);
        automatoText.setForeground(Color.BLACK);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
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
        b1.setFocusPainted(false);
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.ipadx = -25;
        gbc.ipady = -2;
        gbc.weightx = 0;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets.set(0, 0, 0, 0);
        operationPanel.add(b1, gbc);

        //Config do readyButton
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 75;
        gbc.ipady = 30;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets.set(50, 0, 0, 80);
        operationPanel.add(readyButton, gbc);

        //Config do backButton
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 40;
        gbc.ipady = 20;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets.set(20, 0, 0, 80);
        operationPanel.add(backButton, gbc);

        add(operationPanel, BorderLayout.CENTER);
    }

    private void createBodyTwoAut() {
        JPanel operationPanel = new JPanel(new GridBagLayout());
        operationPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

        //Config do typeAutBox
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        operationPanel.add(typeAutBox, gbc);

        //Selecionar automato
        //Label 1
        textFont = new Font("Arial", Font.BOLD, 18);
        JLabel automatoText = new JLabel("1° autômato:");
        automatoText.setFont(textFont);
        automatoText.setForeground(Color.BLACK);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets .set(0, 0, 0, 10);
        operationPanel.add(automatoText, gbc);

        //TextField (Por enquanto nao editavel; Atualiza com o path apos pesquisar o arquivo)
        JTextField textField = new JTextField(40);
        textField.setEditable(false);
        gbc.fill =  GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipady = 5;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets.set(0, 0, 0, 10);
        operationPanel.add(textField, gbc);

        //Botao de pesquisar arquivo (FileChooser)
        JButton b1;
        b1 = new JButton(new ImageIcon(AppInterface.class.getResource("procurar.png")));
        b1.setFocusPainted(false);
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.ipadx = -25;
        gbc.ipady = -2;
        gbc.weightx = 0;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets.set(0, 0, 0, 0);
        operationPanel.add(b1, gbc);

        //Label 2
        automatoText = new JLabel("2° autômato:");
        automatoText.setFont(textFont);
        automatoText.setForeground(Color.BLACK);
        gbc.fill =  GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets.set(20, 0, 0, 10);
        operationPanel.add(automatoText, gbc);

        //TextField (Por enquanto nao editavel; Atualiza com o path apos pesquisar o arquivo)
        textField = new JTextField(40);
        textField.setEditable(false);
        gbc.fill =  GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipady = 5;
        gbc.weightx = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets.set(20, 0, 0, 10);
        operationPanel.add(textField, gbc);

        //Botao de pesquisar arquivo (FileChooser)
        b1 = new JButton(new ImageIcon(AppInterface.class.getResource("procurar.png")));
        b1.setFocusPainted(false);
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.ipadx = -25;
        gbc.ipady = -2;
        gbc.weightx = 0;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets.set(20, 0, 0, 0);
        operationPanel.add(b1, gbc);

        //Config do readyButton
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 75;
        gbc.ipady = 30;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets.set(30, 0, 0, 90);
        operationPanel.add(readyButton, gbc);

        //Config do backButton
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 40;
        gbc.ipady = 20;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets.set(20, 0, 0, 90);
        operationPanel.add(backButton, gbc);

        add(operationPanel, BorderLayout.CENTER);
    }

    private void createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
        textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        footer.setBorder(BorderFactory.createEmptyBorder(50, 5, 5, 0));
        footer.add(creditos, BorderLayout.WEST);
        
        add(footer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("typeAFD")){
            selectedAFD = true;
        }else if (action.equals("typeAFN")){
            selectedAFD = false;
        }else if (action.equals("Uniao")){

        }
        
    }

}