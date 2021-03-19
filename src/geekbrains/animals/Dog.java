package geekbrains.animals;

public class Dog extends Animal{
    private static final int runMaxDistance = 500;
    private static final int swimMaxDistance = 10;
    private static final String kind = "собака";


    public Dog(String name) {
        super(name, kind, runMaxDistance, swimMaxDistance);
    }
}
