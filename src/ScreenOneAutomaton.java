import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenOneAutomaton extends JPanel {
    private AppInterface controller;

    public ScreenOneAutomaton(AppInterface frame) {
        super(new BorderLayout());
        this.controller = frame;
        createScreen();
    }

    private void createScreen() {
        createHeader();
        createBody();
        createFooter();
    }

    private void createHeader() {
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
                controller.setContentPane(AppInterface.homeScreen);
                controller.setVisible(true);
            }
        });
        header.add(voltar, BorderLayout.WEST);

        add(header, BorderLayout.NORTH);
    }

    private void createBody() {
        JPanel operationPanel = new JPanel(new GridBagLayout());
        operationPanel.setBackground(Color.PINK);
        GridBagConstraints gbc = new GridBagConstraints();
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 125, 0, 125));

        //Selecionar automato
        //Label
        JLabel automatoText = new JLabel("Autômato:");
        Font textFont = new Font("Arial", Font.BOLD, 18);
        automatoText.setFont(textFont);
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

        add(operationPanel, BorderLayout.CENTER);
    }

    private void createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        JLabel creditos = new JLabel("<html>Desenvolvido por alunos da UFS - DSI &copy;</html>");
        Font textFont = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 14);
        creditos.setFont(textFont);
        creditos.setForeground(Color.BLUE);
        footer.setBorder(BorderFactory.createEmptyBorder(100, 5, 5, 0));
        footer.add(creditos, BorderLayout.WEST);
        
        add(footer, BorderLayout.SOUTH);
    }

}