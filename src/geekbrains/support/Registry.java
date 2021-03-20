package geekbrains.support;

import geekbrains.animals.Animal;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Registry {
    private static ArrayList<Animal> animalsList = new ArrayList<>();

    public static void register(Animal animal){
        if(animalsList.indexOf(animal) < 0) {
            animalsList.add(animal);
        }
    }

    public static void unregister(Animal animal){
        animalsList.remove(animal);
    }

    public static int getCounter(){
        return animalsList.size();
    }

    public static int getKindCounter(String kind){
        return animalsList.stream().filter(animal -> animal.getKind() == kind).collect(Collectors.toList()).size();
    }

    public static ArrayList<Animal> getAnimals(){
        return animalsList;
    }
}
