/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
public class PrintProduct {

    // Print the total product sales.
    // We pass in the Product object and call its GetTotalProductsSold method.
    public void PrintTotalProductSales(Product product) {
        // Get the total from the Product object and print it.
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Print the average product sales.
    // We pass in the Product object and call its GetAverageProductSold method.
    public void PrintAverageProductSales(Product product) {
        // Get the average from the Product object and print it.
        // Because the interface says double, this will print as 17.0 for the sample data.
        System.out.println("AVERAGE PRODUCT SALES: " + product.GetAverageProductSold());
    }

    // Print the most popular product.
    // We pass in the Product object and call its GetMostPopularProduct method.
    public void PrintMostPopularProduct(Product product) {
        // Get the most popular product from the Product object and print it.
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}