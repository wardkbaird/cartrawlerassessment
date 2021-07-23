package com.cartrawler.assessment.car.comparator;

import com.cartrawler.assessment.car.CarResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SIPPCodeComparator implements Comparator<CarResult> {

    private final char[] sippCodeOrder;

    public SIPPCodeComparator(final char[] sippCodeOrder) {
        this.sippCodeOrder = sippCodeOrder;
    }


    @Override
    public int compare(final CarResult car1, final CarResult car2) {

        if (car1 == null && car2 == null) return 0;
        if (car1.getSippCode() == null && car2.getSippCode() == null) return 0;
        if (car1 == null || car1.getSippCode() == null) return 1;
        if (car2 == null || car2.getSippCode() == null) return -1;

        final char car1SIPPCode = car1.getSippCode().charAt(0);
        final char car2SIPPCode = car2.getSippCode().charAt(0);
        if (car1SIPPCode != car2SIPPCode) {
            for (int i = 0; i < sippCodeOrder.length; i++) {
                if (car1SIPPCode == sippCodeOrder[i] || car2SIPPCode == sippCodeOrder[i]) {
                    return car1SIPPCode == sippCodeOrder[i] ? -1 : 1;
                }
            }
        }
        return 0;
    }
}

