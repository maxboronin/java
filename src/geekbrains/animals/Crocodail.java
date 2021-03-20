package geekbrains.animals;

import geekbrains.Plate;

public class Crocodail extends Animal{
    private static final int runMaxDistance = 10;
    private static final int swimMaxDistance = 500;
    private static final String kind = "крокодил";
    private static final int defaultAppetite = 100;
    private static final int defaultFullTime = 20;

    public Crocodail(int appetite, int fullTime) {
        super("", kind, runMaxDistance, swimMaxDistance, appetite, fullTime);
    }

    public Crocodail() {
        super("", kind, runMaxDistance, swimMaxDistance, defaultAppetite, defaultFullTime);
    }

    public void eat(Animal animal){
        animal.die();
        makeFull();
        System.out.printf("Крокодил слопал %s \n", animal);
    }

    @Override
    public void devour(Plate plate) {
        System.out.println("Крокодилы не едят из мисок");
    }
}
