package geekbrains.engines;

public class SimpleEngine implements Engine{
    public static final String title = "Простой калькулятор";

    @Override
    public double process(String expression) {
        double result = 0;

        StringBuilder value = new StringBuilder();
        String operation = "+";
        String nextOperation;
        StringBuilder lastValue = new StringBuilder();

        for (int i = 0; i < expression.length(); i++){
            char token = expression.charAt(i);
            if(token != '+' && token != '-' && token != '*' && token != '/') {
                value.append(token);
            }else{
                nextOperation = String.valueOf(token);
                result = operation(result, operation, value);
                operation = nextOperation;
                value = new StringBuilder();
            }
            lastValue = value;
        }

        return operation(result, operation, lastValue);
    }

    private double operation(Double result, String operation, StringBuilder value){
        switch (operation){
            case "+":
                result += Double.valueOf(value.toString());
                break;
            case "-":
                result -= Double.valueOf(value.toString());
                break;
            case "*":
                result *= Double.valueOf(value.toString());
                break;
            case "/":
                result /= Double.valueOf(value.toString());
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return title;
    }

}
