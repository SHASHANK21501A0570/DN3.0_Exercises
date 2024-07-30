public class TaskManagerExample {

    public static class Task {
        private String taskId;
        private String taskName;
        private String status;

        public Task(String taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public String getTaskId() { return taskId; }
        public void setTaskId(String taskId) { this.taskId = taskId; }
        public String getTaskName() { return taskName; }
        public void setTaskName(String taskName) { this.taskName = taskName; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    public static class TaskManager {
        private class Node {
            Task task;
            Node next;
            Node(Task task) {
                this.task = task;
                this.next = null;
            }
        }

        private Node head;

        public TaskManager() {
            this.head = null;
        }

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public Task searchTask(String taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId().equals(taskId)) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public void deleteTask(String taskId) {
            if (head == null) return;
            if (head.task.getTaskId().equals(taskId)) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask(new Task("T001", "Task One", "In Progress"));
        tm.addTask(new Task("T002", "Task Two", "Completed"));
        tm.addTask(new Task("T003", "Task Three", "Not Started"));

        System.out.println("Task List:");
        tm.traverseTasks();

        System.out.println("\nSearching for task with ID T002:");
        Task task = tm.searchTask("T002");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID T003.");
        tm.deleteTask("T003");

        System.out.println("\nUpdated Task List:");
        tm.traverseTasks();
    }
}
