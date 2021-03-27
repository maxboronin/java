package geekbrains.engines;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NachorntEngine implements Engine {
    public static final String title = "Script Engine";

    @Override
    public double process(String expression) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        Object result = scriptEngine.eval(expression);
        return Double.valueOf(result.toString());
    }

    @Override
    public String toString() {
        return title;
    }
}
