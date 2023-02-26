package GUI;
import javax.swing.*;
import java.awt.*;

public class JobTaskGUI extends JFrame {

    private JLabel jobIdLabel, profitLabel, numTaskLabel, jobNameLabel, endTimeLabel;
    private JTextField jobIdField, profitField, numTaskField, jobNameField, endTimeField;
    private JButton createJobButton, addTaskButton;

    public JobTaskGUI() {
        // set up the frame
        setTitle("Job Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create labels and fields
        jobIdLabel = new JLabel("Job ID:");
        profitLabel = new JLabel("Profit:");
        numTaskLabel = new JLabel("Number of Tasks:");
        jobNameLabel = new JLabel("Job Name:");
        endTimeLabel = new JLabel("End Time:");

        jobIdField = new JTextField(10);
        profitField = new JTextField(10);
        numTaskField = new JTextField(10);
        jobNameField = new JTextField(10);
        endTimeField = new JTextField(10);

        // create buttons
        createJobButton = new JButton("Create Job");
        addTaskButton = new JButton("Add Task");

        // create panel for fields and labels
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(jobIdLabel);
        inputPanel.add(jobIdField);
        inputPanel.add(profitLabel);
        inputPanel.add(profitField);
        inputPanel.add(numTaskLabel);
        inputPanel.add(numTaskField);
        inputPanel.add(jobNameLabel);
        inputPanel.add(jobNameField);
        inputPanel.add(endTimeLabel);
        inputPanel.add(endTimeField);

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
        JobTaskGUI gui = new JobTaskGUI();
    }
}

