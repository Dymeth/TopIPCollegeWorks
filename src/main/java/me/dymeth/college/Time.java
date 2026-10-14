package me.dymeth.college;

/**
 * 2.Класс Time с полями hours, minutes, seconds и конструкторами:
 * Time(int hours, int minutes, int seconds)
 * Time(int totalSeconds): например, Time(3725) → 1 ч 2 мин 5 с
 * Time(): 00:00:00
 * Условия:
 * Основной конструктор нормализует значения: new Time(0, 75, 90) → 1:16:30.
 * Time(int totalSeconds) обязан вызывать основной через this(0, 0, totalSeconds), без дублирования расчётов.
 * Методы: totalSeconds() и Time plus(Time other), который возвращает новый объект.
 */
public record Time(int hours, int minutes, int seconds) {

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int SECONDS_IN_HOUR = 3600;

    public Time(int hours, int minutes, int seconds) {
        long total = (long) hours * SECONDS_IN_HOUR + (long) minutes * SECONDS_IN_MINUTE + seconds;

        if (total < 0) throw new IllegalArgumentException("Время не может быть отрицательным. Дано " + total + " сек");
        if (total / SECONDS_IN_HOUR > Integer.MAX_VALUE) throw new IllegalArgumentException("Слишком большое значение времени");

        this.hours = (int) (total / SECONDS_IN_HOUR);
        this.minutes = (int) (total % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
        this.seconds = (int) (total % SECONDS_IN_MINUTE);
    }

    public Time(int totalSeconds) {
        this(0, 0, totalSeconds);
    }

    public Time() {
        this(0, 0, 0);
    }

    public int totalSeconds() {
        return this.hours * SECONDS_IN_HOUR + this.minutes * SECONDS_IN_MINUTE + this.seconds;
    }

    public Time plus(Time other) {
        if (other == null) throw new IllegalArgumentException("other не может быть null");
        return new Time(0, 0, Math.addExact(totalSeconds(), other.totalSeconds()));
    }
}
