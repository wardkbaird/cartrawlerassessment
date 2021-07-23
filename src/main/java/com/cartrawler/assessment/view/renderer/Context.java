package com.cartrawler.assessment.view.renderer;

import com.cartrawler.assessment.view.renderer.filter.Filter;
import java.util.Comparator;

public class Context {

    private final Comparator sortComparator;

    private final Comparator groupingComparator;

    private final Filter filter;

    private final boolean performFilter;

    public Context(final Comparator sortComparator, final Comparator groupingComparator, final Filter filter, final boolean performFilter) {
        this.sortComparator = sortComparator;
        this.groupingComparator = groupingComparator;
        this.filter = filter;
        this.performFilter = performFilter;
    }

    public Comparator getSortComparator() {
        return sortComparator;
    }

    public Comparator getGroupingComparator() {
        return groupingComparator;
    }

    public Filter getFilter() {
        return filter;
    }

    public boolean performFilter() {
        return performFilter;
    }

}
