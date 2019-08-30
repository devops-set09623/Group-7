package com.napier.sem;

import java.util.ArrayList;

public class Population extends Report {

    private ArrayList<PopulationReportItem> _reportsItems = new ArrayList<>();



    public ArrayList<PopulationReportItem> get_reportsItems() {
        return _reportsItems;
    }

    public void addItemToReport(PopulationReportItem item){
        _reportsItems.add(item);
    }
    public static String getReportFormat() {
        return "%-35s  %-20s  %-20s  %-20s  %-25s  %-25s";
    }

    public static void printReportHeader(){
        System.out.println("\n");
        System.out.printf(Population.getReportFormat(), "Name", "Population", "PopulationInCity", "PopulationNotInCity", "PopInCityPercentage", "PopNotInCityPercentage");
        System.out.println("\n");
    }


    class PopulationReportItem extends ReportItem {
        private long _popNotInCity;
        private long _popInCity;
        private float _popNotInCityPercentage;
        private float _popInCityPercentage;

        public PopulationReportItem(String name, long population, long popNotInCity, float popNotInCityPercentage, long popInCity, float popInCityPercentage) {
            this.set_name(name);
            this.set_population(population);
            this._popInCity = popInCity;
            this._popNotInCity = popNotInCity;
            this._popInCityPercentage = popInCityPercentage;
            this._popNotInCityPercentage = popNotInCityPercentage;
        }

        public long get_popNotInCity() {
            return _popNotInCity;
        }



        public long get_popInCity() {
            return _popInCity;
        }



        public double get_popNotInCityPercentage() {
            return _popNotInCityPercentage;
        }



        public float get_popinCityyPercentage() {
            return _popInCityPercentage;
        }


    }
}
