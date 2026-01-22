package model;

public abstract class AbstractTask {
    private int taskId;
    private String taskName;
    private String taskDescription;

    public AbstractTask() {
    }

    public AbstractTask (int taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    //abstract getter and setter for the status attribute
    public abstract Status getStatus();

    public abstract void setStatus(Status status);

    //normal getter and setter for the attributes
    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskID(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}

