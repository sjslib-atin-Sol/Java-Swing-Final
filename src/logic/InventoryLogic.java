package logic;

import java.util.ArrayList;
import model.Product;

public class InventoryLogic {

    private ArrayList<Product> products;

    public InventoryLogic() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

}
