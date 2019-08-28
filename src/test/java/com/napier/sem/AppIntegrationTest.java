package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppIntegrationTest {

    static App app;
    static DatabaseHandler db;

    @BeforeAll
    static void init()
    {
        app = new App();
        db = DatabaseHandler.Instance();
        db.connect("localhost:33060");
    }



    @Test
    void testReportOne(){
        Country r = (Country) db.getReportOne();
        int size =r.get_reportsItems().size();
        assertTrue(size >0);

    }

    @Test
    void testReportTwo(){
        Country r = (Country) db.getReportTwo("Africa");
        Country.CountryReportItem i = r.get_reportsItems().get(0);
        assertEquals(111506000, i.get_population());
    }

    @Test
    void testReportThree(){
        Country r = (Country) db.getReportThree("South America");

        Country.CountryReportItem i = r.get_reportsItems().get(0);
        assertEquals("Brazil", i.get_name());
    }

    @Test
    void testReportFour(){
        Country r = (Country) db.getReportFour(6);
        Country.CountryReportItem item = r.get_reportsItems().get(3);

        assertEquals("Jakarta", item.get_capital());
    }

    @Test
    void testReportFive(){
        Country r = (Country) db.getReportFive("Europe", 30);
        assertEquals(30, r.get_reportsItems().size());
    }


    @Test
    void testReportSix(){
        Country r = (Country) db.getReportSix("Eastern Asia", 2);
        Country.CountryReportItem item = r.get_reportsItems().get(1);
        assertEquals("Tokyo", item.get_capital());
    }

    @Test
    void testReportSeven() {
        City r = (City) db.getReportSeven();
        City.CityReportItem item = r.get_reportsItems().get(0);
        assertEquals(10500000, item.get_population());
    }

    @Test
    void testReportEight(){
        City r = (City) db.getReportEight("Asia");
        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals(10500000, i.get_population());
    }

    @Test
    void testReportNine(){
        City r = (City) db.getReportNine("Eastern Asia");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals("Seoul", i.get_district());
    }

    @Test
    void testReportTen(){
        City r = (City) db.getReportTen("Myanmar");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals(3361700, i.get_population());
    }

    @Test
    void testReportEleven(){
        City r = (City) db.getReportEleven("Mandalay");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals(885300, i.get_population());
    }

    @Test
    void testReportTwelve()
    {
        City r = (City) db.getReportTwelve(3);

        City.CityReportItem i = r.get_reportsItems().get(1);
        assertEquals("Seoul", i.get_name());
    }

    @Test
    void testReportThirteen()
    {
        City r = (City) db.getReportThirteen(5, "Asia");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals("Mumbai (Bombay)", i.get_name());
    }

    @Test
    void testReportFourteen()
    {
        City r = (City) db.getReportFourteen(5, "Eastern Asia");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals("Seoul", i.get_name());
    }

    @Test
    void testReportFifteen()
    {
        City r = (City) db.getReportFifteen(5, "Myanmar");

        City.CityReportItem i = r.get_reportsItems().get(1);
        assertEquals("Mandalay", i.get_name());
    }

    @Test
    void testReportSixteen()
    {
        City r = (City) db.getReportSixteen(3, "Mandalay");

        City.CityReportItem i = r.get_reportsItems().get(0);
        assertEquals("Myanmar", i.get_country());
    }

    @Test
    void testReportSeventeen()
    {
        CapitalCity r = (CapitalCity) db.getReportSeventeen();

        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(2);
        assertEquals("Mexico", i.get_Country());
    }

    @Test
    void testReportEighteen()
    {
        CapitalCity r = (CapitalCity) db.getReportEighteen("Asia");
        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(2);
        assertEquals("Japan", i.get_Country());
    }

    @Test
    void testReportNineteen()
    {
        CapitalCity r = (CapitalCity) db.getReportNineteen("Eastern Asia");
        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(2);
        assertEquals("China", i.get_Country());
    }

    @Test
    void testReportTwenty()
    {
        CapitalCity r = (CapitalCity) db.getReportTwenty(115);

        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(114);
        assertEquals("Macao", i.get_Country());
    }

    @Test
    void testReportTwentyOne()
    {
        CapitalCity r = (CapitalCity) db.getReportTwentyOne("Europe", 10);

        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(9);
        assertEquals("Belarus", i.get_Country());
    }

    @Test
    void testReportTwentyTwo()
    {
        CapitalCity r = (CapitalCity) db.getReportTwentyTwo("Eastern Asia", 5);

        CapitalCity.CapitalCityReportItem i = r.get_reportsItems().get(0);
        assertEquals("South Korea", i.get_Country());
    }

    @Test
    void testReportTwentyThree()
    {
        Population r = (Population) db.getReportTwentyThree();

        Population.PopulationReportItem i = r.get_reportsItems().get(0);
        assertEquals("North America", i.get_name());
    }

    @Test
    void testReportTwentyFour()
    {
        Population r = (Population) db.getReportTwentyFour();

        Population.PopulationReportItem i = r.get_reportsItems().get(0);
        assertEquals("Caribbean", i.get_name());
    }


}
