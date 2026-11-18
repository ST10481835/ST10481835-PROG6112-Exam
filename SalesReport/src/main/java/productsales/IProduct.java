/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
package productsales;

public interface IProduct {

    // Returns the total number of products sold for all products over all months.
    // Example with sample data: 153
    int GetTotalProductsSold();

    // Returns the average number of products sold.
    // The paper says this must be a double.
    // Example with sample data: 17.0, which is 153 divided by 9 entries.
    double GetAverageProductSold();

    // Returns the most popular product based on the highest TOTAL sales.
    // Example: Cozy Nights Monarch (63)
    String GetMostPopularProduct();
}