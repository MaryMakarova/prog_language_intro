package solid.code_for_refactoring;

// Класс User нарушает принцип единственной ответственности (Single Responsibility),
// т.к. отвечает и за хранение и за сохранение. В исправленном варианте за сохранение
// отвечает класс Persister.
//
// Класс User нарушает принцип открытости закрытости (Open-Closed),
// т.к. если мы захотим изменить механизм сохранения, то придется менять этот класс.
// Класс User  нариушает принцип инверсии зависимостей (Dependency Inversion),
// т.к. напряму зависит от класса Persister.
// 
// Чтобы соблюдать принцип посдстановки Лисков (Liskov Substitution Principle) и разделения интерфейсов (Interface Segregation),
// добавлен интерфейс DataPersister,
// вместо конкретного класса Persister.


public class User{
    private final String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void save(){
        Persister persister = new Persister(this);
        persister.save();
    }

    public void report(){
        System.out.println("Report for user: " + name);
    }
}
