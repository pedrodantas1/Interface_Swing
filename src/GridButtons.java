import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridButtons extends JPanel implements ActionListener {
    private static LayoutManager layout = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    
    private CustomButton[] buttons;  //Posteriormente sera customButton
    private int numButtons;
    private int cols;
    private int rows;

    private Font font;
    private Border border;
    private Color bgColor;
    private Color textColor;
    
    public GridButtons(int numButtons, int cols) {
        super(layout);
        this.numButtons = numButtons;
        this.cols = cols;
        if (cols > numButtons){
            this.cols = this.numButtons;
        }
        if (this.cols == this.numButtons){
            this.rows = 1;
        }else{
            this.rows = this.numButtons / this.cols;
        }
        buttons = new CustomButton[numButtons];
        this.border = null;
        this.bgColor = null;
        this.textColor = Color.BLACK;
    }

    public void setButtonFont(Font font) {
        this.font = font;
    }

    public void setFontSize(int size) {
        font = font.deriveFont(font.getStyle(), size);
    }

    public void setFontStyle(int style) {
        font = font.deriveFont(style);
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public void setBgColor(Color color) {
        this.bgColor = color;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
    }

    public void addButtons(String[] names) {
        int row = 0;
        int col = 0;
        for (int i=0; i<numButtons; i++){
            CustomButton button = new CustomButton(names[i]);
            button.setPadding(140, 65);
            button.setFont(font);
            button.setBorder(border);
            button.setBackground(bgColor);
            button.setForeground(textColor);
            gbc.insets.set(0, 0, 0, 0);
            gbc.fill =  GridBagConstraints.NONE;
            gbc.ipadx = 0;
            gbc.ipady = 0;
            gbc.weightx = 0;
            gbc.weighty = 0;
            if (col != cols-1){
                gbc.insets.right = 60;
            }
            if (row != rows-1){
                gbc.insets.bottom = 30;
            }
            gbc.gridx = col++;
            gbc.gridy = row;

            if (i == 3){
                button.addActionListener(this);
            }
            buttons[i] = button;
            add(button, gbc);

            if (col == cols){
                col = 0;
                row++;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("\nCliquei");
    }

}