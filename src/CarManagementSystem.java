import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The purpose of this application is to provide examples similar to 
 * the final project. This application will take read and write data 
 * from a MySQL database. The data in this database will be used to
 * manage things a car dealership might be interested in tracking. 
 * For example, who has bought a car, what cars are for sale, etc. 
 */
public class CarManagementSystem {

	
	public static void listCars() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT * FROM cars;";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("car_id | make | model | category | year | condition | kelly_bluebook_price");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String category = resultSet.getString("category");
                String year = resultSet.getString("year");
                String condition = resultSet.getString("condition");
                float kelly_bluebook_price = resultSet.getFloat("kelly_bluebook_price");

                String output = String.format(
                		"%s | %s | %s | %s | %s | %s | $%s ",
                		carId, make, model, category, year, condition, kelly_bluebook_price);
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get cars");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	}
    
	public static void listSales() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT * FROM car_sales;";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("sale_id | car_id | customer_id | sale_amount | sales_date");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int saleId = resultSet.getInt("sale_id");
                int carId = resultSet.getInt("car_id");
                int customerId = resultSet.getInt("customer_id");
                float saleAmount = resultSet.getFloat("sale_amount");
                Timestamp salesDate = resultSet.getTimestamp("sales_date");

                String output = String.format(
                		"%s | %s | %s | %s | %s",
                		saleId, carId, customerId, saleAmount, salesDate);
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get sales");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public static void listPurchases() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT * FROM car_purchases;";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("purchase_id | car_id | purchase_amount | purchase_date");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int purchaseId = resultSet.getInt("purchase_id");
                int carId = resultSet.getInt("car_id");
                float purchaseAmount = resultSet.getFloat("purchase_amount");
                Timestamp purchaseDate = resultSet.getTimestamp("purchase_date");

                String output = String.format(
                		"%s | %s | %s | %s",
                		purchaseId, carId, purchaseAmount, purchaseDate);
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get purchases");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public static void listCustomers() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT * FROM customers;";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("customer_id | first_name | last_name | phone_number | email");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
            

                String output = String.format(
                		"%s | %s | %s | %s | %s",
                		customerId, firstName, lastName, phoneNumber, email);
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get customers");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public static void listAvailableCarsForSale() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT \r\n"
            		+ "	cars.*\r\n"
            		+ "FROM cars\r\n"
            		+ "WHERE NOT EXISTS (\r\n"
            		+ "	SELECT 1\r\n"
            		+ "    FROM car_sales WHERE car_sales.car_id = cars.car_id \r\n"
            		+ ");";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("car_id | make | model | category | year | condition | kelly_bluebook_price");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String category = resultSet.getString("category");
                String year = resultSet.getString("year");
                String condition = resultSet.getString("condition");
                float kelly_bluebook_price = resultSet.getFloat("kelly_bluebook_price");

                String output = String.format(
                		"%s | %s | %s | %s | %s | %s | $%s ",
                		carId, make, model, category, year, condition, kelly_bluebook_price);
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get available cars for sale");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void listSalesThisMonth() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT \r\n"
            		+ "	cars.*,\r\n"
            		+ "	car_sales.sale_amount,\r\n"
            		+ "    car_sales.sales_date\r\n"
            		+ "FROM cars\r\n"
            		+ "JOIN car_sales ON cars.car_id = car_sales.car_id\r\n"
            		+ "WHERE MONTH(sales_date) = MONTH(CURRENT_DATE);";
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("car_id | make | model | category | year | condition | kelly_bluebook_price "
            		+ "| sale_amount | sale_date");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String category = resultSet.getString("category");
                String year = resultSet.getString("year");
                String condition = resultSet.getString("condition");
                float kelly_bluebook_price = resultSet.getFloat("kelly_bluebook_price");
                float sale_amount = resultSet.getFloat("sale_amount");
                Timestamp sales_date = resultSet.getTimestamp("sales_date");

                String output = String.format(
                		"%s | %s | %s | %s | %s | %s | $%s | $%s | %s",
                		carId, make, model, category, year, condition, kelly_bluebook_price, 
                		sale_amount, sales_date );
                System.out.println(output);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to get sales for this month");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

