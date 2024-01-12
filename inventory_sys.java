import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String name, int quantity) {
        items.put(name, quantity);
        System.out.println("Item '" + name + "' added to inventory with quantity " + quantity);
    }

    public void viewInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                System.out.println("Item: " + entry.getKey() + ", Quantity: " + entry.getValue());
            }
        }
    }

    public void updateItem(String name, int quantity) {
        if (items.containsKey(name)) {
            int updatedQuantity = items.get(name) + quantity;
            items.put(name, updatedQuantity);
            System.out.println("Item '" + name + "' updated. New quantity: " + updatedQuantity);
        } else {
            System.out.println("Item '" + name + "' not found in inventory.");
        }
    }
}

public class inventory_sys{
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. ADD ITEM\n2. VIEW INVENTORY\n3. UPDATE ITEM\n4. EXIT");
            System.out.print("ENTER YOUR CHOICE : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("ENTER ITEM NAME : ");
                    String itemName = scanner.nextLine();
                    System.out.print("ENTER QUANTITY : ");
                    int quantity = scanner.nextInt();
                    inventory.addItem(itemName, quantity);
                    break;
                case 2:
                    inventory.viewInventory();
                    break;
                case 3:
                    System.out.print("ENTER ITEM NAME TO UPDATE : ");
                    String updateItemName = scanner.nextLine();
                    System.out.print("ENTER QUANTITY TO ADD/SUBTRACT  : ");
                    int updateQuantity = scanner.nextInt();
                    inventory.updateItem(updateItemName, updateQuantity);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("EXITING...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE. PLEASE ENTER A VALID OPTION.");
                    break;
            }
        }
    }
}
