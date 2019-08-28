package com.napier.sem;

import java.util.ArrayList;

public class TotalPopulation extends Report {

    private ArrayList<TotalPopulationReportItem> _reportsItems = new ArrayList<>();

    @Override
    ReportType getReportType() {
        return ReportType.TotalPopulationReport;
    }

    public ArrayList<TotalPopulationReportItem> get_reportsItems() {
        return _reportsItems;
    }
    public static String getReportFormat() {
        return "%-25s  %-20s";
    }

    public void addItemToReport(TotalPopulationReportItem item){
        _reportsItems.add(item);
    }
    public static void printReportHeader(){
        System.out.println("\n");
        System.out.printf(TotalPopulation.getReportFormat(), "Name", "Population");
        System.out.println("\n");
    }


    class TotalPopulationReportItem extends ReportItem {

        public TotalPopulationReportItem(String name, long population) {
            this.set_name(name);
            this.set_population(population);
        }
    }
}