	public static void listAllCarsByCustomer(String firstName, String lastName) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "SELECT \r\n"
            		+ "	* \r\n"
            		+ "FROM cars \r\n"
            		+ "JOIN car_sales ON cars.car_id = car_sales.car_id\r\n"
            		+ "JOIN customers ON car_sales.customer_id = customers.customer_id\r\n"
            		+ "WHERE first_name = '%s' AND last_name = '%s';";
            sql = String.format(sql, firstName, lastName);
            ResultSet resultSet = sqlStatement.executeQuery(sql);

            System.out.println("car_id | make | model | category | year | condition | kelly_bluebook_price");
            System.out.println("-".repeat(80));

            while (resultSet.next()) {
                int carId = resultSet.getInt("car_id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String category = resultSet.getString("category");
                String year = resultSet.getString("year");
                String condition = resultSet.getString("condition");
                float kelly_bluebook_price = resultSet.getFloat("kelly_bluebook_price");

                String output = String.format(
                		"%s | %s | %s | %s | %s | %s | $%s ",
                		carId, make, model, category, year, condition, kelly_bluebook_price);
                System.out.println(output);
            }
           
            
        } catch (SQLException sqlException) {
            System.out.println("Failed to get all cars by customer");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
	

    public static void createNewCustomer(String firstName, String lastName, String phoneNumber, String email) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "INSERT INTO customers (first_name, last_name, phone_number, email)\r\n"
            		+ "VALUES ('%s', '%s', '%s','%s');";
            sql = String.format(sql, firstName, lastName, phoneNumber, email);
            
            // We will need the customer_id since we want to display it and the 
            // database generates this. When inserting data, by default MySQL does
            // not return any information other than the number of rows inserted. 
            // To get around this we can pass the RETURN_GENERATED_KEYS argument
            // in order to get the generated keys aka our customer id value.
            
            int rows = sqlStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            // This resultset only contains the generated keys (aka customer_id)
            ResultSet resultSet = sqlStatement.getGeneratedKeys();

            System.out.println("customer_id | first_name | last_name | phone_number | email");
            System.out.println("-".repeat(80));

        	// We only need to get the generated id from the database
        	// since we already have the other information because
        	// it was part of the input arguments
            resultSet.next();
            int customerId = resultSet.getInt(1);
            
            String output = String.format(
            		"%s | %s | %s | %s | %s ",
            		customerId, firstName, lastName, phoneNumber, email);
            System.out.println(output);
           
           
        } catch (SQLException sqlException) {
            System.out.println("Failed to create new customer");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void deleteCustomer(String customerId) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();

            String sql = "DELETE FROM customers WHERE customer_id = %s";
            sql = String.format(sql, customerId);
           
            int rows = sqlStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            if (rows > 0) {
            	System.out.println("Customer was deleted.");
            } else {
            	System.out.println("Customer was not found.");
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed to delete customer");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void purchaseCar(String make, String model, String category, String year,
    								  String condition, String kbp, String purchaseAmount, 
    								  String purchaseDate) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            
        	// Create car
        	// Create purchase
        	
        	connection = Database.getDatabaseConnection();
            sqlStatement = connection.createStatement();
            
            // We want to manually control the transaction
            connection.setAutoCommit(false);
            
            String sql = "INSERT INTO cars (make, model, category, year, `condition`, kelly_bluebook_price)\r\n"
            		+ "VALUES ('%s', '%s', '%s','%s','%s','%s');";
            sql = String.format(sql,  make,  model,  category,  year,condition, kbp);
        	
            
            // Create the car
            int rows = sqlStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            // Get the car's car_id
            ResultSet resultSet = sqlStatement.getGeneratedKeys();
            resultSet.next();
            int carId = resultSet.getInt(1);
            
            // Now we need to insert a purchase record with the new car id.
            sql = "INSERT INTO car_purchases (car_id, purchase_amount, purchase_date)\r\n"
            		+ "VALUES ('%s', '%s', STR_TO_DATE('%s', '%%m/%%d/%%Y'));";
            sql = String.format(sql,  carId,  purchaseAmount,  purchaseDate);
            
            // Create the purchase record
            rows = sqlStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            resultSet = sqlStatement.getGeneratedKeys();
            resultSet.next();
            int purchaseId = resultSet.getInt(1);

            // Finish the transaction
            connection.commit();
            
            
            System.out.println("purchase_id | car_id | purchase_amount | purchase_date ");
            System.out.println("-".repeat(80));
 
            String output = String.format(
            		"%s | %s | %s | %s",
            		purchaseId, carId, purchaseAmount, purchaseDate);
            System.out.println(output);
            
           
  
        } catch (SQLException sqlException) {
        	System.out.println("Failed to create car purchase");
            System.out.println(sqlException.getMessage());
        	
            try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void saleCar(String carId, String customerId, String saleAmount, String saleDate) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            // Make sure car isn't already sold
        	// then create sales entry
        	
        	
        } catch (SQLException sqlException) {
            System.out.println("Failed to sale car");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null)
                    sqlStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    

