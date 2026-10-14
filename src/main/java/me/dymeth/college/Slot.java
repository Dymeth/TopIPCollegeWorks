package me.dymeth.college;

import java.util.Objects;

/**
 * 3. Класс Slot с полями itemName, count, maxStack ий конструкторами:
 * Slot(String itemName, int count, int maxStack): основной
 * Slot(String itemName, int count): лимит стака 64
 * Slot(String itemName): одна штука, лимит 64
 * Slot(): пустой слот
 * Slot(Slot other): копия
 * Условия:
 * Вся логика только в основном конструкторе, остальные идут через this(...).
 * Нормализация в основном конструкторе:
 * maxStack < 1 → 1
 * count < 0 → 0
 * count > maxStack → maxStack
 * если itemName равен null или пустой, либо count == 0, слот считается пустым: имя "", количество 0
 * Метод isEmpty().
 * Метод int add(int n) добавляет предметы в слот и возвращает остаток, который не влез. Например, в слоте 60/64, add(10) → в слоте 64, вернул 6.
 * Метод int moveTo(Slot other) переносит предметы в другой слот и возвращает, сколько реально перенесено. Переносить можно, если other пустой или в нём тот же предмет. Если предметы разные, ничего не переносится, результат 0. Если other пустой, он «перенимает» имя предмета.
 */
public class Slot {
    private static final int DEFAULT_MAX_STACK_SIZE = 64;

    private String itemName;
    private int count;
    private final int maxStack;

    public Slot(String itemName, int count, int maxStack) {
        maxStack = Math.max(1, maxStack);
        count = Math.max(0, Math.min(count, maxStack));

        if (itemName == null || itemName.isEmpty() || count == 0) {
            itemName = "";
            count = 0;
        }

        this.itemName = itemName;
        this.count = count;
        this.maxStack = maxStack;
    }

    public Slot(String itemName, int count) {
        this(itemName, count, DEFAULT_MAX_STACK_SIZE);
    }

    public Slot(String itemName) {
        this(itemName, 1);
    }

    public Slot() {
        this(null, 0);
    }

    public Slot(Slot other) {
        this(Objects.requireNonNull(other, "other не может быть null").itemName,
                other.count,
                other.maxStack
        );
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int add(int n) {
        if (n < 0)  throw new IllegalArgumentException("n не может быть отрицательным: " + n);
        if (isEmpty()) return n;

        int accepted = Math.min(n, this.maxStack - this.count);
        this.count += accepted;
        return n - accepted;
    }

    public int moveTo(Slot other) {
        if (other == null || other == this || isEmpty()) return 0;

        if (!other.isEmpty() && !other.itemName.equals(this.itemName)) return 0;

        int moved = Math.min(this.count, other.maxStack - other.count);
        if (moved == 0) return 0;

        if (other.isEmpty()) {
            other.itemName = this.itemName;
        }

        other.count += moved;
        this.count -= moved;

        if (this.count == 0) {
            this.itemName = "";
        }

        return moved;
    }
}
