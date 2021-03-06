package com.napier.sem;
import java.sql.*;


public class DatabaseHandler {

    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;


    /**
     * Instance of DatabaseHandler
     */
    private static DatabaseHandler _instance = null;


    /**
     * Method that instantiates _instance if null
     *
     * @return Instance of DatabaseHandler
     */
    public static DatabaseHandler Instance() {

        if (_instance == null)
            _instance = new DatabaseHandler();

        return _instance;
    }

    /**
     * Disabled constructor
     */
    private DatabaseHandler() {
    }

    /**
     * Connect to the MySQL database.
     */
    protected void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 20;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "pass");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
        }
    }



    /**
     * Disconnect from the MySQL database.
     */
    protected void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("--------------------------------------");
                System.out.println("Connection to database closed");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * This is the method for Report One to produce the report of all countries in the world organized by
     * largest population to the smallest.
     */
    protected Report getReportOne() {

        // REPORT 1
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC;";
            rset = stmt.executeQuery(strSelect);

            Country report = new Country();

            // Loop on result set and add report items to report
            while (rset.next()) {
                Country.CountryReportItem item = report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Two to produce the report of all countries in the continent organized by
     * largest population to the smallest.
     */
    protected Report getReportTwo(String continent){
        //REPORT 2
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select con.code, con.name, con.continent, con.region , con.population, cit.name as capital from country con join city cit on capital=id where continent = ? order by population DESC;";

            PreparedStatement preparedStatement=con.prepareStatement(strSelect);
            preparedStatement.setString(1,continent);

            rset = preparedStatement.executeQuery();
            Country report=new Country();

            //Loop on result set and add report items to report
            while (rset.next()){
                Country.CountryReportItem item=report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * This is the method for Report Three to produce the report of all countries in the region organized by
     * largest population to the smallest.
     */
    protected Report getReportThree(String region){
        //REPORT 3
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select con.code, con.name, con.continent, con.region , con.population, cit.name as capital from country con join city cit on capital=id where region = ? order by population DESC;";

            PreparedStatement preparedStatement=con.prepareStatement(strSelect);
            preparedStatement.setString(1,region);

            rset = preparedStatement.executeQuery();
            Country report=new Country();

            //Loop on result set and add report items to report
            while (rset.next()){
                Country.CountryReportItem item=report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Four to produce the top N populated countries in the world
     * N is provided by the User
     */
    protected Report getReportFour(int num) {
        // REPORT 4

        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id order by population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setInt(1, num);

            rset = preparedStatement.executeQuery();
            Country report = new Country();
            while (rset.next()) {
                Country.CountryReportItem item = report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * This is the method for Report five to produce the top N populated countries in the continent
     * N is provided by the User
     */
    protected Report getReportFive(String continent, int num) {
        // REPORT 5

        try {
            String strSelect = "";
            ResultSet rset = null;


            strSelect = "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id where continent = ? order by population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, continent);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            Country report = new Country();
            while (rset.next()) {
                Country.CountryReportItem item = report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Six to produce the top N populated countries in the region
     * N is provided by the User
     */
    protected Report getReportSix(String region, int num) {
        // REPORT 6

        try {

            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select con.code, con.name, con.continent, con.region, con.population, cit.name as capital from country con join city cit on capital=id where region = ? order by population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            Country report = new Country();
            while (rset.next()) {
                Country.CountryReportItem item = report.new CountryReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Seven to produce all the cities in the world
     * Organized by the largest population to the smallest
     */
    protected Report getReportSeven() {

        // REPORT 7
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC;";
            rset = stmt.executeQuery(strSelect);

            City report = new City();

            // Loop on result set and add report items to report
            while (rset.next()) {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Eight to produce all the cities in the continent
     * Organized by the largest population to the smallest
     */
    protected Report getReportEight(String continent) {
        // REPORT 8
        try {
            ResultSet rset = null;
            String select = "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where country.continent = ? order by city.population DESC;";

            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, continent);
            rset = preparedStatement.executeQuery();

            City report = new City();

            // Loop on result set and add report items to report
            while (rset.next()) {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * This is the method for Report Nine to produce all the cities in the region
     * Organized by the largest population to the smallest
     */
    protected Report getReportNine(String region) {

        // REPORT 9
        try {

            ResultSet rset = null;
            String select = "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where country.region = ? order by city.population DESC;";

            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, region);
            rset = preparedStatement.executeQuery();

            City report = new City();
            while (rset.next()){
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * This is the method for Report Ten to produce all the cities in the country
     * Organized by the largest population to the smallest
     */
    protected Report getReportTen(String country) {

        // REPORT 10
        try {

            ResultSet rset = null;

            String select =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where country.name = ? order by city.population DESC;";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, country);
            rset = preparedStatement.executeQuery();
            City report = new City();

            // Loop on result set and add report items to report
            while (rset.next()) {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    /**
     * This is the method for Report Eleven to produce all the cities in the district
     * Organized by the largest population to the smallest
     */
    protected Report getReportEleven(String district) {

        // REPORT 11
        try {
            ResultSet rset = null;

            String select =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where district = ? order by city.population DESC;";
            PreparedStatement preparedStatement = con.prepareStatement(select);
            preparedStatement.setString(1, district);
            rset = preparedStatement.executeQuery();
            City report = new City();

            // Loop on result set and add report items to report
            while (rset.next()) {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Twelve to produce the report of top N populated cities in the world
     * N is provided by user
     */
    protected Report getReportTwelve(int num)  // REPORT 12
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setInt(1, num);

            rset = preparedStatement.executeQuery();
            City report = new City();

            while (rset.next())
            {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }


    /**
     * This is the method for Report Thirteen to produce the report of top N populated cities in a continent
     * N is provided by user
     */
    protected Report getReportThirteen(int num, String continent)  // REPORT 13
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where continent = ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, continent);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            City report = new City();

            while (rset.next())
            {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report Fourteen to produce the report of top N populated cities in a region
     * N is provided by user
     */
    protected Report getReportFourteen(int num, String region)  // REPORT 14
    {
        try
        {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where region = ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            City report = new City();

            while (rset.next())
            {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report Fifteen to produce the report of top N populated cities in a country
     * N is provided by user
     */
    protected Report getReportFifteen(int num, String country)  // REPORT 15
    {
        try
        {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where country.name = ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, country);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            City report = new City();

            while (rset.next())
            {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report sixteen to produce the report of top N populated cities in the district
     * N is provided by user
     */
    protected Report getReportSixteen(int num, String district)  // REPORT 16
    {
        try
        {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.district, city.population from city city join country country on CountryCode=code where city.district = ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, district);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            City report = new City();

            while (rset.next())
            {
                City.CityReportItem item = report.new CityReportItem(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
                report.addItemToReport(item);
            }

            return report;
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report Seventeen to produce the report of all the capital cities in the world
     * Organized by largest population to smallest
     */
    protected Report getReportSeventeen() {

        // REPORT 17
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.population from city city join country country on id=capital order by city.population DESC;";
            rset = stmt.executeQuery(strSelect);

            CapitalCity report = new CapitalCity();

            // Loop on result set and add report items to report
            while (rset.next()) {
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Eighteen to produce the report of all the capital cities in a continent
     * Organized by largest population to smallest
     */
    protected Report getReportEighteen( String continent)  // REPORT 18
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect =
                    "select city.name, country.name, city.population from city city join country country on id=capital where continent = ? order by city.population DESC;;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, continent);

            rset = preparedStatement.executeQuery();
            CapitalCity report = new CapitalCity();

            while (rset.next()) {
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report Nineteen to produce the report of all the capital cities in a region
     * Organized by largest population to smallest
     */
    protected Report getReportNineteen (String region) // REPORT 19
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select city.name, country.name, city.population from city city join country on id=capital where region = ? order by city.population DESC;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, region);

            rset = preparedStatement.executeQuery();
            CapitalCity report = new CapitalCity();

            while (rset.next()){
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report Twenty to produce the report of the top N populated capital cities in the world
     * N is provided by User
     */
    protected Report getReportTwenty(int number) //REPORT 20
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            int num = number;
            strSelect = "select city.name, country.name, city.population from city city join country country on id=capital order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setInt(1,num);

            rset = preparedStatement.executeQuery();
            CapitalCity report = new CapitalCity();

            while (rset.next()){
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This is the method for Report TwentyOne to produce the report of the top N populated capital cities in a continent
     * N is provided by User
     */
    protected Report getReportTwentyOne (String continent, int number) // REPORT 21
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            int num = number;
            strSelect= "select city.name, country.name, city.population from city city join country country on id=capital where continent= ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, continent);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            CapitalCity report = new CapitalCity();

            while (rset.next()){
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report TwentyTwo to produce the report of the top N populated capital cities in a region
     * N is provided by User
     */
    protected Report getReportTwentyTwo (String region, int number) // REPORT 22
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            int num = number;
            strSelect= "select city.name, country.name, city.population from city city join country country on id=capital where region= ? order by city.population DESC LIMIT ?;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, region);
            preparedStatement.setInt(2, num);

            rset = preparedStatement.executeQuery();
            CapitalCity report = new CapitalCity();

            while (rset.next()){
                CapitalCity.CapitalCityReportItem item = report.new CapitalCityReportItem(rset.getString(1), rset.getString(2), rset.getInt(3));
                report.addItemToReport(item);
            }

            return report;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * This is the method for Report TwentyThree to produce the report of the population of people, people living in cities and people not living in cities
     * in each continent
     */
    protected Report getReportTwentyThree()  // REPORT 23
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "Select country.continent, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.continent;";
            rset = stmt.executeQuery(strSelect);

            Population report = new Population();

            // Loop on result set and add report items to report
            while (rset.next()) {

                Population.PopulationReportItem item = report.new PopulationReportItem(rset.getString(1), rset.getLong(2), rset.getLong(3), rset.getFloat(4), rset.getLong(5), rset.getFloat(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report Twentyfour to produce the report of the population of people, people living in cities and people not living in cities
     * in each region
     */
    protected Report getReportTwentyFour()  // REPORT 24
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "Select country.region, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.region;";
            rset = stmt.executeQuery(strSelect);

            Population report = new Population();

            // Loop on result set and add report items to report
            while (rset.next()) {

                Population.PopulationReportItem item = report.new PopulationReportItem(rset.getString(1), rset.getLong(2), rset.getLong(3), rset.getFloat(4), rset.getLong(5), rset.getFloat(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report Twentyfive to produce the report of the population of people, people living in cities and people not living in cities
     * in each country
     */
    protected Report getReportTwentyFive()  // REPORT 25
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select country.name, country.population, country.population-sum(city.population) as 'pop not in city', ((country.population-sum(city.population))/country.population)*100 as 'PopnotinCity%', country.population - (country.population-sum(city.population)) as 'pop in city', ((country.population - (country.population-sum(city.population)))/country.population)*100 as 'PopInCity%' from country country join city city on country.code = city.countrycode where city.countrycode = country.code GROUP BY country.name, country.population ORDER BY country.name;";
            rset = stmt.executeQuery(strSelect);

            Population report = new Population();

            // Loop on result set and add report items to report
            while (rset.next()) {

                Population.PopulationReportItem item = report.new PopulationReportItem(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getFloat(4), rset.getInt(5), rset.getFloat(6));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report TwentySix to produce the report of the population of the world.
     */
    protected Report getReportTwentySix()  // REPORT 26
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "SELECT sum(population) AS 'World Population' FROM country;";
            rset = stmt.executeQuery(strSelect);

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem("World Population", rset.getLong(1));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report TwentySeven to produce the report of the population of a continent.
     */
    protected Report getReportTwentySeven(String continent)  // REPORT 27
    {
        try {

            String strSelect = "";
            ResultSet rset = null;

            strSelect = "SELECT continent, sum(population) AS 'Continent Population' FROM country WHERE continent = ? group by continent;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, continent);

            rset = preparedStatement.executeQuery();

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem(rset.getString(1), rset.getLong(2));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report TwentyEight to produce the report of the population of a region.
     */
    protected Report getReportTwentyEight(String region)  // REPORT 28
    {
        try {

            String strSelect = "";
            ResultSet rset = null;

            strSelect = "SELECT region, sum(population) AS 'Region Population' FROM country WHERE region = ? group by region;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, region);

            rset = preparedStatement.executeQuery();

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem(rset.getString(1), rset.getLong(2));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report TwentyNine to produce the report of the population of a country.
     */
    protected Report getReportTwentyNine(String country)  // REPORT 29
    {
        try {

            String strSelect = "";
            ResultSet rset = null;

            strSelect = "SELECT name, sum(population) AS 'Country Population' FROM country WHERE name = ? group by name;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, country);

            rset = preparedStatement.executeQuery();

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem(rset.getString(1), rset.getLong(2));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * This is the method for Report Thirty to produce the report of the population of a district.
     */
    protected Report getReportThirty(String district)  // REPORT 30
    {
        try {

            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select district, sum(population) as 'District Population' from city where district = ? group by district;";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, district);

            rset = preparedStatement.executeQuery();

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem(rset.getString(1), rset.getLong(2));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * This is the method for Report ThirtyOne to produce the report of the population of a city.
     */
    protected Report getReportThirtyOne(String name)  // REPORT 31
    {
        try {
            String strSelect = "";
            ResultSet rset = null;

            strSelect = "select name, population from city where name = ?";

            PreparedStatement preparedStatement = con.prepareStatement(strSelect);
            preparedStatement.setString(1, name);

            rset = preparedStatement.executeQuery();

            TotalPopulation report = new TotalPopulation();

            // Loop on result set and add report items to report
            while (rset.next()) {

                TotalPopulation.TotalPopulationReportItem item = report.new TotalPopulationReportItem(rset.getString(1), rset.getLong(2));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }





    /**
     * This is the method to produce the report of Language.
     */
    protected Report getLanguageReport()  // REPORT 32-36
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect = "";
            ResultSet rset = null;
            strSelect = "select cl.language, sum(cl.percentage*c.population) as speakerlangugaepop, sum(c.population*cl.percentage)/(select sum(population) from country) as worldpercentage from countrylanguage cl, country c where cl.countrycode=c.code and cl.language in ('English','Arabic','Hindi','Chinese','Spanish') group by cl.language order by speakerlangugaepop DESC;";

            rset = stmt.executeQuery(strSelect);

            Language report = new Language();

            while (rset.next()) {

                Language.LanguageReportItem item = report.new LanguageReportItem(rset.getString(1), rset.getLong(2),rset.getFloat(3));
                report.addItemToReport(item);
            }
            return report;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



}
