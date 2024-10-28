classDiagram
    class Animal {
        <<Abstract>>
        id: INT UNSIGNED
        animals_class: VARCHAR(30)
    }

    class DomesticAnimal {
        <<Abstract>>
    }

    class DraughtAnimal {
        <<Abstract>>
    }

    Animal <|-- DomesticAnimal
    Animal <|-- DraughtAnimal

    class Dog {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    class Cat {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    class Hamster {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    class Horse {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    class Camel {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    class Donkey {
        name: VARCHAR(50)
        skills: VARCHAR(100)
        birth_date: DATE
    }

    DomesticAnimal <|-- Dog
    DomesticAnimal <|-- Cat
    DomesticAnimal <|-- Hamster

    DraughtAnimal <|-- Horse
    DraughtAnimal <|-- Camel
    DraughtAnimal <|-- Donkey