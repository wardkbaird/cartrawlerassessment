package com.cartrawler.assessment.view.renderer.filter;

import com.cartrawler.assessment.view.renderer.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RendererFilter {

    public static <T> List<T> filter(List<T> items, Context ctx) {

        List<T> filteredOut = Collections.emptyList();

        if (!ctx.performFilter()) return filteredOut;

        if (ctx.getGroupingComparator() != null) {
            filteredOut = RendererFilter.filter(items, ctx.getGroupingComparator(), ctx.getFilter());
        } else if (ctx.getFilter() != null){
            filteredOut = RendererFilter.filter(items, ctx.getFilter());
        }
        return filteredOut;
    }



    private static <T> List<T> filter(List<T> items, Filter filter) {

        final List<T> filterOut = new ArrayList<>();

        for (final T item : items) {
            if (filter.shouldFilter(item, items)) {
                filterOut.add(item);
            }
        }

        return filterOut;
    }

    private static <T> List<T> filter(List<T> items, Comparator comparator, final Filter filter) {
        final List<T> filterOut = new ArrayList<>();

        for (List<T> group : createGroups(items, comparator)) {
            filterOut.addAll(filter(group, filter));
        }

        return filterOut;
    }

    private static <T> List<List<T>> createGroups(List<T> items, Comparator groupComparator) {

        final List<List<T>> groups = new ArrayList<>();

        List<T> currentGroup = new ArrayList<>();
        T previousItem = null;
        for (final T item : items) {

            boolean isStartOfNewGroup = previousItem != null && groupComparator.compare(previousItem, item) != 0;
            if (isStartOfNewGroup) {
                groups.add(currentGroup);
                currentGroup = new ArrayList<>();
            }

            currentGroup.add(item);
            previousItem = item;
        }
        groups.add(currentGroup);

        return groups;
    }

}
