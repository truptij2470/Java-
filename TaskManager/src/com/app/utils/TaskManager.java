package com.app.utils;

import com.app.exception.TaskNotFoundException;
import com.app.pojos.Status;
import com.app.pojos.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String taskName, String description, LocalDate taskDate) {
        tasks.add(new Task(taskName, description, taskDate));
    }

    public void deleteTask(int taskId) throws TaskNotFoundException {
        Task task = findTaskById(taskId);
        if (task != null) {
            task.setActive(false);
            System.out.println("Task deleted successfully.");
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
    }

    public void updateTaskStatus(int taskId, Status status) throws TaskNotFoundException {
        Task task = findTaskById(taskId);
        if (task != null) {
            (task).setStatus(status);
            System.out.println("Task status updated successfully.");
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
    }

    public List<Task> getAllPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isActive() && task.getStatus() == Status.PENDING) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    public List<Task> getPendingTasksForToday() {
        List<Task> pendingTasksForToday = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Task task : tasks) {
            if (task.isActive() && task.getTaskDate().isEqual(today) && task.getStatus() == Status.PENDING) {
                pendingTasksForToday.add(task);
            }
        }
        return pendingTasksForToday;
    }

    public List<Task> getAllTasksSortedByDate() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort((t1, t2) -> t1.getTaskDate().compareTo(t2.getTaskDate()));
        return sortedTasks;
    }

    private Task findTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.isActive() && task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }
}
