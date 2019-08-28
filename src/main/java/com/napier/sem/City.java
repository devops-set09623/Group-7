package com.napier.sem;


import java.util.ArrayList;

/**
 * Purpose of class: Class for a City Report which inherits from Report
 */
public class City extends Report {

    /**
     * Returns an array list if City Reports
     */
    private ArrayList<CityReportItem> _reportsItems = new ArrayList<>(); // Array list to hold report items

    public ArrayList<CityReportItem> get_reportsItems() {
        return _reportsItems;
    }

    /**
     * Adds items to array list
     * @param item city report item
     */
    public void addItemToReport(City.CityReportItem item) {
        _reportsItems.add(item);
    } // method to add item to report



    /**
     * @return report format
     */
    public static String getReportFormat() {
        return "%-30.25s  %-30.25s  %-30s  %-30s";
    }

    /**
     * Prints City Report header
     */
    public static void printReportHeader() {
        System.out.println("\n");
        System.out.printf(City.getReportFormat(), "NAME", "COUNTRY", "DISTRICT", "POPULATION");
        System.out.println("\n");
    }

    /**
     * Purpose of class: Class for a City Report Item which inherits from Report Item
     */
    class CityReportItem extends ReportItem {

        private String _district;
        private String _country;

        /**
         * Constructor for report item
         * @param name name of city
         * @param country name of country
         * @param district district name
         * @param population city population
         */
        public CityReportItem(String name, String country, String district, int population) {
            this.set_name(name);
            this._country = country;
            this._district = district;
            this.set_population(population);
        }

        public String get_district() {
            return _district;
        }



        public String get_country() {
            return _country;
        }


    }
}
