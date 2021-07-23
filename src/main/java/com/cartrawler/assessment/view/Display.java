package com.cartrawler.assessment.view;

import com.cartrawler.assessment.view.renderer.Context;
import com.cartrawler.assessment.view.renderer.filter.RendererFilter;
import com.cartrawler.assessment.view.renderer.sort.RendererSort;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Display {

    private final Context ctx;

    public Display(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * Will first Sort & Filter the data, then print to console.
     *
     * Style of sorting & filtering is controlled by the class's ctx object.
     *
     * @param set dataset
     * @param <T> underlying type of the dataset
     * @return A Sorted & Filtered List of the dataset.
     */
    public <T> List<T> render(final Set<T> set) {
        final List<T> items = new ArrayList<>(set);
        return render(items);
    }

    /**
     * Will first Sort & Filter the data, then print to console.
     *
     * Style of sorting & filtering is controlled by the class's ctx object.
     *
     * @param items dataset
     * @param <T> underlying type of the dataset
     * @return A Sorted & Filtered List of the dataset.
     */
    public <T> List<T> render(final List<T> items) {

        RendererSort.sort(items, ctx);

        if (ctx.performFilter()) {
            final List<T> filteredItems = RendererFilter.filter(items, ctx);
            items.removeAll(filteredItems);
        }

        print(items);

        return items;
    }

    private <T> void print(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

}
