/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
public class ProductCalculations implements IProductCalculations {

    // Variable to store the product price
    // It is private so only this class can change it
    private double price;

    // Constructor - this runs when we create a new ProductCalculations object
    // Example: new ProductCalculations(3500)
    // It saves the price that was passed in
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate VAT
    // Rule from Q2.1: VAT = 15% of the product price
    // Example: 3500 * 0.15 = 525.0
    @Override
    public double GetVat() {
        double vat = price * 0.15;
        return vat;
    }

    // Calculate Commission
    // Rule from Q2.1: Commission = 5% of the product price
    // Example: 3500 * 0.05 = 175.0
    @Override
    public double GetCommission() {
        double commission = price * 0.05;
        return commission;
    }

    // Calculate Total Sale Amount
    // Rule from Q2.1: Total = Price + VAT + Commission
    // Example: 3500 + 525 + 175 = 4200.0
    // We call GetVat() and GetCommission() here so we do not repeat the maths
    @Override
    public double GetTotal() {
        double total = price + GetVat() + GetCommission();
        return total;
    }
}