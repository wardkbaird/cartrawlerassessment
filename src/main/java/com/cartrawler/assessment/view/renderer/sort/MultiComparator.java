package com.cartrawler.assessment.view.renderer.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MultiComparator<T> implements Comparator<T> {

    private final List<Comparator<T>> comparators;

    public MultiComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    public MultiComparator(final Comparator<T>... c) {
        this(Arrays.asList(c));
    }

    @Override
    public int compare(final T o1, final T o2) {
        for (Comparator<T> c : comparators) {
            final int result = c.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
