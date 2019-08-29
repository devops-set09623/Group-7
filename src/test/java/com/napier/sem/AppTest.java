package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testget_popNotInCity(){

        Population.PopulationReportItem item =  new Population().new PopulationReportItem("Myanmar",122222, 3333333,34.834999084472656f,3344444,65.165f );

        assertEquals(3333333,item.get_popNotInCity());
        assertEquals(3344444,item.get_popInCity());
        assertEquals(34.834999084472656f,item.get_popNotInCityPercentage());
        assertEquals(65.165f,item.get_popinCityyPercentage());


    }






}