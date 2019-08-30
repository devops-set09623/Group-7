package com.napier.sem;

import java.util.ArrayList;

/**
 * Purpose of class: Class for a Population Report which inherits from Report
 */

public class Population extends Report {

    private ArrayList<PopulationReportItem> _reportsItems = new ArrayList<>(); // Array list to hold report items



    public ArrayList<PopulationReportItem> get_reportsItems() {
        return _reportsItems;
    } // Get method to get array list for report items

    public void addItemToReport(PopulationReportItem item){
        _reportsItems.add(item);
    }

    /**
     * Method to return string for report format
     * @return string format for Population
     */
    public static String getReportFormat() {
        return "%-35s  %-20s  %-20s  %-20s  %-25s  %-25s";
    }

    /**
     * Prints Population Report header
     */

    public static void printReportHeader(){
        System.out.println("\n");
        System.out.printf(Population.getReportFormat(), "Name", "Population", "PopulationInCity", "PopulationNotInCity", "PopInCityPercentage", "PopNotInCityPercentage");
        System.out.println("\n");
    }

    /**
     * PopulationReportItem class which is a subclass of ReportItem. Used to model a report item
     */
    class PopulationReportItem extends ReportItem {
        private long _popNotInCity; //Population Not Living in city
        private long _popInCity; //Population Living in city
        private float _popNotInCityPercentage; //Population Not Living in city percentage
        private float _popInCityPercentage; //Population Living in city percentage


        /**
         * Public constructor which takes in a series of arguments
         * @param name continent, region, country
         * @param population total population
         * @param popNotInCity Population not living in city
         * @param popNotInCityPercentage population not living in city percentage
         * @param popInCity population in city
         * @param popInCityPercentage Population in city percentage
         */
        public PopulationReportItem(String name, long population, long popNotInCity, float popNotInCityPercentage, long popInCity, float popInCityPercentage) {
            this.set_name(name);
            this.set_population(population);
            this._popInCity = popInCity;
            this._popNotInCity = popNotInCity;
            this._popInCityPercentage = popInCityPercentage;
            this._popNotInCityPercentage = popNotInCityPercentage;
        }

        /**
         * method to return Population Not in City
         * @return population not in city
         */

        public long get_popNotInCity() {
            return _popNotInCity;
        }


        /**
         * method to return Population in City
         * @return population in city
         */
        public long get_popInCity() {
            return _popInCity;
        }


        /**
         * method to return Population Not in City percentage
         * @return population not in city percentage
         */
        public double get_popNotInCityPercentage() {
            return _popNotInCityPercentage;
        }


        /**
         * method to return Population in City percentage
         * @return population in city percentage
         */
        public float get_popinCityyPercentage() {
            return _popInCityPercentage;
        }


    }
}
