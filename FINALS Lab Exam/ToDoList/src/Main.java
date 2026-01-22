import controller.TaskManager;
import ui.MainApplicationWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TaskManager taskManager = new TaskManager();
            MainApplicationWindow window = new MainApplicationWindow(taskManager);
            window.setVisible(true);
        });
    }
}