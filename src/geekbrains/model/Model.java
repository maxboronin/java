package geekbrains.model;

public class Model {
    private static Model instance;
    private String expression = "";

    private Model(){}

    public static Model getInstance(){
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
