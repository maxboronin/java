package geekbrains.animals;

import geekbrains.support.Registry;

public abstract class Animal {
    private String name;
    private String kind;
    private int runMaxDistance;
    private int swimMaxDistance;
    private boolean canRun;
    private boolean canSwim;

    public Animal(String name, String kind, int runMaxDistance, int swimMaxDistance) {
        this.name = name;
        this.kind = kind;
        this.runMaxDistance = runMaxDistance;
        this.swimMaxDistance = swimMaxDistance;

        canRun = runMaxDistance > 0;
        canSwim = swimMaxDistance > 0;

        Registry.register(this);
        System.out.printf("Создан(-а) %s %s. Всего животных %s, из них вида '%s' - %s \n", kind, name, Registry.getCounter(), kind, Registry.getKindCounter(kind));
    }

    protected boolean tryRun(int distance){
        return distance <= runMaxDistance;
    }

    protected boolean trySwim(int distance){
        return distance <= swimMaxDistance;
    }

    public void run(int distance){
        if(!canRun){
            System.out.printf("%s %s не умеет бегать \n", kind, name);
            return;
        }

        if(tryRun(distance)){
            System.out.printf("%s %s пробежал %s м \n", kind, name, distance);
        }else{
            System.out.printf("%s не может %sм пробежать, потому что это %s \n", name, distance, kind);
        }
    }

    public void swim(int distance){
        if(!canSwim){
            System.out.printf("%s %s не умеет плавать  \n", kind, name);
            return;
        }
        if(trySwim(distance)){
            System.out.printf("%s %s проплыл %s м \n", kind, name, distance);
        }else{
            System.out.printf("%s не может %sм проплыть, потому что это %s  \n", name, distance, kind);
        }
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public void die(){
        Registry.unregister(this);
        System.out.printf("Мы потеряли %s %s. Всего животных %s, из них вида '%s' - %s \n", kind, name, Registry.getCounter(), kind, Registry.getKindCounter(kind));
    }

    @Override
    public String toString(){
        return kind + " " + name;
    }
}
