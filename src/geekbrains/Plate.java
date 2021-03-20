package geekbrains;

public class Plate {
    private int capacity = 20;
    private int fullness = 0;

    public Plate() {
    }

    public Plate(int capacity) {
        this.capacity = capacity;
    }

    public boolean devour(int need){
        if( need > fullness ){
            return false;
        }
        fullness -= need;
        System.out.printf("В миске осталось: %s \n", fullness);
        return true;
    }

    public int addFood(int add){
        fullness = ((fullness + add) >= capacity) ? capacity : (fullness + add);
        return fullness;
    }

    public boolean enoughFood(int need){
        return need <= fullness;
    }
}
