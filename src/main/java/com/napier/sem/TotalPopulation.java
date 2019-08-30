package com.napier.sem;

import java.util.ArrayList;

/**
 * Purpose of class: Class for a Total population Report which inherits from Report
 */
public class TotalPopulation extends Report {

    private ArrayList<TotalPopulationReportItem> _reportsItems = new ArrayList<>();



    public ArrayList<TotalPopulationReportItem> get_reportsItems() {
        return _reportsItems;
    } // Get method to get array list for report items

    /**
     * Method to return string for report format
     * @return string format for Population
     */
    public static String getReportFormat() {
        return "%-25s  %-20s";
    }


    public void addItemToReport(TotalPopulationReportItem item){
        _reportsItems.add(item);
    }

    /**
     * print report header
     */
    public static void printReportHeader(){
        System.out.println("\n");
        System.out.printf(TotalPopulation.getReportFormat(), "Name", "Population");
        System.out.println("\n");
    }

    /**
     * TotalPopulationReportItem class which is a subclass of ReportItem. Used to model a report item
     */
    class TotalPopulationReportItem extends ReportItem {

        public TotalPopulationReportItem(String name, long population) {
            this.set_name(name);
            this.set_population(population);
        }
    }
}
