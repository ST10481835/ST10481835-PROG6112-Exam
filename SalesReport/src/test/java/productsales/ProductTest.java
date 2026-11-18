package productsales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product GetSampleProduct() {
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] productSales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        return new Product(productNames, productSales);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = GetSampleProduct();
        int actualTotal = product.GetTotalProductsSold();
        assertEquals(153, actualTotal);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = GetSampleProduct();
        double actualAverage = product.GetAverageProductSold();
        assertEquals(17.0, actualAverage, 0.001);
    }

    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        Product product = GetSampleProduct();
        String actualMostPopular = product.GetMostPopularProduct();
        assertEquals("Cozy Nights Monarch (63)", actualMostPopular);
    }
}