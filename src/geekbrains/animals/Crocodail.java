package geekbrains.animals;

public class Crocodail extends Animal{
    private static final int runMaxDistance = 10;
    private static final int swimMaxDistance = 500;
    private static final String kind = "крокодил";

    public Crocodail() {
        super("", kind, runMaxDistance, swimMaxDistance);
    }

    public void eat(Animal animal){
        animal.die();
        System.out.printf("Крокодил слопал %s \n", animal);
    }
}
