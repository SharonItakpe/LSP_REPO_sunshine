package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Sharon Itakpe
 */

public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        ArrayList<Integer> list1 = new ArrayList<>(set);
        ArrayList<Integer> list2 = new ArrayList<>(b.set);

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        result.set.addAll(this.set);

        for (int val : intSetb.set) {
            if (!result.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : this.set) {
            if (!intSetb.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int val : intSetb.set) {
            if (!this.set.contains(val)) {
                result.set.add(val);
            }
        }

        return result;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}