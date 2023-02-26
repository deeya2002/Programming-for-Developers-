package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class TaskGUI extends JFrame {

    private JLabel taskIdLabel, taskNameLabel;
    private JTextField taskIdField,taskNameField;
    private JButton createJobButton, addTaskButton;

    public TaskGUI() {
        // set up the frame
        setTitle("Task Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create labels and fields
        taskIdLabel = new JLabel("Task ID:");
        taskNameLabel = new JLabel("Task Name:");

        taskIdField = new JTextField(10);
        taskNameField = new JTextField(10);

        // create buttons
        createJobButton = new JButton("Create Job");
        addTaskButton = new JButton("Add Task");

        // create panel for fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(taskIdLabel);
        inputPanel.add(taskIdField);
        inputPanel.add(taskNameLabel);
        inputPanel.add(taskNameField);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createJobButton);
        buttonPanel.add(addTaskButton);

        // add panels to frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        TaskGUI gui = new TaskGUI();
    }
}
