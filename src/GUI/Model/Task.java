package GUI.Model;

public class Task {
    private int taskID;
    private String taskName;

    public Task(int taskId, String taskName) {
        this.taskID = taskID;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskID;
    }

    public void setTaskId(int taskId) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}