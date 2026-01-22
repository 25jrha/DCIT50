package controller;

import model.Status;
import model.Task;
import java.util.ArrayList;

public class TaskManager {

    private final ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public boolean updateTask(int taskId, String name, String desc, Status status) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                task.setTaskName(name);
                task.setTaskDescription(desc);
                task.setStatus(status);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

