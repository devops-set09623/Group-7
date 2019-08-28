package com.napier.sem;

import java.util.ArrayList;

public class CapitalCity extends Report {

    private ArrayList<CapitalCityReportItem> _reportsItems = new ArrayList<>();

    public static String getReportFormat() {
        return "%-40s  %-30.25s  %-30s";
    }


    public static void printReportHeader() {
        System.out.println("\n");
        System.out.printf(CapitalCity.getReportFormat(), "NAME", "POPULATION", "COUNTRY");
        System.out.println("\n");
    }

    @Override
    ReportType getReportType() {
        return ReportType.CapitalCityReport;
    }

    public void addItemToReport(CapitalCityReportItem item){
        _reportsItems.add(item);
    }

    public ArrayList<CapitalCityReportItem> get_reportsItems() {
        return _reportsItems;
    }

    class CapitalCityReportItem extends ReportItem {
        private String _Country;

        public CapitalCityReportItem(String name, String Country, int Population) {
            this.set_name(name);
            this._Country = Country;
            this.set_population(Population);
        }

        public String get_Country() {
            return _Country;
        }

        public void set_Country(String _Country) {
            this._Country = _Country;
        }
    }
}
