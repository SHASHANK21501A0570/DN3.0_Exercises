public class EmployeeManagementSystemExample {

    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getEmployeeId() { return employeeId; }
        public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getPosition() { return position; }
        public void setPosition(String position) { this.position = position; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }

        @Override
        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
        }
    }

    public static class EmployeeManagementSystem {
        private Employee[] employees;
        private int size;
        private static final int INITIAL_CAPACITY = 10;

        public EmployeeManagementSystem() {
            this.employees = new Employee[INITIAL_CAPACITY];
            this.size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size == employees.length) {
                resize();
            }
            employees[size++] = employee;
        }

        public Employee searchEmployee(String employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    return employees[i];
                }
            }
            return null;
        }

        public void traverseEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        public void deleteEmployee(String employeeId) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId().equals(employeeId)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < size - 1; i++) {
                    employees[i] = employees[i + 1];
                }
                employees[size - 1] = null;
                size--;
            }
        }

        private void resize() {
            int newCapacity = employees.length * 2;
            Employee[] newArray = new Employee[newCapacity];
            System.arraycopy(employees, 0, newArray, 0, size);
            employees = newArray;
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new Employee("E001", "John Doe", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Jane Smith", "Developer", 65000));
        ems.addEmployee(new Employee("E003", "Emily Davis", "Analyst", 55000));

        System.out.println("Employee List:");
        ems.traverseEmployees();

        System.out.println("\nSearching for employee with ID E002:");
        Employee employee = ems.searchEmployee("E002");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID E003.");
        ems.deleteEmployee("E003");

        System.out.println("\nUpdated Employee List:");
        ems.traverseEmployees();
    }
}
