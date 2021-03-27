package geekbrains;

public class App {
    public App() {
        EngineFactory.getInstance().setEngine(EngineFactory.engineType.SIMPLE);
        View view = View.getInstance();
        view.setVisible(true);
    }
}
