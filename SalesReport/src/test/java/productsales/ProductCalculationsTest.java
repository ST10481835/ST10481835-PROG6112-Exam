/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package productsales;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    // Unit Test 1 from Q2.6: GetVat_WithValidData_ReturnsCorrectValue()
    // Purpose: verify GetVat correctly returns the VAT amount
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Create a ProductCalculations object with price 3500
        ProductCalculations calc = new ProductCalculations(3500);

        // Call GetVat and check the answer
        double actualVat = calc.GetVat();

        // 3500 * 0.15 = 525.0
        assertEquals(525.0, actualVat, 0.001);
    }

    // Unit Test 2 from Q2.6: GetTotal_WithValidData_ReturnsCorrectValue()
    // Purpose: verify GetTotal correctly returns the total sale amount
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Create a ProductCalculations object with price 3500
        ProductCalculations calc = new ProductCalculations(3500);

        // Call GetTotal and check the answer
        double actualTotal = calc.GetTotal();

        // 3500 + 525 + 175 = 4200.0
        assertEquals(4200.0, actualTotal, 0.001);
    }
}