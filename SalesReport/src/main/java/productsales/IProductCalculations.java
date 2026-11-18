/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
public interface IProductCalculations {

    // Method to get the VAT amount
    // It takes no input, it uses the price stored in the class
    double GetVat();

    // Method to get the Commission amount
    double GetCommission();

    // Method to get the Total Sale amount
    double GetTotal();
}