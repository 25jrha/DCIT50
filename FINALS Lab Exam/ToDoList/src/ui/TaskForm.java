package ui;

import controller.TaskManager;
import model.Task;
import model.Status;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TaskForm extends JFrame {

    private final JTextField idField;
    private final JTextField nameField;
    private final JTextArea descArea;
    private final JComboBox<String> statusCombo;

    private final TaskManager taskManager;
    private final MainApplicationWindow parentView;

    public TaskForm(MainApplicationWindow parentView, TaskManager taskManager) {
        this.parentView = parentView;
        this.taskManager = taskManager;

        setTitle("Add Task");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(parentView);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("Task ID:");
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        formPanel.add(idLabel, gbc);

        idField = new JTextField(String.valueOf(generateTaskId()));
        idField.setEditable(false);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        formPanel.add(idField, gbc);

        JLabel nameLabel = new JLabel("Task Name:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        formPanel.add(nameField, gbc);

        JLabel descLabel = new JLabel("Task Description:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        formPanel.add(descLabel, gbc);

        descArea = new JTextArea(4, 20);
        JScrollPane descScroll = new JScrollPane(descArea);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        formPanel.add(descScroll, gbc);

        JLabel statusLabel = new JLabel("Status:");
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        formPanel.add(statusLabel, gbc);

        statusCombo = new JComboBox<>(new String[]{"NOT STARTED", "ONGOING", "DONE"});
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.7;
        formPanel.add(statusCombo, gbc);

        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save Task");
        saveButton.addActionListener(e -> saveTask());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private int generateTaskId() {
        List<Task> tasks = taskManager.getTasks();
        if (tasks.isEmpty()) return 1;
        return tasks.getLast().getTaskId() + 1;
    }

    private void saveTask() {
        String name = nameField.getText().trim();
        String desc = descArea.getText().trim();
        String statusStr = (String) statusCombo.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Task Name is required", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = Integer.parseInt(idField.getText());
        assert statusStr != null;
        Status statusEnum = Status.valueOf(statusStr.replace(" ", "_"));
        Task task = new Task(id, name, desc, statusEnum);

        taskManager.addTask(task);
        parentView.refreshTable();

        dispose();
    }
}


