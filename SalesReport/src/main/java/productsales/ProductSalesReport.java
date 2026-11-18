/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
import java.util.Scanner;

public class ProductSalesReport {

    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard.
        Scanner input = new Scanner(System.in);

        // SINGLE DIMENSIONAL ARRAY: stores the 3 product names.
        // Using an array means we do not have to write the same prompt 3 times.
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // TWO DIMENSIONAL ARRAY: stores the sales.
        // Rows = products (3), Columns = months (3).
        // Example: monthlySales[0][0] = Cozy, month 1.
        int[][] monthlySales = new int[3][3];

        // INPUT SECTION
        // Outer loop: go through each product.
        for (int productIndex = 0; productIndex < productNames.length; productIndex++) {

            // Inner loop: go through month 1, 2 and 3 for this product.
            // monthIndex is 0, 1, 2, but we display monthIndex + 1 so the user sees 1, 2, 3.
            for (int monthIndex = 0; monthIndex < 3; monthIndex++) {

                // Ask the user for this product and this month.
                // This matches the sample prompt exactly.
                System.out.print("Enter number of sales for month " + (monthIndex + 1)
                        + " for " + productNames[productIndex] + " mattress: ");

                // Read the number and store it in the 2D array.
                monthlySales[productIndex][monthIndex] = input.nextInt();
            }

            // Print a blank line after each product to match the sample.
            System.out.println();
        }

        // Create a Product object and pass the arrays into its constructor.
        // The Product object will now store the data in its fields.
        Product product = new Product(productNames, monthlySales);

        // Create a PrintProduct object to handle all printing.
        PrintProduct printer = new PrintProduct();

        // OUTPUT SECTION: Print the report header here, then use PrintProduct
        // for the three results. This keeps printing in PrintProduct.
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("********************************************");
        printer.PrintTotalProductSales(product);
        printer.PrintAverageProductSales(product);
        printer.PrintMostPopularProduct(product);

        // Close the Scanner to free up resources. This is good practice.
        input.close();
    }
}