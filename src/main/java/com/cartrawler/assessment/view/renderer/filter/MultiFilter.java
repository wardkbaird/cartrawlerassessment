package com.cartrawler.assessment.view.renderer.filter;

import java.util.Arrays;
import java.util.List;

public class MultiFilter<T> implements Filter<T> {

    private final List<Filter> filters;

    public MultiFilter(final List<Filter> filters) {
        this.filters = filters;
    }

    public MultiFilter(final Filter... filter) {
       this(Arrays.asList(filter));
    }

    @Override
    public boolean shouldFilter(final T item, final List<T> group) {
        boolean shouldFilter = false;
        for (final Filter filter : filters) {
            if (filter.shouldFilter(item, group)) {
               shouldFilter = true;
            } else {
                shouldFilter = false;
                break;
            }
        }
        return shouldFilter;
    }
}
