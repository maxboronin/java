package geekbrains.animals;

public class Cat extends Animal{
    private static final int runMaxDistance = 200;
    private static final int swimMaxDistance = 0;
    private static final String kind = "кот";

    public Cat(String name) {
        super(name, kind, runMaxDistance, swimMaxDistance);
    }

    @Override
    protected boolean trySwim(int distance) {
        return false;
    }
}
