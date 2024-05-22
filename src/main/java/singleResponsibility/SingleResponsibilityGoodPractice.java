package singleResponsibility;

public class SingleResponsibilityGoodPractice {

    static class Task {
        private String name;
    }

    static class Employee {
        private String name;
        private String role;

        public void saveEmployee(SingleResponsibilityBadPractice.Employee employee) {
            System.out.println("Saving employee data to database");
        }

        public void updateEmployee(SingleResponsibilityBadPractice.Employee employee) {
            System.out.println("Updating employee data in database");
        }

        public void deleteEmployee(SingleResponsibilityBadPractice.Employee employee) {
            System.out.println("Deleting employee data from database");
        }
    }

    static class TaskManager {
        public void assignTask(Task task) {
            System.out.println("Assigning task to employee");
        }

        public void completeTask(Task task) {
            System.out.println("Completing task assinged to employee");
        }

        public void cancelTask(Task task) {
            System.out.println("Cancelling task assigned to employee");
        }
    }

}
