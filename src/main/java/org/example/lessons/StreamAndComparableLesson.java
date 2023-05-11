package org.example.lessons;

import org.example.models.Person;
import org.example.service.PersonService;
import org.example.service.PersonServiceImpl;

import java.util.Arrays;

public class StreamAndComparableLesson {
    public static void main(String[] args) {
//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        }

//        Comparator<Cat> comparatorMoneyCat = {(Cat o1, Cat o2) { return o1.money - o2.money;}

//        Comparator<Cat> comparatorMoneyCat = (Cat cat1, Cat cat2) -> cat1.money - cat2.money;
//        Comparator<Cat> comparatorMoneyCat = (Cat cat1, Cat cat2) -> Integer.compare(cat1.money, cat2.money);

        int[] values = {5, 4, 3, 2, 1};
        Cat[] cats = {new Cat(100, 5), new Cat(150, 4)};
        Integer.compare(5, 4);
        Arrays.sort(cats, (Cat c1, Cat c2) -> Integer.compare(c1.money, c2.money));
//                        int compare(Cat c1, Cat c2) {
//                          return Integer.compare(c1.money, c2.money)
//                        }
        System.out.println(Arrays.toString(cats));

        PersonService personService = new PersonServiceImpl();
        Person persontwo = new Person("Mike", "Smith", "Mike32d@gmail.com",
                1544527831, 3_500_000);
        personService.savePerson(persontwo);

        Person person = new Person("Max", "Smirnov", "max@mail.ru",
                880055555, 2_000_000);
        personService.savePerson(person);
        System.out.println(personService.getMaxMoneyPerson());
        System.out.println(personService.getMinMoneyPerson());
    }
}

class Cat implements Comparable<Cat> {
    int money;
    int age;

    public Cat(int money, int age) {
        this.money = money;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "money=" + money +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return age - o.age;
    }
}
