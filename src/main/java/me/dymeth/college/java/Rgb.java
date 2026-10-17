package me.dymeth.college.java;

/**
 * 1.Класс Rgb с полями r, g, b (0–255) и тремя конструкторами:
 * Rgb(int r, int g, int b): основной
 * Rgb(int gray): серый оттенок
 * Rgb(): чёрный цвет
 * Условия:
 * Значения вне диапазона не ломают программу, а обрезаются: 300 → 255, -5 → 0. Эта логика живёт только в основном конструкторе.
 * Остальные конструкторы вызывают его через this(...).
 * Метод isGray(): true, если r == g == b.
 */
public record Rgb(int r, int g, int b) {
    public Rgb(int r, int g, int b) {
        this.r = Math.max(0, Math.min(r, 255));
        this.g = Math.max(0, Math.min(g, 255));
        this.b = Math.max(0, Math.min(b, 255));
    }

    public Rgb(int gray) {
        this(gray, gray, gray);
    }

    public Rgb() {
        this(0, 0, 0);
    }

    public boolean isGray() {
        return this.r == this.g && this.g == this.b;
    }
}
