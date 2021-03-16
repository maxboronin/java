package geekbrains;

public class Employee {
    private String fullName;
    private String position;
    private int age;
    private String email;
    private String phone;
    private int salary;

    public Employee(String fullName, String position, int age, String email, String phone, int salary) {
        super();
        this.fullName = fullName;
        this.position = position;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary='$" + salary + '\'' +
                '}';
    }

}
