package geekbrains.cntr;

import geekbrains.EngineFactory;
import geekbrains.View;
import geekbrains.engines.Engine;
import geekbrains.model.Model;
import sun.security.util.ArrayUtil;

import javax.script.ScriptException;
import java.util.Arrays;

public class CalcCntr {
    private static CalcCntr instance;

    private CalcCntr(){}

    public static CalcCntr getInstance(){
        if(instance == null){
            instance = new CalcCntr();
        }
        return instance;
    }

    public void process() throws ScriptException {
        double result = EngineFactory.getInstance().getEngine().process(Model.getInstance().getExpression());
        Model.getInstance().setExpression(String.valueOf(result));
        View.getInstance().showExpression();
    }

    public void processSqrt() throws ScriptException {
        double result = EngineFactory.getInstance().getEngine().process(Model.getInstance().getExpression());
        double sqrt;

        if(result > 0){
            sqrt = Math.sqrt(result);
        }else{
            sqrt = 0;
        }
        Model.getInstance().setExpression(String.valueOf(sqrt));
        View.getInstance().showExpression();
    }

    public void appendExpression(char token){
        StringBuilder sb = new StringBuilder(Model.getInstance().getExpression());
        sb.append(token);
        Model.getInstance().setExpression(sb.toString());
    }

    public void clearExpression() {
        Model.getInstance().setExpression("");
    }

}
