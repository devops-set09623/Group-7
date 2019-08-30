package com.napier.sem;

import java.util.ArrayList;

/**
 * Purpose of class: Class for a Language Report which inherits from Report
 */
public class Language extends Report {

    private ArrayList<LanguageReportItem> _reportsItems = new ArrayList<>();



    public ArrayList<LanguageReportItem> get_reportsItems() {
        return _reportsItems;
    }

    public void addItemToReport(LanguageReportItem item){
        _reportsItems.add(item);
    }

    /**
     * Method to return string for report format
     * @return string format from LanguageReport
     */
    public static String getReportFormat() {
        return "%-35s  %-20s  %-20s";
    }

    /**
     * Prints Language Report Header
     */
    public static void printReportHeader(){
        System.out.println("\n");
        System.out.printf(Language.getReportFormat(), "Name", "SpeakerPop", "worldpercent");
        System.out.println("\n");
    }

    /**
     * LanguageReportItem class which is a subclass of ReportItem. Used to model a report item
     */
    class LanguageReportItem extends ReportItem {
        private long _SpeakerPop;
        private float _worldPercentage;


        public LanguageReportItem(String name, long speakerPop, float worldPercentage) {
            this.set_name(name);
            this._SpeakerPop=speakerPop;
            this._worldPercentage=worldPercentage;
        }

        public long get_SpeakerPop() {
            return _SpeakerPop;
        }



        public float get_worldPercentage() {
            return _worldPercentage;
        }


    }
}
