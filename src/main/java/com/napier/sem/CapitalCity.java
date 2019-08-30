package com.napier.sem;

import java.util.ArrayList;

/**
 * Purpose of class: Class for a CapitalCity Report which inherits from Report
 */
public class CapitalCity extends Report {


    private ArrayList<CapitalCityReportItem> _reportsItems = new ArrayList<>(); // Array list to hold report items

    /**
     * @return report format
     */
    public static String getReportFormat() {
        return "%-40s  %-30.25s  %-30s";
    }


    /**
     * print report header
     */
    public static void printReportHeader() {
        System.out.println("\n");
        System.out.printf(CapitalCity.getReportFormat(), "NAME", "POPULATION", "COUNTRY");
        System.out.println("\n");
    }


    /**
     * Adds items to array list
     * @param item capital city report item
     */
    public void addItemToReport(CapitalCityReportItem item){
        _reportsItems.add(item);
    }

    public ArrayList<CapitalCityReportItem> get_reportsItems() {
        return _reportsItems;
    }


    /**
     * Purpose of class: Class for a Capital City Report Item which inherits from Report Item
     */
    class CapitalCityReportItem extends ReportItem {
        private String _Country; //Country name

        /**
         * a public constructor which takes a series of arguments
         * @param name city name
         * @param Country country name
         * @param Population population number
         */
        public CapitalCityReportItem(String name, String Country, int Population) {
            this.set_name(name);
            this._Country = Country;
            this.set_population(Population);
        }

        /**
         * method to return country name
         * @return country name
         */
        public String get_Country() {
            return _Country;
        }


    }
}
