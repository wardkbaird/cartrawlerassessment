package com.cartrawler.assessment.view;

import com.cartrawler.assessment.car.CarResult;
import com.cartrawler.assessment.car.comparator.RentalCostComparator;
import com.cartrawler.assessment.car.comparator.SIPPCodeComparator;
import com.cartrawler.assessment.car.comparator.SupplierComparator;
import com.cartrawler.assessment.car.filter.FuelPolicyFilter;
import com.cartrawler.assessment.car.filter.RentalCostFilter;
import com.cartrawler.assessment.view.renderer.Context;
import com.cartrawler.assessment.view.renderer.filter.MultiFilter;
import com.cartrawler.assessment.view.renderer.sort.MultiComparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayTest {

    public final Set<CarResult> TESTDATA;
    {
        TESTDATA = new HashSet<>();
        TESTDATA.add(new CarResult("Volkswagen Polo", "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Ford C-Max Diesel", "NIZA", "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Renault Scenic Diesel", "NIZA", "JGAD", 93.67d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Volkswagen Up", "NIZA", "MDMR", 9.78d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Volkswagen Golf", "NIZA", "CDMR", 18.07d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Audi A3 Diesel", "NIZA", "CDMD", 41.16d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Volkswagen Touran Diesel", "NIZA", "IVMD", 55.47d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Citroen Berlingo", "CENTAURO", "CMMV", 33.15d, CarResult.FuelPolicy.FULLEMPTY));
        TESTDATA.add(new CarResult("Ford Galaxy", "SIXT", "FVMR", 692.45d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("BMW 3 Series", "SIXT", "FDMR", 225.18d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("BMW 3 Series", "SIXT", "FDAR", 295.22d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Renault Scenic", "SIXT", "JGMR", 245.09d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Toyota Avensis", "AVIS", "IDMR", 373.69d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Opel Astra", "AVIS", "CCMR", 203.32d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Volkswagen Touran Diesel", "AVIS", "IVAD", 520.49d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Mercedes E Class", "AVIS", "PDAR", 948.24d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Mercedes E Class", "AVIS", "PDAR", 790.36d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Volkswagen Touran Diesel", "AVIS", "IVMD", 495.74d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Skoda Octavia Diesel", "AVIS", "IDMD", 310.22d, CarResult.FuelPolicy.FULLFULL));
        TESTDATA.add(new CarResult("Ford Focus Estate", "AVIS", "CWMR", 291.28d, CarResult.FuelPolicy.FULLFULL));
    }

    public final Set<CarResult> BADTESTDATA;
    {
        BADTESTDATA = new HashSet<>();
        BADTESTDATA.add(new CarResult(null, "NIZA", "EDMR", 12.81d, CarResult.FuelPolicy.FULLEMPTY));
        BADTESTDATA.add(new CarResult("Ford C-Max Diesel", null, "CMMD", 22.04d, CarResult.FuelPolicy.FULLEMPTY));
        BADTESTDATA.add(new CarResult("Renault Scenic Diesel", "NIZA", null, 93.67d, CarResult.FuelPolicy.FULLEMPTY));
        BADTESTDATA.add(new CarResult("Volkswagen Up", "NIZA", "MDMR", -5, CarResult.FuelPolicy.FULLEMPTY));
        BADTESTDATA.add(new CarResult("Volkswagen Golf", "NIZA", "CDMR", 18.07d, null));
        BADTESTDATA.add(new CarResult("Mercedes E Class", "AVIS", "PDAR", 948.24d, CarResult.FuelPolicy.FULLFULL));
        BADTESTDATA.add(new CarResult("Mercedes E Class", "AVIS", "PDAR", 790.36d, CarResult.FuelPolicy.FULLFULL));
        BADTESTDATA.add(new CarResult("Volkswagen Touran Diesel", "AVIS", "IVMD", 495.74d, CarResult.FuelPolicy.FULLFULL));
    }


    Set<String> CORPORATESUPPLIERS = new HashSet<>();
    {
        CORPORATESUPPLIERS.add("AVIS");
        CORPORATESUPPLIERS.add("BUDGET");
        CORPORATESUPPLIERS.add("ENTERPRISE");
        CORPORATESUPPLIERS.add("FIREFLY");
        CORPORATESUPPLIERS.add("HERTZ");
        CORPORATESUPPLIERS.add("SIXT");
        CORPORATESUPPLIERS.add("THRIFTY");
    }

    private final static char[] SIPPCODEORDER = new char[] {'M', 'E', 'C'};

    private Display display;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void render() {

        final Context ctx = new Context(
                new MultiComparator(new SupplierComparator(CORPORATESUPPLIERS), new SIPPCodeComparator(SIPPCODEORDER), new RentalCostComparator()),
                new MultiComparator(new SupplierComparator(CORPORATESUPPLIERS), new SIPPCodeComparator(SIPPCODEORDER)),
                new MultiFilter(FuelPolicyFilter.FULLFULL(), new RentalCostFilter()),
                true
        );

        display = new Display(ctx);
        Display display = this.display;


        List<CarResult> result = display.render(TESTDATA);

        Assertions.assertEquals(19, TESTDATA.size(), "Pre processing");
        Assertions.assertEquals(14, result.size(), "Expected 14 results after sorting & filtering input.");
        Assertions.assertTrue(CORPORATESUPPLIERS.contains(result.get(0).getSupplierName()), "Got: " + result.get(0).getSupplierName());
        Assertions.assertFalse(CORPORATESUPPLIERS.contains(result.get(result.size()-1).getSupplierName()), "Got: " + result.get(result.size()-1).getSupplierName());
    }

    @Test
    void render_badData() {
        final Context ctx = new Context(
                new MultiComparator(new SupplierComparator(CORPORATESUPPLIERS), new SIPPCodeComparator(SIPPCODEORDER), new RentalCostComparator()),
                new MultiComparator(new SupplierComparator(CORPORATESUPPLIERS), new SIPPCodeComparator(SIPPCODEORDER)),
                new MultiFilter(FuelPolicyFilter.FULLFULL(), new RentalCostFilter()),
                true
        );

        display = new Display(ctx);

        List<CarResult> result = display.render(BADTESTDATA);

        Assertions.assertEquals(7, BADTESTDATA.size(), "Pre processing");
        Assertions.assertEquals(6, result.size(), "Expected 14 results after sorting & filtering input.");
        Assertions.assertTrue(CORPORATESUPPLIERS.contains(result.get(0).getSupplierName()), "Got: " + result.get(0).getSupplierName());
    }

    @Test
    void render_badCtx() {
        final Context ctx = new Context(
                null,
                null,
                null,
                true
        );

        display = new Display(ctx);

        List<CarResult> result = display.render(TESTDATA);

        Assertions.assertEquals(19, TESTDATA.size(), "Pre processing");
        Assertions.assertEquals(19, result.size(), "Expected 14 results after sorting & filtering input.");
    }
}