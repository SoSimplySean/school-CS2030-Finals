// Modify your solution within this file only.

import java.util.List;
import java.util.ArrayList;

class ImList<T> {
    private final List<T> list;
    private final List<Function<ImList<T>, ImList<T>> stack;

    ImList() {
        this.list = new ArrayList<T>();
        this.stack = new ArrayList<T>();
    }

    private ImList(List<? extends T> list) {
        this.list = new ArrayList<T>(list);
        this.stack = new ArrayList<T>();
    }

    ImList<T> add(T t) {
        Function<ImList<T>, ImList<T>> temp = this -> {
            System.out.println("Adding: " + t);
            ImList<T> newList = new ImList<T>(this.list);
            newList.list.add(t);
            return newList;
        };
        ImList<T> newList = ImList<T>(this.list);
        newList.stack.add(temp);
        return newList;
    }

    ImList<T> set(int index, T t) {
        Function<ImList<T>, ImList<T>> temp = this -> {
            System.out.println("Setting: " + index + ", " + t);
            ImList<T> newList = new ImList<T>(this.list);
            newList.list.set(index, t);
            return newList;
        };
        ImList<T> newList = ImList<T>(this.list);
        newList.stack.add(temp);
        return newList;
    }

    T get(int index) {
        ImList<T> updated = this.stack.stream().map(x -> x.apply(this.list)).collect(Collectors.toList);
        return updated.list.get(index);
    }

    @Override
    public String toString() {
        return "ImList";
    }
}
