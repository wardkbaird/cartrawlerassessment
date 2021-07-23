package com.cartrawler.assessment.view.renderer.filter;

import java.util.List;

public interface Filter <T> {
    boolean shouldFilter(T item, List<T> group);
}
