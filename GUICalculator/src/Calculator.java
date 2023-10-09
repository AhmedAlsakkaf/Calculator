import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButttons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, dlelButton, clrButton;

    JPanel panel;
    Font font = new Font("Serif", Font.BOLD, 30);

    double num1=0;
    double numb2 = 0;
    double result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        dlelButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = dlelButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButttons[i] = new JButton(String.valueOf(i));
            numberButttons[i].addActionListener(this);
            numberButttons[i].setFont(font);
            numberButttons[i].setFocusable(false);
        }

        dlelButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);


        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4, 10, 10));
        panel.setBackground(Color.black);

        panel.add(numberButttons[1]);
        panel.add(numberButttons[2]);
        panel.add(numberButttons[3]);
        panel.add(addButton);

        panel.add(numberButttons[4]);
        panel.add(numberButttons[5]);
        panel.add(numberButttons[6]);
        panel.add(subButton);

        panel.add(numberButttons[7]);
        panel.add(numberButttons[8]);
        panel.add(numberButttons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButttons[0]);
        panel.add(equButton);
        panel.add(divButton);






        frame.add(panel);
        frame.add(dlelButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }





    public static void main(String args[]){
        Calculator calculator = new Calculator();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource()==numberButttons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton){
            numb2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result=num1+numb2;
                    break;
                case '-':
                    result = num1-numb2;
                    break;
                case '*':
                    result = num1*numb2;
                    break;
                case '/':
                    result = num1/numb2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }

        if (e.getSource()==dlelButton){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

    }



}
