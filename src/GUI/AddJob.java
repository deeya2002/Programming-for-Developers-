package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddJob {
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JTextField titleField;
    private JTextArea descriptionField;
    private JButton addButton;

    public AddJob() {
        // Create the frame and panel
        frame = new JFrame("Add Job");
        panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel);

        // Create the title label and field
        titleLabel = new JLabel("Job Id:");
        titleField = new JTextField(20);

        // Create the description label and field
        descriptionLabel = new JLabel("Job Name:");
        descriptionField = new JTextArea(2, 20);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionField);

        // Create the add button
        addButton = new JButton("Add Job");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionField.getText();

                // Do something with the title and description
                System.out.println("Job Id: " + title);
                System.out.println("Job Name: " + description);

                // Clear the fields
                titleField.setText("");
                descriptionField.setText("");
            }
        });

        // Add components to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(titleLabel, c);

        c.gridx = 1;
        panel.add(titleField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(descriptionLabel, c);

        c.gridx = 1;
        panel.add(scrollPane, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(addButton, c);

        // Configure the frame
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AddJob gui = new AddJob();
    }
}
