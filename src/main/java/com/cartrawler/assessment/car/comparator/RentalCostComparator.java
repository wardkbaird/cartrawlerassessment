package com.cartrawler.assessment.car.comparator;

import com.cartrawler.assessment.car.CarResult;
import java.util.Comparator;

public class RentalCostComparator implements Comparator<CarResult> {

    @Override
    public int compare(final CarResult car1, final CarResult car2) {

        if (car1 == null && car2 == null) return 0;
        if (car1 == null) return 1;
        if (car2 == null) return -1;

        return Double.compare(car1.getRentalCost(), car2.getRentalCost());
    }
}
