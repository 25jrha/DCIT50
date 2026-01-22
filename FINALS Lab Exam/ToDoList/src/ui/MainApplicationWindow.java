package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class MainApplicationWindow extends JFrame {

    private final TaskManager taskManager;
    private final DefaultTableModel tableModel;
    private final JTable taskTable;
    private TaskForm taskForm;

    public MainApplicationWindow(TaskManager taskManager) {
        this.taskManager = taskManager;

        setTitle("To-Do List");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);

        ImageIcon logo = new ImageIcon((Objects.requireNonNull(MainApplicationWindow.class.getResource("/ui/bedridden_chibi_kakashi.png"))));
        setIconImage(logo.getImage());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addTask = new JButton("Add Task");
        addTask.setFont(new Font("Segue UI", Font.BOLD, 13));
        addTask.setFocusPainted(false);
        addTask.setFocusable(false);
        addTask.addActionListener(e -> openTaskForm());
        top.add(addTask);
        add(top, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(
                new String[]{"Task ID", "Task Name", "Task Description", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        taskTable = new JTable(tableModel);
        taskTable.getTableHeader().setReorderingAllowed(false);
        taskTable.setRowHeight(30);
        taskTable.setShowGrid(true);
        taskTable.setIntercellSpacing(new Dimension(0, 0));

        taskTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        taskTable.getColumnModel().getColumn(1).setPreferredWidth(225);
        taskTable.getColumnModel().getColumn(2).setPreferredWidth(350);
        taskTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        taskTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        add(new JScrollPane(taskTable), BorderLayout.CENTER);

        refreshTable();
        setVisible(true);
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Task t : taskManager.getTasks()) {
            Object[] row = {t.getTaskId(), t.getTaskName(), t.getTaskDescription(), t.getStatus()};
            tableModel.addRow(row);
        }
    }

    private void openTaskForm() {
        if (taskForm == null || !taskForm.isDisplayable()) {
            taskForm = new TaskForm(this, taskManager);
        } else {
            taskForm.toFront();
            taskForm.requestFocus();
        }
    }
}

