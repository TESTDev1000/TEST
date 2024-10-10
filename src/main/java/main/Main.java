package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class Main {
    private final JFrame frame;
    private final JTextField loginField;
    private final JPasswordField passwordField;

    public Main() {
        //CREATE WINDOW
        frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //WINDOW SIZE
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width / 2;
        int height = screenSize.height / 2;

        //SETTINGS WINDOW
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // LOGIN
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Login:"), gbc);

        gbc.gridx = 1;
        frame.add(loginField = new JTextField(screenSize.width / 80), gbc);

        // PASSWORD
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        frame.add(passwordField = new JPasswordField(screenSize.width / 80), gbc);

        // ENTER
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton enterButton = new JButton("Enter");
        frame.add(enterButton, gbc);
        enterButton.addActionListener(new LoginAction());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private class LoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());

            if (login.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(frame, "Welcome, Admin!");
            }
            else if (login.equals("user") && password.equals("user")) {
                JOptionPane.showMessageDialog(frame, "Welcome, User!");
            }
            else {
                JOptionPane.showMessageDialog(frame, "Invalid login or password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}