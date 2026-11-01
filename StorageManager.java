// package storage;

import java.util.List;

public class StorageManager {
    private String filePath;

    public StorageManager(String filePath) {
        this.filePath = filePath;
    }

    // Session 1 Placeholder
    public void saveProducts(List<Object> products) throws StoreException {
        System.out.println("Saving to " + this.filePath);
    }

    public List<Object> loadProducts() throws StoreException {
        System.out.println("Loading from " + this.filePath);
        return null;
    }
}