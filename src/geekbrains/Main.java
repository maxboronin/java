package geekbrains;

import geekbrains.animals.Animal;
import geekbrains.animals.Cat;
import geekbrains.animals.Crocodail;
import geekbrains.animals.Dog;
import geekbrains.support.Registry;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Cat tomCat = new Cat("Васька");
        Cat superCat = new Cat("Рыська");
        Dog mukhtarDog = new Dog("Мухтар");

//        tomCat.run(50);
//        tomCat.swim(10);
//
//        superCat.run(1000);
//        superCat.swim(100);
//
//        mukhtarDog.run(400);
//        mukhtarDog.run(1000);
//        mukhtarDog.swim(10);
//        mukhtarDog.swim(1000);

        Crocodail croc = new Crocodail();

        croc.eat(superCat);

        Cat newCat = new Cat("Барсик");

        Plate plate = new Plate();
        newCat.devour(plate);

        plate.addFood(150);

        Iterator<Animal> animals= Registry.getAnimals().iterator();

        while (animals.hasNext()){
            animals.next().devour(plate);
        }

        System.out.println("Ждем 6 секунд");

        Thread.sleep(6 * 1000);
        newCat.devour(plate);

        System.out.printf("Насыпали еды. Темерь в миске: %s \n", plate.addFood(150));
        newCat.devour(plate);
    }
}
