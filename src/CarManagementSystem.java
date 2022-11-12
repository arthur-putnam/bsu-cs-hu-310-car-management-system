import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The purpose of this application is to provide examples similar to
 * the final project. This application will read and write data
 * from a MySQL database. The data in this database will be used to
 * manage things a car dealership might be interested in tracking.
 * For example, who has bought a car, what cars are for sale, etc.
 *
 * NOTE: This project is geared towards learning and focuses on basic
 * application to database communication. It needs to include some
 * best practices, such as using prepared statements and input
 * sanitization, before use in any production environment.
 */
public class CarManagementSystem {


    /**
     * This method will query all of the cars from the database and print them
     * out in a table like style.
     */
    public static void listCars() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will query all of the sales from the database and print them
     * out in a table like style.
     */
    public static void listSales() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
        } catch (SQLException sqlException) {
            System.out.println("Failed to get sales");
            System.out.println(sqlException.getMessage());

        } finally {
            try {
                if (sqlStatement != null) sqlStatement.close();
            } catch (SQLException se) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * This method will query all of the purchases from the database and print
     * them out in a table like style.
     */
    public static void listPurchases() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will query all of the customers from the database and print
     * them out in a table like style.
     */
    public static void listCustomers() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will query all of the cars that are available for sale from
     * the database and print them out in a table like style. We know a car is
     * available for sell if the dealership has not sold it yet.
     */
    public static void listAvailableCarsForSale() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will query all of the sales that were made this month
     * from the database and print them out in a table like style.
     */
    public static void listSalesThisMonth() {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will query all of the cars that are owned by a specific
     * customer from the database and print them out in a table like style.
     * We know a car "belongs" to a customer if it was sold to them.
     */
    public static void listAllCarsByCustomer(String firstName, String lastName) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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


    /**
     * This method will add a new customer to the system by inserting a new
     * customer record into the database.
     */
    public static void createNewCustomer(String firstName, String lastName, String phoneNumber, String email) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will delete a customer from the database.
     */
    public static void deleteCustomer(String customerId) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will handle purchasing a car. Specifically, it will add the
     * car and purchase records to the database and print out the purchase
     * information.
     *
     * Note: When a dealership purchases a car they need to first add the car
     * to the database and then add the purchase which references the car to
     * the database.
     */
    public static void purchaseCar(String make, String model, String category, String year,
                                   String condition, String kbp, String purchaseAmount,
                                   String purchaseDate) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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

    /**
     * This method will handle the sale of a car. Specifically, it will add the
     * car_sale record to the database and print out the purchase
     * information.
     *
     * Note: When a dealership sales a car it needs to check that they have not
     * already sold the car.
     */
    public static void saleCar(String carId, String customerId, String saleAmount, String saleDate) {
        Connection connection = null;
        Statement sqlStatement = null;

        try {
            /* Your logic goes here */
            throw new SQLException(); // REMOVE THIS (this is just to force it to compile)
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
     * @param command - Car Management System cli command
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
                System.out.println("purchase car <Make>, <model>, <category>, <year>, <condition>, <kbp>, <purchaseAmount>, <purchaseDate>\n\tmake a purchase");
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
                            commandArguments.get(4), commandArguments.get(5), commandArguments.get(6),
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