    /***
     * Splits a string up by spaces. Spaces are ignored when wrapped in quotes.
     *
     * @param command - School Management System cli command
     * @return splits a string by spaces.
     */
    public static List<String> parseArguments(String command) {
        List<String> commandArguments = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
        while (m.find()) commandArguments.add(m.group(1).replace("\"", ""));
        return commandArguments;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Car Management System");
        System.out.println("-".repeat(80));

        Scanner scan = new Scanner(System.in);
        String command = "";

        do {
            System.out.print("Command: ");
            command = scan.nextLine();

            List<String> commandArguments = parseArguments(command);
            command = commandArguments.get(0);
            commandArguments.remove(0);

            if (command.equals("help")) {
                System.out.println("-".repeat(38) + "Help" + "-".repeat(38));
                System.out.println("test connection \n\tTests the database connection");

                System.out.println("list cars \n\tlists all the cars");
                System.out.println("list sales \n\tlists all the sales");
                System.out.println("list purchases \n\tlists all the purchases");
                System.out.println("list customers \n\tlists all the customers");
                System.out.println("list AllCarsByCustomer <first_name> <last_name>\n\tlists all the cars owned by a customer");
                System.out.println("list listSalesThisMonth \n\tlists all the classes taught by that instructor");


                System.out.println("delete customer <customerId> \n\tdeletes the customer");
                System.out.println("create customer <first_name> <last_name> \n\tcreates a customer");
                System.out.println("purchase car <Make>, <model>, <category>, <year>,<condition>, <kbp>, <string>, <purchaseDate>\n\tmake a purchase");
                System.out.println("sale car <carId>, <customerId>, <saleAmount>, <saleDate>\n\tmake a purchase");

                System.out.println("help \n\tlists help information");
                System.out.println("quit \n\tExits the program");
            } else if (command.equals("test") && commandArguments.get(0).equals("connection")) {
                Database.testConnection();
            } else if (command.equals("list")) {
                if (commandArguments.get(0).equals("cars")) listCars();
                if (commandArguments.get(0).equals("sales")) listSales();
                if (commandArguments.get(0).equals("purchases")) listPurchases();
                if (commandArguments.get(0).equals("customers")) listCustomers();
                if (commandArguments.get(0).equals("AvailableCarsForSale")) listAvailableCarsForSale();
                if (commandArguments.get(0).equals("SalesThisMonth")) listSalesThisMonth();
                
                if (commandArguments.get(0).equals("AllCarsByCustomer")) {
                	listAllCarsByCustomer(commandArguments.get(1), commandArguments.get(2));
                }
                
            } else if (command.equals("create")) {
                if (commandArguments.get(0).equals("customer")) {
                	createNewCustomer(commandArguments.get(1), commandArguments.get(2), 
                			commandArguments.get(3), commandArguments.get(4));
                }
            } else if (command.equals("purchase")) {
                if (commandArguments.get(0).equals("car")) {
                	purchaseCar(commandArguments.get(1), commandArguments.get(2), commandArguments.get(3),
                			commandArguments.get(4),commandArguments.get(5),commandArguments.get(6),
                			commandArguments.get(7), commandArguments.get(8));
                }
            } else if (command.equals("sale")) {
                if (commandArguments.get(0).equals("car")) {
                	saleCar(commandArguments.get(1), commandArguments.get(2), commandArguments.get(3), commandArguments.get(4));
                }
            } else if (command.equals("delete")) {
                if (commandArguments.get(0).equals("customer")) {
                	deleteCustomer(commandArguments.get(1));
                }
            } else if (!(command.equals("quit") || command.equals("exit"))) {
                System.out.println(command);
                System.out.println("Command not found. Enter 'help' for list of commands");
            }
            System.out.println("-".repeat(80));
        } while (!(command.equals("quit") || command.equals("exit")));
        System.out.println("Bye!");
    }
}

