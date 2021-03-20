package geekbrains.animals;

public class Cat extends Animal{
    private static final int runMaxDistance = 200;
    private static final int swimMaxDistance = 0;
    private static final String kind = "кот";
    private static final int defaultAppetite = 10;
    private static final int defaultFullTime = 5;

    public Cat(String name, int appetite, int fullTime) {
        super(name, kind, runMaxDistance, swimMaxDistance, appetite, fullTime);
    }

    public Cat(String name) {
        super(name, kind, runMaxDistance, swimMaxDistance, defaultAppetite, defaultFullTime);
    }

    @Override
    protected boolean trySwim(int distance) {
        return false;
    }
}
