package geekbrains.animals;

public class Dog extends Animal{
    private static final int runMaxDistance = 500;
    private static final int swimMaxDistance = 10;
    private static final String kind = "собака";
    private static final int defaultAppetite = 20;
    private static final int defaultFullTime = 5;


    public Dog(String name, int appetite, int fullTime) {
        super(name, kind, runMaxDistance, swimMaxDistance, appetite, fullTime);
    }

    public Dog(String name) {
        super(name, kind, runMaxDistance, swimMaxDistance, defaultAppetite, defaultFullTime);
    }
}
