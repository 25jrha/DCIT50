package model;

public class Task extends AbstractTask {
    private Status status;

    public Task (int taskId, String taskName, String taskDescription, Status status) {
        super(taskId, taskName, taskDescription);
        this.status = status;
    }

    public Task () {
        this.status = Status.NOT_STARTED;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }
}
