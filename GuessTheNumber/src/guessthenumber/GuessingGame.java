/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessthenumber;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame {

    private int secretNumber;
    private JTextField tf;
    private JLabel infoLabel, resultLabel;

    public GuessingGame() {
        secretNumber = (int) (Math.random() * 100 + 1);

        setTitle("Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);

        infoLabel = new JLabel("Guess a number between 1 and 100:");
        infoLabel.setBounds(50, 10, 300, 30);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setForeground(new Color(139, 0, 0)); 
        infoLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
        add(infoLabel);

        tf = new JTextField();
        tf.setBounds(125, 50, 150, 30);
        tf.setHorizontalAlignment(JTextField.CENTER);
        add(tf);

        JButton guessButton = new JButton("Make Guess");
        guessButton.setBounds(125, 90, 150, 30);
        add(guessButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 130, 300, 30);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(tf.getText());
                    if (guess < secretNumber) {
                        resultLabel.setText("Try a larger number.");
                    } else if (guess > secretNumber) {
                        resultLabel.setText("Try a smaller number.");
                    } else {
                        resultLabel.setText("Congratulations! Correct guess.");
                    }
                    tf.setText(""); 
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        tf.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!tf.getText().isEmpty()) {
                    resultLabel.setText("");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!tf.getText().isEmpty()) {
                    resultLabel.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!tf.getText().isEmpty()) {
                    resultLabel.setText("");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}

