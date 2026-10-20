package me.dymeth.college.java.work3;

public class Task1 {

    static void main() {
        Person person = new Person("Макс", 12);
        System.out.println("До изменения. Имя: " + person.getName() + "; возраст: " + person.getAge());
        person.setAge(23);
        person.setName("Максим");
        System.out.println("После изменения. Имя: " + person.getName() + "; возраст: " + person.getAge());
    }

    private static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.setName(name);
            this.setAge(age);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
        }
    }
}
