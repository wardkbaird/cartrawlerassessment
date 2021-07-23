package com.cartrawler.assessment.car.filter;

import com.cartrawler.assessment.car.CarResult;
import com.cartrawler.assessment.view.renderer.filter.Filter;
import java.util.List;

public class RentalCostFilter implements Filter<CarResult> {

    @Override
    public boolean shouldFilter(final CarResult car, final List<CarResult> group) {

        if (car == null || group == null || group.size() == 0) return false;

        final double groupMediumPrice = getMediumPrice(group);
        return Double.compare(car.getRentalCost(), groupMediumPrice) > 0;
    }

    private double getMediumPrice(List<CarResult> group) {
        double medianPrice = 0d;
        if (group.size() % 2 == 0) {
            medianPrice = (group.get(group.size()/2).getRentalCost() + group.get((group.size() / 2) - 1).getRentalCost() )/ 2.0;
        } else {
            medianPrice = group.get(group.size()/2).getRentalCost();
        }

        return medianPrice;
    }
}
