package com.cartrawler.assessment.car.filter;

import com.cartrawler.assessment.car.CarResult;
import com.cartrawler.assessment.view.renderer.filter.Filter;
import java.util.List;

public class FuelPolicyFilter {

    public static Filter<CarResult> FULLFULL() {
        return new Filter<CarResult>() {
            @Override
            public boolean shouldFilter(CarResult car, List<CarResult> group) {

                if (car == null) return false;

                return CarResult.FuelPolicy.FULLFULL.equals(car.getFuelPolicy());
            }
        };
    }

}
