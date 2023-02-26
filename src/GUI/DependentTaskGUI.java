package GUI;

import javax.swing.*;
import java.awt.*;

public class DependentTaskGUI extends JFrame {

    private JLabel jobIdLabel, currentTaskLabel, dependentTaskLabel;
    private JTextField jobIdField;
    private JComboBox<String> currentTaskComboBox, dependentTaskComboBox;
    private JButton addTaskButton;

    public DependentTaskGUI() {
        // set up the frame
        setTitle("Dependent Task Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create labels and fields
        jobIdLabel = new JLabel("Job ID:");
        currentTaskLabel = new JLabel("Current Task:");
        dependentTaskLabel = new JLabel("Dependent Task:");

        jobIdField = new JTextField(10);

        // create combo boxes
        currentTaskComboBox = new JComboBox<String>();
        dependentTaskComboBox = new JComboBox<String>();

        // create buttons
        addTaskButton = new JButton("Add Task");

        // create panel for fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(jobIdLabel);
        inputPanel.add(jobIdField);
        inputPanel.add(currentTaskLabel);
        inputPanel.add(currentTaskComboBox);
        inputPanel.add(dependentTaskLabel);
        inputPanel.add(dependentTaskComboBox);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addTaskButton);

        // add panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        DependentTaskGUI gui = new DependentTaskGUI();
    }
}
