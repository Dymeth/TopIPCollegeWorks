package me.dymeth.college.java.work3;

public class Task2 {

    static void main() {
        Product product = new Product();
        try {
            product.setPrice(50);
            System.out.println("Цена после смены #1: " + product.getPrice());
        } catch (Exception ex) {
            System.out.println("Не удалось изменить цену: " + ex.getMessage());
        }
        try {
            product.setPrice(-20);
            System.out.println("Цена после смены #2: " + product.getPrice());
        } catch (Exception ex) {
            System.out.println("Не удалось изменить цену: " + ex.getMessage());
        }
    }

    private static class Product {
        private String name;
        private double price;

        public Product() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Цена не может быть отрицательной");
            }
            this.price = price;
        }
    }
}
