package com.cartrawler.assessment.car;

import java.util.Locale;
import java.util.Objects;

public class CarResult {
    private final String description;
    private final String supplierName;
    private final String sippCode;
    private final double rentalCost;
    private final FuelPolicy fuelPolicy;

    public enum FuelPolicy {
        FULLFULL,
        FULLEMPTY};

    public CarResult(String description, String supplierName, String sipp, double cost, FuelPolicy fuelPolicy) {
        this.description = description;
        this.supplierName = supplierName != null ? supplierName.toUpperCase(Locale.ROOT) : null;
        this.sippCode = sipp != null ? sipp.toUpperCase(Locale.ROOT) : null;
        this.rentalCost = cost;
        this.fuelPolicy = fuelPolicy;
    }
    
    public String getDescription() {
        return this.description;        
    }
    
    public String getSupplierName() {
        return this.supplierName;        
    }
    
    public String getSippCode() {
        return this.sippCode;        
    }
    
    public double getRentalCost() {
        return this.rentalCost;        
    }
    
    public FuelPolicy getFuelPolicy() {
        return this.fuelPolicy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResult carResult = (CarResult) o;
        return Objects.equals(description, carResult.description)
                && Objects.equals(supplierName, carResult.supplierName)
                && Objects.equals(sippCode, carResult.sippCode)
                && fuelPolicy == carResult.fuelPolicy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, supplierName, sippCode, fuelPolicy);
    }

    private final static String display = "%15s : %-35s : %4s : %9.2f : %-10s";
    @Override
    public String toString() {
        return String.format(display, supplierName, description, sippCode, rentalCost, fuelPolicy);
    }
}
