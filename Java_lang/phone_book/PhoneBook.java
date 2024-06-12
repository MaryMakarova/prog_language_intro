package phone_book;

import java.util.*;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

    public void removePhoneNumber(String name, String phoneNumber) {
        if(phoneBook.containsKey(name)) {
            phoneBook.get(name).remove(phoneNumber);
            // Если у этого имени не осталось номеров телефона, удаляем запись из телефонной книги
            if(phoneBook.get(name).isEmpty()) {
                phoneBook.remove(name);
            }
        }
    }

    public void printPhoneBook() {
        // Создаем список для хранения записей
        List<PhoneBookEntry> entries = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            entries.add(new PhoneBookEntry(entry.getKey(), entry.getValue()));
        }

        // Сортируем список по убыванию количества номеров телефонов
        Collections.sort(entries, (e1, e2) -> Integer.compare(e2.getPhoneNumbers().size(), e1.getPhoneNumbers().size()));

        // Выводим отсортированный список
        for (PhoneBookEntry entry : entries) {
            System.out.println(entry.getName() + " - " + entry.getPhoneNumbers());
        }
    }

    // Запись в телефонной книге
    public static class PhoneBookEntry {
        private String name;
        private Set<String> phoneNumbers;

        public PhoneBookEntry(String name, Set<String> phoneNumbers) {
            this.name = name;
            this.phoneNumbers = phoneNumbers;
        }

        public String getName() {
            return name;
        }

        public Set<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        // Переопределение equals и hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneBookEntry that = (PhoneBookEntry) o;
            return Objects.equals(name, that.name) && Objects.equals(phoneNumbers, that.phoneNumbers);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.addEntry("Евгений Александрович Онегин", "+7 911 11 111 11");
        phoneBook.addEntry("Евгений Александрович Онегин", "+7 912 34 567 8");
        phoneBook.addEntry("Татьяна Дмитриевна Ларина", "+7 991 01 11 213 1");
        phoneBook.addEntry("Владимир Вячеславович Ленский", "+7 961 71 819 2");
        phoneBook.addEntry("Петр Яковлевич Чаадаев", "+7 902 12 22 324 2");
        phoneBook.addEntry("Евгений Александрович Онегин", "+7 952 62 728 2");
        phoneBook.addEntry("Петр Яковлевич Чаадаев", "+7 993 03 13 233 3");
        //phoneBook.addEntry("Петр Яковлевич Чаадаев", "+7 993 03 13 233 3");

        // Печатаем телефонную книгу
        phoneBook.printPhoneBook();

        //phoneBook.removeEntry("Евгений Александрович Онегин");
        //phoneBook.removePhoneNumber("Евгений Александрович Онегин", "+7 911 11 111 11");

        //phoneBook.printPhoneBook();
    }
}