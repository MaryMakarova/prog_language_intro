// Класс Market, который реализовывает два вышеуказанных интерфейса и хранит в списке список людей в очереди в различных статусах
package market_queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Market implements QueueBehavior, MarketBehavior {
    private List<Actor> queueActors = new ArrayList<>();
    private List<Actor> marketActors = new ArrayList<>();

    @Override
    public void takeInQueue(Actor actor) {
        if (actor.isMakeOrder() && !queueActors.contains(actor)) {
            queueActors.add(actor);
            System.out.println(actor.getName() + " was added to queue");
        }
    }

    @Override
    public void takeOrders() {
        for (Actor actor : marketActors) {
            if (actor.isMakeOrder()) {
                takeInQueue(actor);
                System.out.println(actor.getName() + " made an order");
            }
        }
    }

    @Override
    public void giveOrders() {
        Iterator<Actor> iterator = queueActors.iterator();
        while (iterator.hasNext()) {
            Actor actor = iterator.next();
            if (actor.isTakeOrder()) {
                iterator.remove(); // это безопасное удаление элемента во время итерирования
                actor.setTakeOrder(false);
                actor.setMakeOrder(false);
                System.out.println(actor.getName() + " took the order");
            }
        }
    }

    @Override
    public void releaseFromQueue(Actor actor) {
        if (queueActors.contains(actor) && actor.isTakeOrder()) {
            queueActors.remove(actor);
            actor.setTakeOrder(false); // сброс флага после выдачи заказа
            actor.setMakeOrder(false); // теперь здесь сбрасываем флаг isMakeOrder
            System.out.println(actor.getName() + " was released from queue");
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        marketActors.add(actor);
        System.out.println(actor.getName() + " was accepted to market");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            if (!actor.isMakeOrder() && !actor.isTakeOrder()) {
                marketActors.remove(actor);
                System.out.println(actor.getName() + " was released from market");
            }
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders(); // обработать актеров, которые готовы забрать свои заказы
        System.out.println("There are " + marketActors.size() + " people in the market");
        System.out.println("There are " + queueActors.size() + " people in the queue");
    }
}