package geekbrains;

import geekbrains.animals.Cat;
import geekbrains.animals.Crocodail;
import geekbrains.animals.Dog;

public class Main {

    public static void main(String[] args) {
        Cat tomCat = new Cat("Васька");
        Cat superCat = new Cat("Рыська");
        Dog mukhtarDog = new Dog("Мухтар");

        tomCat.run(50);
        tomCat.swim(10);

        superCat.run(1000);
        superCat.swim(100);

        mukhtarDog.run(400);
        mukhtarDog.run(1000);
        mukhtarDog.swim(10);
        mukhtarDog.swim(1000);

        Crocodail croc = new Crocodail();

        croc.eat(superCat);

        Cat newCat = new Cat("Барсик");
    }
}
