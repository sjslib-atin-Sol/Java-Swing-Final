package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainScreen extends JFrame {

    private JTextField txtProductName;
    private JTextField txtPrice;
    private JTextField txtQuantity;
    private JTextField txtSearch;

    private JTable productTable;
    private DefaultTableModel tableModel;

    private JButton btnAdd;
    private JButton btnSearch;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnReport;

    private JLabel lblStatus;

    public MainScreen() {

        setTitle("Sari-Sari Store Inventory System");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Title
        JLabel title = new JLabel(
            "SARI-SARI STORE INVENTORY SYSTEM",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 23));

        mainPanel.add(title, BorderLayout.NORTH);

        // Product input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        txtProductName = new JTextField();
        txtPrice = new JTextField();
        txtQuantity = new JTextField();

        inputPanel.add(new JLabel("Product Name:"));
        inputPanel.add(txtProductName);

        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(txtPrice);

        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(txtQuantity);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        btnAdd = new JButton("Add Product");
        btnSearch = new JButton("Search");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnReport = new JButton("Daily Report");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnReport);

        // Table
        tableModel = new DefaultTableModel(
            new String[]{"Product Name", "Price", "Quantity"}, 0
        );

        productTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(productTable);

        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Status
        lblStatus = new JLabel("System Ready");

        mainPanel.add(lblStatus, BorderLayout.SOUTH);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem reportItem = new JMenuItem("Daily Report");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(reportItem);
        menu.add(exitItem);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        // Event handlers
        exitItem.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        btnAdd.addActionListener(e -> {
            // Connect this button to your Logic package.
            lblStatus.setText("Add Product button clicked.");
        });

        btnSearch.addActionListener(e -> {
            lblStatus.setText("Search button clicked.");
        });

        btnEdit.addActionListener(e -> {
            lblStatus.setText("Edit button clicked.");
        });

        btnDelete.addActionListener(e -> {
            lblStatus.setText("Delete button clicked.");
        });

        btnReport.addActionListener(e -> {
            // Open your ReportScreen here.
            lblStatus.setText("Daily Report selected.");
        });

        reportItem.addActionListener(e -> btnReport.doClick());

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }
}
