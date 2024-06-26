// Необходимо реализовать абстрактный класс Actor, который хранит в себе параметры актора, включая состояние готовности сделать заказ и факт получения заказа.
// Дополнение: для большего понимания, можно сделать методы-геттеры для имени и прочих 
package market_queue;

public abstract class Actor {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public void setMakeOrder(boolean b) {
        this.isMakeOrder = true;
    }

    public void setTakeOrder(boolean b) {
        this.isTakeOrder = true;
    }

    public boolean isMakeOrder() {
        return this.isMakeOrder;
    }

    public boolean isTakeOrder() {
        return this.isTakeOrder;
    }

    public abstract String getName();
}

