package geekbrains;

public class Main {

    public static void main(String[] args) {
        Employee[] fivePersons = new Employee[] {
                new Employee("Tomcat", "Technoking of Tesla", 40, "elon.musk@mail.ru","+7(911)322-22-33",100000),
                new Employee("JBoss", "CEO", 20, "jboss@mail.ru","+7(921)322-22-33",2000),
                new Employee("Apache", "Courier", 30, "apache@mail.ru","+7(931)444-55-66",3000),
                new Employee("Nginx", "Team lead", 50, "nginx@mail.ru","+7(812)444-22-33",40000),
                new Employee("Ubuntu", "Manager", 41, "ubuntu@mail.ru","+7(499)122-22-33",55555),
        };

        for (Employee employee: fivePersons) {
            if(employee.getAge() > 40){
                System.out.println(employee);
            }
        }
    }
}
