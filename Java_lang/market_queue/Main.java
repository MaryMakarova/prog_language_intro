package market_queue;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        // Создаем актеров
        Actor onegin = new Human("Евгений Александрович Онегин");
        Actor larina = new Human("Татьяна Дмитриевна Ларина");
        Actor lensky = new Human("Владимир Вячеславович Ленский");
        Actor chaadaev = new Human("Петр Яковлевич Чаадаев");

        // В магазин заходит группа людей
        market.acceptToMarket(onegin);
        market.acceptToMarket(larina);
        market.acceptToMarket(lensky);
        market.acceptToMarket(chaadaev);
        market.update();


        onegin.setMakeOrder(true);
        market.update();

        // Ларина делает заказ
        larina.setMakeOrder(true);
        market.update();

        // Чаадаев выходит из магазина
        market.releaseFromMarket(List.of(chaadaev));
        market.update();

        // Онегин получает заказ и уходит из магазина
        onegin.setTakeOrder(true);
        market.update();
        market.releaseFromMarket(List.of(onegin));
        market.update();

        // Ларина получает заказ
        larina.setTakeOrder(true);
        market.update();

        // Ларина и Ленский уходят из магазина
        market.releaseFromMarket(List.of(larina, lensky));
        market.update();
    }
}

