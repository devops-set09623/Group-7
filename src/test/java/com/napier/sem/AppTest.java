package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class AppTest
{



    static App app;
    static DatabaseHandler db;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void testPrintReport()
    {
        Country r = new Country();
        Country.CountryReportItem item = new Country().new CountryReportItem();
        r.addItemToReport(item);
        item.set_capital("Yangon");
        item.set_code("MM");
        item.set_continent("Asia");
        item.set_region("South east Asia");
        item.set_name("Myanmar");
        item.set_population(100000);


        app.printReport(r);
    }

    @Test
    void testprintReportHeaderCapitalCity(){
        CapitalCity c = new CapitalCity();
        c.printReportHeader();
    }

    @Test
    void testprintReportHeaderCity(){
        City c = new City();

        c.printReportHeader();
    }

    @Test
    void testprintReportHeaderPopulation(){
        Population p = new Population();
        p.printReportHeader();

    }

    @Test
    void testprintReportHeaderTotalPopulation(){
        TotalPopulation tp = new TotalPopulation();
        tp.printReportHeader();
    }









}