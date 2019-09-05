package com.napier.sem;


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Declaring public class for App
 */
public class App
{

    private static DatabaseHandler db = DatabaseHandler.Instance(); // Instance of database
    private static App app;

    /**
     * Main method
     *
     * @param args args passed into main
     */
    public static void main(String[] args) {
        boolean loop = true;

        // Connect to database
        app = new App();

        // Connect to database
        if (args.length < 1) {
            db.connect("localhost:3306");
        } else {
            db.connect(args[0]);
        }

        app.printMenu();


        // Loop until user enters 0 to exit
        while (loop) {
            int choice = app.getUserChoice();
            if (choice == 0) {
                loop = false;
            } else {
                app.callReport(choice);
            }
        }

        // Disconnect from database
        db.disconnect();

    }

    /**
     * Get input from user
     */
    private int getUserChoice() {

        try {
            System.out.println("\nEnter report number: "); // Prompt user for input
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (NoSuchElementException ex) {
            System.out.println("No input or incorrect input captured");
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    /**
     *Declaring private class callReport
     */
    private void callReport(int num) {

        Scanner sc = new Scanner(System.in);
        Report report;

        switch (num) {

            case 1:
                System.out.println("All the countries in the world organised by largest population to smallest");
                report = db.getReportOne();
                app.printReport(report);
                break;

            case 2:
                System.out.println("All the countries in a continent organised by largest population to smallest");
                System.out.println("Enter continent");
                report=db.getReportTwo(sc.nextLine());
                app.printReport(report);
                break;

            case 3:
                System.out.println("All the countries in a region organised by largest population to smallest");
                System.out.println("Enter region");
                report=db.getReportThree(sc.nextLine());
                app.printReport(report);
                System.out.flush();
                break;

            case 4:
                System.out.println("The top N populated countries in the world");
                System.out.println("Enter number");
                report = db.getReportFour(sc.nextInt());
                app.printReport(report);
                break;

            case 5:
                System.out.println("The top N populated continent in the world");
                System.out.println("Enter continent");
                String Continent = sc.nextLine();
                System.out.println("Enter number");
                int number2 = sc.nextInt();
                report = db.getReportFive(Continent, number2);
                app.printReport(report);
                break;

            case 6:
                System.out.println("The top N populated countries in a region");
                System.out.println("Enter region");
                String region = sc.nextLine();
                System.out.println("Enter number");
                int number = sc.nextInt();
                report = db.getReportSix(region, number);
                app.printReport(report);
                break;

            case 7:
                System.out.println("All the cities in the world organised by largest population to smallest");
                report = db.getReportSeven();
                app.printReport(report);
                break;


            case 8:
                System.out.println("All the cities in a continent organised by largest population to smallest");
                System.out.println("Enter Continent");
                report = db.getReportEight(sc.nextLine());
                app.printReport(report);
                break;


            case 9:
                System.out.println("All the cities in a region organised by largest population to smallest");
                System.out.println("Enter Region");
                report = db.getReportNine(sc.nextLine());
                app.printReport(report);
                break;

            case 10:
                System.out.println("All the cities in a country organised by largest population to smallest");
                System.out.println("Enter Country");
                report = db.getReportTen(sc.nextLine());
                app.printReport(report);
                break;

            case 11:
                System.out.println("All the cities in a district organised by largest population to smallest.");
                System.out.println("Enter District");
                report = db.getReportEleven(sc.nextLine());
                app.printReport(report);
                break;

            case 12:
                System.out.println("The top N populated cities in the world");
                System.out.println("Enter Number: ");
                report = db.getReportTwelve(sc.nextInt());
                app.printReport(report);
                break;

            case 13:
                System.out.println("The top N populated cities in a continent");
                System.out.println("Enter continent: ");
                String continent = sc.nextLine();
                System.out.println("Enter number: ");
                int n = sc.nextInt();
                report = db.getReportThirteen(n, continent);
                app.printReport(report);
                break;

            case 14:
                System.out.println("The top N populated cities in a region");
                System.out.println("Enter region: ");
                String reg = sc.nextLine();
                System.out.println("Enter number: ");
                int numb = sc.nextInt();
                report = db.getReportFourteen(numb, reg);
                app.printReport(report);
                break;

            case 15:
                System.out.println("The top N populated cities in a country");
                System.out.println("Enter country: ");
                String con = sc.nextLine();
                System.out.println("Enter number: ");
                int nu = sc.nextInt();
                report = db.getReportFifteen(nu, con);
                app.printReport(report);
                break;

            case 16:
                System.out.println("The top N populated cities in a district");
                System.out.println("Enter district: ");
                String dist = sc.nextLine();
                System.out.println("Enter number: ");
                int numbs = sc.nextInt();
                report = db.getReportSixteen(numbs, dist);
                app.printReport(report);
                break;

            case 17:

                report = db.getReportSeventeen();
                app.printReport(report);
                break;


            case 18:
                System.out.println("Enter continent: ");
                String continen = sc.nextLine();
                report = db.getReportEighteen(continen);
                app.printReport(report);
                break;

            case 19:
                System.out.println("Enter region: ");
                String regio = sc.nextLine();
                report = db.getReportNineteen(regio);
                app.printReport(report);
                break;

            case 20:
                System.out.println("Enter no: ");
                int re = sc.nextInt();
                report = db.getReportTwenty(re);
                app.printReport(report);
                break;

            case 21:
                System.out.println("Enter Continent: ");
                String cont = sc.nextLine();
                System.out.println("Enter number: ");
                numb = sc.nextInt();
                report = db.getReportTwentyOne(cont, numb);
                app.printReport(report);
                break;

            case 22:
                System.out.println("Enter Region: ");
                String regi = sc.nextLine();
                System.out.println("Enter number: ");
                numb = sc.nextInt();
                report = db.getReportTwentyTwo(regi, numb);
                app.printReport(report);
                break;

            case 23:
                report = db.getReportTwentyThree();
                app.printReport(report);
                break;

            case 24:
                report = db.getReportTwentyFour();
                app.printReport(report);
                break;

            case 25:
                report = db.getReportTwentyFive();
                app.printReport(report);
                break;

            case 26:
                report = db.getReportTwentySix();
                app.printReport(report);
                break;

            case 27:
                System.out.println("Enter Continent: ");
                String contt = sc.nextLine();
                report = db.getReportTwentySeven(contt);
                app.printReport(report);
                break;


            case 28:
                System.out.println("Enter Region: ");
                String regg = sc.nextLine();
                report = db.getReportTwentyEight(regg);
                app.printReport(report);
                break;

            case 29:
                System.out.println("Enter Country: ");
                String cou = sc.nextLine();
                report = db.getReportTwentyNine(cou);
                app.printReport(report);
                break;


            case 30:
                System.out.println("Enter District: ");
                String dis = sc.nextLine();
                report = db.getReportThirty(dis);
                app.printReport(report);
                break;

            case 31:
                System.out.println("Enter City: ");
                String cty = sc.nextLine();
                report = db.getReportThirtyOne(cty);
                app.printReport(report);
                break;

            case 32:
                report = db.getLanguageReport();
                app.printReport(report);
                break;

            default:
                System.out.println("Out of Range no.");
                break;
        }
    }



    /**
     * Print report options to console
     */
    private void printMenu() {
        String[] reportNo={
                "All the countries in the world organised by largest population to smallest",
                "All the countries in a continent organised by largest population to smallest",
                "All the countries in a region organised by largest population to smallest",
                "The top N populated countries in the world",
                "The top N populated continent in the world",
                "The top N populated countries in a region",
                "All the cities in the world organised by largest population to smallest",
                "All the cities in a continent organised by largest population to smallest",
                "All the cities in a region organised by largest population to smallest",
                "All the cities in a country organised by largest population to smallest",
                "All the cities in a district organised by largest population to smallest.",
                "The top N populated cities in the world",
                "The top N populated cities in a continent",
                "The top N populated cities in a region",
                "The top N populated cities in a country",
                "The top N populated cities in a district",
                "All the capital cities in the world organised by largest population to smallest",
                "All the capital cities in a continent organised by largest population to smallest",
                "All the capital cities in a region organised by largest to smallest",
                "The top N populated capital cities in the world",
                "The top N populated capital cities in a continent",
                "The top N populated capital cities in a region",
                "The population of people, people living in cities, and people not living in cities in each continent",
                "The population of people, people living in cities, and people not living in cities in each region",
                "The population of people, people living in cities, and people not living in cities in each country",
                "The population of the world",
                "The population of a continent",
                "The population of a region",
                "The population of a country",
                "The population of a district",
                "The population of a city",
                "The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world."
        };
        System.out.println("Choose a report no:");
        for(int i=0; i<reportNo.length;i++){
            System.out.printf(" %d. %s%n ",i+1,reportNo[i]);
        }
        System.out.println("\nEnter 0 to exit\n");
    }

    /**
     *
     * To produce formatted report of city, country, language, population, total population
     * @param report
     */






    protected void printReport(Report report) {

        if (report instanceof Country) {
            Country.printReportHeader();

            for (Country.CountryReportItem item : ((Country) report).get_reportsItems()) {
                System.out.printf(
                        Country.getReportFormat(), item.get_code(), item.get_name(), item.get_continent(), item.get_region(), item.get_population(), item.get_capital());
                System.out.print("\n");
            }
        }

        if (report instanceof City){
            City.printReportHeader();
            for(City.CityReportItem item : ((City) report).get_reportsItems()){
                System.out.printf(City.getReportFormat(), item.get_name(), item.get_country(), item.get_district(), item.get_population());
                System.out.print("\n");
            }
        }

        if (report instanceof CapitalCity){
            CapitalCity.printReportHeader();
            for (CapitalCity.CapitalCityReportItem item : ((CapitalCity) report).get_reportsItems()){
                System.out.printf(CapitalCity.getReportFormat(),item.get_name(),item.get_population(),item.get_Country());
                System.out.print("\n");
            }
        }

        if (report instanceof Population){
            Population.printReportHeader();
            for (Population.PopulationReportItem item : ((Population) report).get_reportsItems()){
                System.out.printf(Population.getReportFormat(),item.get_name(),item.get_population(),item.get_popNotInCity(),item.get_popInCity(),item.get_popNotInCityPercentage(),item.get_popinCityyPercentage());
                System.out.print("\n");
            }
        }

        if (report instanceof TotalPopulation){
            TotalPopulation.printReportHeader();
            for(TotalPopulation.TotalPopulationReportItem item : ((TotalPopulation) report).get_reportsItems()){
                System.out.printf(TotalPopulation.getReportFormat(),item.get_name(),item.get_population());
                System.out.print("\n");
            }
        }

        if (report instanceof Language){
            Language.printReportHeader();
            for (Language.LanguageReportItem item : ((Language) report).get_reportsItems()){
                System.out.printf(Language.getReportFormat(),item.get_name(),item.get_SpeakerPop(),item.get_worldPercentage());
                System.out.print("\n");
            }
        }
    }
}