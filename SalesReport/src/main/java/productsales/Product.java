/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ST104818355 Thabiso Mashego
 */
package productsales;

public class Product implements IProduct {

    // FIELD 1: Single dimensional array to store the 3 product names.
    // Example: productNames[0] = Cozy Nights Monarch
    // Private means only this class can change it directly. This is good practice.
    private String[] productNames;

    // FIELD 2: Two dimensional array to store the sales.
    // Rows = products (3), Columns = months (3).
    // Example: productSales[0][0] = Cozy Nights Monarch, month 1 = 25
    // Private means only this class can change it directly.
    private int[][] productSales;

    // CONSTRUCTOR: This runs when we create a new Product object.
    // We pass in the product names and the sales from the main class,
    // and we store them in the fields above so the methods below can use them.
    // We need this constructor because the interface methods take no parameters,
    // so the data must come in here.
    public Product(String[] productNames, int[][] productSales) {
        // this.productNames means the field in this class.
        // productNames on the right is the value passed into the constructor.
        this.productNames = productNames;
        this.productSales = productSales;
    }

    // METHOD 1: Calculate the TOTAL number of products sold.
    // We loop through every product and every month and add them all together.
    @Override
    public int GetTotalProductsSold() {
        // totalSales will hold the running total. It starts at 0.
        int totalSales = 0;

        // Outer loop: go through each product (each row of the 2D array).
        // productSales.length is 3 because there are 3 products.
        for (int productIndex = 0; productIndex < productSales.length; productIndex++) {

            // Inner loop: go through each month (each column) for this product.
            // productSales[productIndex].length is 3 because there are 3 months.
            for (int monthIndex = 0; monthIndex < productSales[productIndex].length; monthIndex++) {
                // Add this month's sales for this product to the running total.
                totalSales = totalSales + productSales[productIndex][monthIndex];
            }
        }

        // Return the final total to whoever called this method.
        return totalSales;
    }

    // METHOD 2: Calculate the AVERAGE number of products sold.
    // Average = total sales divided by total number of entries.
    // Total entries = 3 products x 3 months = 9.
    @Override
    public double GetAverageProductSold() {
        // Reuse the total method above instead of writing the loops again.
        // This avoids redundant code and makes the code more efficient.
        int totalSales = GetTotalProductsSold();

        // Count how many numbers are in the 2D array.
        int numberOfEntries = productSales.length * productSales[0].length;

        // (double) in front of totalSales forces decimal division.
        // Without it, Java would do integer division and cut off the decimal part.
        // Example: (double) 153 / 9 = 17.0
        double averageSales = (double) totalSales / numberOfEntries;

        // Return the average as a double, as required by the interface.
        return averageSales;
    }

    // METHOD 3: Find the MOST POPULAR product based on the highest TOTAL sales.
    // For each product we first add its 3 months to get its own total.
    // Then we compare that total to the best total found so far.
    @Override
    public String GetMostPopularProduct() {
        // highestTotal stores the biggest product total found so far.
        // It starts at -1 so even a product with 0 sales will be bigger than it.
        int highestTotal = -1;

        // mostPopularIndex stores the position of the winning product.
        // It starts at 0, which is the first product.
        int mostPopularIndex = 0;

        // Outer loop: go through each product one by one.
        for (int productIndex = 0; productIndex < productNames.length; productIndex++) {

            // productTotal holds the total for ONLY this one product.
            // It must be reset to 0 for each new product.
            int productTotal = 0;

            // Inner loop: add the 3 months for this product.
            for (int monthIndex = 0; monthIndex < productSales[productIndex].length; monthIndex++) {
                productTotal = productTotal + productSales[productIndex][monthIndex];
            }

            // Check if this product's total is bigger than the best one so far.
            if (productTotal > highestTotal) {
                // Save the new highest total.
                highestTotal = productTotal;
                // Save which product got that total.
                mostPopularIndex = productIndex;
            }
        }

        // Building the result in the same format as the sample: Name (total)
        // Example: Cozy Nights Monarch (63)
        // Note: The sample in the paper shows (25) here, but 25 is only month 1.
        // The written instruction says highest TOTAL sales, so 63 is correct.
        // Cozy total = 25 + 18 + 20 = 63.
        String mostPopularProduct = productNames[mostPopularIndex] + " (" + highestTotal + ")";

        // Return the formatted result.
        return mostPopularProduct;
    }
}