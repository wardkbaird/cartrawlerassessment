package com.cartrawler.assessment.view.renderer.sort;

import com.cartrawler.assessment.view.renderer.Context;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RendererSort {

    public static <T> void sort(List<T> items, Context ctx) {
        if (ctx.getSortComparator() != null) {
            RendererSort.sort(items, ctx.getSortComparator());
        }
    }

    private static <T> void sort(List<T> items, Comparator comparator) {
        Collections.sort(items, comparator);
    }
}
