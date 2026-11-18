/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales;

/**
 *
 * @author ST10481835 Thabiso Mashego
 */
import javax.swing.*; // JFrame, JLabel, JTextField, JComboBox, JButton, JMenu, etc.
import java.awt.*; // BorderLayout, GridLayout, etc. for layout
import java.awt.event.*; // ActionListener for button and menu clicks
import java.io.*; // FileWriter and BufferedWriter for saving data.txt

// We extend JFrame to make a window, and implement ActionListener to handle clicks
public class ProductApp extends JFrame implements ActionListener {

    // Text box to capture the customer name - Q2.2
    private JTextField txtCustomerName;

    // Combo box to capture the product name - Q2.2
    private JComboBox<String> cmbProduct;

    // Text box to capture the product price - Q2.2
    private JTextField txtPrice;

    // Button to process the sale - Q2.3
    private JButton btnProcess;

    // Menu items - Q2.4
    private JMenuItem mnuExit;
    private JMenuItem mnuProcess;
    private JMenuItem mnuClear;

    // Constructor - this builds the whole window when we do new ProductApp()
    public ProductApp() {
        // Set the title that shows at the top of the window
        setTitle("Product App");

        // Set the size of the window - width 400, height 250
        setSize(400, 250);

        // Close the app when the X is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout - menu at top, form in middle
        setLayout(new BorderLayout());

        // ---------- MENU BAR - Q2.4 ----------
        // Create the menu bar that sits at the very top
        JMenuBar menuBar = new JMenuBar();

        // Create the File menu
        JMenu mnuFile = new JMenu("File");
        // Create the Exit item inside File
        mnuExit = new JMenuItem("Exit");
        // Tell Exit to listen for clicks
        mnuExit.addActionListener(this);
        // Add Exit to File
        mnuFile.add(mnuExit);

        // Create the Tools menu
        JMenu mnuTools = new JMenu("Tools");
        // Create Process and Clear inside Tools
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");
        // Tell both to listen for clicks
        mnuProcess.addActionListener(this);
        mnuClear.addActionListener(this);
        // Add them to Tools
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);

        // Add both menus to the menu bar
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        // Put the menu bar on the window
        setJMenuBar(menuBar);

        // ---------- FORM - Q2.2 ----------
        // Create a panel to hold the labels and text boxes
        // GridLayout with 4 rows, 2 columns, 10 pixels gap
        JPanel pnlForm = new JPanel(new GridLayout(4, 2, 10, 10));

        // Row 1: Customer Name label and text box
        pnlForm.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        pnlForm.add(txtCustomerName);

        // Row 2: Select Product label and combo box
        pnlForm.add(new JLabel("Select Product:"));
        // List of products from Q2.2
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        pnlForm.add(cmbProduct);

        // Row 3: Enter Price label and text box
        pnlForm.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        pnlForm.add(txtPrice);

        // Row 4: Empty label on left, PROCESS button on right
        pnlForm.add(new JLabel(""));
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(this);
        pnlForm.add(btnProcess);

        // Add the panel to the middle of the window
        add(pnlForm, BorderLayout.CENTER);

        // Make the window visible
        setVisible(true);
    }

    // This method does the whole Process job - Q2.3
    // It is used by BOTH the PROCESS button and the Tools > Process menu
    // so we do not write the same code twice
    private void processSale() {
        try {
            // Step 1: Capture the customer name from the text box
            String customerName = txtCustomerName.getText();

            // Step 2: Capture the selected product from the combo box
            String productName = (String) cmbProduct.getSelectedItem();

            // Step 3: Capture the price from the text box and change it to a double
            // We need a double because we do maths with it
            double price = Double.parseDouble(txtPrice.getText());

            // Step 4: Create a ProductCalculations object with the price
            ProductCalculations calc = new ProductCalculations(price);

            // Step 5: Call the methods to get VAT, Commission and Total
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Step 6: Build the message to show in the popup box
            // This must match the sample in the question
            String message = "Customer Name: " + customerName
                    + "\nProduct: " + productName
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total;

            // Step 7: Show the message in a popup box
            JOptionPane.showMessageDialog(this, message);

            // Step 8: Save all the same info to data.txt - Q2.3
            // FileWriter creates the file if it does not exist
            FileWriter fileWriter = new FileWriter("data.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Write the lines exactly like the sample data.txt
            writer.write("DATA LOG");
            writer.newLine();
            writer.write("*******************************");
            writer.newLine();
            writer.write("Customer Name: " + customerName);
            writer.newLine();
            writer.write("Product: " + productName);
            writer.newLine();
            writer.write("VAT: R " + vat);
            writer.newLine();
            writer.write("COMMISSION: R " + commission);
            writer.newLine();
            writer.write("TOTAL: R " + total);
            writer.newLine();
            writer.write("*******************************");

            // Close the file so it saves properly
            writer.close();

        } catch (NumberFormatException ex) {
            // This happens if the user types letters in the price box
            JOptionPane.showMessageDialog(this, "Please enter a valid price number.");
        } catch (IOException ex) {
            // This happens if data.txt cannot be created
            JOptionPane.showMessageDialog(this, "Error saving to data.txt");
        }
    }

    // This method clears the form - Q2.4 Clear menu
    private void clearForm() {
        // Clear both text boxes
        txtCustomerName.setText("");
        txtPrice.setText("");
        // Set the combo box back to the first product, index 0
        cmbProduct.setSelectedIndex(0);
    }

    // This method runs whenever a button or menu item is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        // If PROCESS button OR Tools > Process menu was clicked
        if (e.getSource() == btnProcess || e.getSource() == mnuProcess) {
            // Call the same process method
            processSale();
        }
        // If Tools > Clear menu was clicked
        else if (e.getSource() == mnuClear) {
            clearForm();
        }
        // If File > Exit menu was clicked
        else if (e.getSource() == mnuExit) {
            // Close the application
            System.exit(0);
        }
    }

    // Main method - this starts the app
    public static void main(String[] args) {
        // Create a new ProductApp window
        new ProductApp();
    }
}