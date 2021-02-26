package geekbrains;

public class Main {

    public static void main(String[] args) {
        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte byteVar = 127;
        short shortVar = 1;
        int intVar = 1;
        long longVar = 1000;
        float floatVar = 1.5F;
        double doubleVar = 1.5;
        char charvar = 'M';
        String helloString = "Hi, everyone";

        System.out.println("3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат");
        float calcABCDResult = calcABCD(1F, 2.5F, 5F, 4F);
        System.out.println("calcABCDResult: " + calcABCDResult);

        System.out.println("4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.");
        boolean checkDiapasonResult = checkDiapason(5, 100);
        System.out.println("checkDiapasonResult: " + checkDiapasonResult);
        System.out.println("checkDiapasonResult: " + checkDiapason(10, 2));

        System.out.println("5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом");
        printCheckIsPositive(5);
        printCheckIsPositive(0);
        printCheckIsPositive(-10);

        System.out.println("6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.");
        boolean checkNegativePlusFiveResult = checkNegative(5);
        boolean checkNegativeMinusFiveResult = checkNegative(-5);
        boolean checkNegativeZeroResult = checkNegative(0);
        System.out.println("5: " + checkNegativePlusFiveResult);
        System.out.println("-5: " + checkNegativeMinusFiveResult);
        System.out.println("0: " + checkNegativeZeroResult);

        System.out.println("7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».");
        printGreetingInConsole("Muzzi");

        System.out.println("8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
        System.out.println("1: " + checkIsLepYear( 1 ));
        System.out.println("99: " + checkIsLepYear( 99 ));
        System.out.println("100: " + checkIsLepYear( 100 ));
        System.out.println("101: " + checkIsLepYear( 101 ));
        System.out.println("399: " + checkIsLepYear( 399 ));
        System.out.println("400: " + checkIsLepYear( 400 ));
        System.out.println("2000: " + checkIsLepYear( 2000 ));
        System.out.println("2020: " + checkIsLepYear( 2020 ));
        System.out.println("2021: " + checkIsLepYear( 2021 ));
        System.out.println("2022: " + checkIsLepYear( 2022 ));
        System.out.println("2023: " + checkIsLepYear( 2023 ));
        System.out.println("2024: " + checkIsLepYear( 2024 ));
        System.out.println("2025: " + checkIsLepYear( 2025 ));
        System.out.println("2100: " + checkIsLepYear( 2100 ));
        System.out.println("2400: " + checkIsLepYear( 2400 ));
    }

    //3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат
    private static float calcABCD(float a, float b, float c, float d) {
        return a * ( b + ( c / d ) );
    }

    //4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    private static boolean checkDiapason(int firstVal, int secondVal){
        int sum = firstVal + secondVal;
        return (sum >=10 && sum <=20);
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    private static void printCheckIsPositive(int valueForCheck){
        String resultString;
        if( valueForCheck < 0 ){
            resultString = "отрицательное";
        } else {
            resultString = "положительное";
        }
        System.out.println(valueForCheck + " - " + resultString + " число");
    }

    //6. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    private static boolean checkNegative(int valueForCheck){
        if(valueForCheck < 0){
            return true;
        } else {
            return false;
        }
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    private static void printGreetingInConsole(String personName){
        System.out.println("Привет, " + personName + "!");
    }

    //8. * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static boolean checkIsLepYear(int year){
        if( year % 100 == 0 && year % 400 == 0 ){
            return true;
        }else if(year % 4 == 0 && year % 100 == 0){
            return false;
        }else if(year % 4 == 0){
            return true;
        }else {
            return false;
        }
    }
}
