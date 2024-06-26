// Необходимо реализовать Интерфейс ActorBehavoir, который будет содержать описание возможных действий актора в очереди/магазине.
package market_queue;

public interface ActorBehavoir {
    void setMakeOrder(boolean flag);
    void setTakeOrder(boolean flag);
    boolean isMakeOrder();
    boolean isTakeOrder();
}
