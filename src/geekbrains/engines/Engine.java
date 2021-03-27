package geekbrains.engines;

import javax.script.ScriptException;

public interface Engine {
    public double process(String expression) throws ScriptException;
}
