package singleResponsibility;

public class SingleResponsibilityGoodPractice {

    static class Task {
        private String name;
    }

    static class Employee {

        private String name;
        private String role;

        // Methods for managing employee data
        public void saveEmployee(Employee employee) {
            // Save employee data to database
        }

        public void updateEmployee(Employee employee) {
            // Update employee data in database
        }

        public void deleteEmployee(Employee employee) {
            // Delete employee data from database
        }
    }

    static class TaskManager {

        // Methods for managing employee tasks
        public void assignTask(Employee employee, Task task) {
            // Assign task to employee
        }

        public void completeTask(Employee employee, Task task) {
            // Mark task as completed by employee
        }

        public void cancelTask(Employee employee, Task task) {
            // Cancel task assigned to employee
        }
    }

}
