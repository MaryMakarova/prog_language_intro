// Необходимо реализовать класс Human, который должен наследоваться от Actor и реализовывать ActorBehavoir
package market_queue;

public class Human extends Actor implements ActorBehavoir{
    public Human(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setMakeOrder(boolean flag) {
        this.isMakeOrder = flag;
    }

    @Override
    public void setTakeOrder(boolean flag) {
        this.isTakeOrder = flag;
    }
    
}
