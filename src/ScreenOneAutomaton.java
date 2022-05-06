import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenOneAutomaton extends JPanel implements ActionListener{
    private AppInterface controller;
    private String title;

    private boolean selectedAFD;

    public ScreenOneAutomaton(AppInterface frame, String title) {
        super(new BorderLayout());
        this.controller = frame;
        this.title = title;
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
        //titulo.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        titulo.setFont(textFont);
        titulo.setForeground(Color.WHITE);
        titulo.setPreferredSize(new Dimension(900, 150));
        titulo.setOpaque(true);
        titulo.setBackground(Color.BLUE);
        main.add(titulo, BorderLayout.CENTER);

        JButton voltar;
        Font voltaFont = new Font("Arial", Font.BOLD, 18);
        titulo.setFont(textFont);
        Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        voltar = new JButton("Voltar");
        voltar.setFont(voltaFont);
        voltar.setBorder(border3);
        voltar.setForeground(Color.BLACK);
        voltar.setFocusPainted(false);
        voltar.add(Box.createRigidArea(new Dimension(80, 0)));
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setContentPane(AppInterface.homeScreen);
                controller.setVisible(true);
            }
        });
        main.add(voltar, BorderLayout.WEST);

        add(main, BorderLayout.NORTH);
    }

    private void createBodyOneAut() {
        JPanel operationPanel = new JPanel(new GridBagLayout());
        operationPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

        //Selecionar automato
        //Label
        JLabel automatoText = new JLabel("Autômato:");
        Font textFont = new Font("Arial", Font.BOLD, 18);
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

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Border border = BorderFactory.createRaisedBevelBorder();

        b1 = new JButton("<html><center>Realizar<br/>operação</center></html>");
        b1.setFont(buttonFont);
        b1.setForeground(Color.BLACK);
        b1.setBorder(border);
        b1.setFocusPainted(false);
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 75;
        gbc.ipady = 30;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets.set(50, 0, 0, 90);
        operationPanel.add(b1, gbc);

        add(operationPanel, BorderLayout.CENTER);
    }

    private void createBodyTwoAut() {
        JPanel operationPanel = new JPanel(new GridBagLayout());
        operationPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

        //Tipo do automato
        JLabel typeAut = new JLabel("Tipo do autômato:");
        Font textFont = new Font("Arial", Font.BOLD|Font.ITALIC, 18);
        typeAut.setFont(textFont);
        typeAut.setForeground(Color.BLACK);
        
        //Criar botoes
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
        JPanel typeAutBox = new JPanel();
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
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        operationPanel.add(typeAutBox, gbc);

        //Selecionar automato
        //Label 1
        JLabel automatoText = new JLabel("1° autômato:");
        textFont = new Font("Arial", Font.BOLD, 18);
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
        gbc.insets.set(30, 0, 0, 10);
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
        gbc.insets.set(30, 0, 0, 10);
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
        gbc.insets.set(30, 0, 0, 0);
        operationPanel.add(b1, gbc);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Border border = BorderFactory.createRaisedBevelBorder();

        b1 = new JButton("<html><center>Realizar<br/>operação</center></html>");
        b1.setFocusPainted(false);
        b1.setFont(buttonFont);
        b1.setForeground(Color.BLACK);
        b1.setBorder(border);
        gbc.fill =  GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 75;
        gbc.ipady = 30;
        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets.set(30, 0, 0, 90);
        operationPanel.add(b1, gbc);

        add(operationPanel, BorderLayout.CENTER);
    }

    private void createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
        Font textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
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
        }else{
            System.out.println("\nteste");
            selectedAFD = false;
        }
        
    }

}