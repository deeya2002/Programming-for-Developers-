package GUI.Views;



import GUI.Controller.UserController;
import GUI.Model.Job;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateJobScreen extends JFrame implements ActionListener {
    private JLabel jobNameLabel;
    private JTextField jobNameField;
    private JButton createButton;
    private JButton backButton;

    public CreateJobScreen() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        getContentPane().setBackground(new Color(230, 230, 250));
        Font font = new Font("Times New Roman", Font.BOLD, 12);

        jobNameLabel = new JLabel("Job Name:");
        jobNameLabel.setFont(font);
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(jobNameLabel, constraints);

        jobNameField = new JTextField(20);
        jobNameField.setFont(font);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(jobNameField, constraints);

        createButton = new JButton("Create");
        createButton.setFont(font);
        createButton.setForeground(new Color(255, 255, 255));
        createButton.setBackground(new Color(245, 195, 171));
        createButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(createButton, constraints);

        backButton = new JButton("Go back");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBackground(new Color(245, 195, 171));
        backButton.setFont(font);
        backButton.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(backButton, constraints);

        setTitle("Create Job Screen");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == createButton) {
            String jobName = jobNameField.getText().trim();
            if (jobName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter the job name.");
            } else {
                Job job = new Job(jobName);
                UserController jobController = new UserController();
                int result = jobController.jobCustomerPreparedStatement(job);
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Job created.");
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Error occured.");
                }
            }
        } else if (event.getSource() == backButton) {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            this.dispose();
        }
    }
}
