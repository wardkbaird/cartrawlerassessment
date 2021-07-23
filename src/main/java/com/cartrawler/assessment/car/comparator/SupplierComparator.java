package com.cartrawler.assessment.car.comparator;

import com.cartrawler.assessment.car.CarResult;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class SupplierComparator implements Comparator<CarResult> {

    private final Set<String> corporateSuppliers;
    public SupplierComparator(final Set<String> corporateSuppliers) {
        this.corporateSuppliers = corporateSuppliers;
    }

    @Override
    public int compare(CarResult car1, CarResult car2) {

        if (car1 == null && car2 == null) return 0;
        if (car1 == null) return 1;
        if (car2 == null) return -1;

        if (corporateSuppliers.contains(car1.getSupplierName()) != corporateSuppliers.contains(car2.getSupplierName())) {
            return corporateSuppliers.contains(car1.getSupplierName()) ? -1 : 1;
        }
        return 0;
    }
}
