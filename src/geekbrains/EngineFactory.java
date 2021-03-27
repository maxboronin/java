package geekbrains;

import geekbrains.engines.Engine;
import geekbrains.engines.NachorntEngine;
import geekbrains.engines.RecurciveDescentEngine;
import geekbrains.engines.SimpleEngine;

public class EngineFactory {
    private static EngineFactory instance;
    private Engine engine;

    private EngineFactory(){}

    public static EngineFactory getInstance() {
        if(instance == null){
            instance = new EngineFactory();
        }
        return instance;
    }

    public Engine getEngine(){
        return engine;
    }

    public void setEngine(engineType type){
        switch (type){
            case SCRIPT:
                engine = new NachorntEngine();
                break;
            case SIMPLE:
                engine = new SimpleEngine();
                break;
            case RECURSIVE:
                engine = new RecurciveDescentEngine();
                break;
            default:
                engine = new SimpleEngine();
        }
    }

    public enum engineType {
        SIMPLE,
        SCRIPT,
        RECURSIVE
    }
}
