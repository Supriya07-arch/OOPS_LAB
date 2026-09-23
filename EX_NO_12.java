import java.util.ArrayList;
import java.util.Scanner;
class Medicine {
int id;
String name;
double price;
int quantity;
Medicine(int id, String name, double price, int quantity) {
this.id = id;
this.name = name;
this.price = price;
this.quantity = quantity;
}
}
public class PharmacyManagementSystem {
static ArrayList<Medicine> medicines = new ArrayList<>();
static Scanner sc = new Scanner(System.in);
// Add Medicine
static void addMedicine() {
System.out.print("Enter Medicine ID: ");
int id = sc.nextInt();
sc.nextLine();
System.out.print("Enter Medicine Name: ");
String name = sc.nextLine();
System.out.print("Enter Price: ");
double price = sc.nextDouble();
System.out.print("Enter Quantity: ");
int quantity = sc.nextInt();

medicines.add(new Medicine(id, name, price, quantity));
System.out.println("Medicine added successfully!");
}
// View Medicines
static void viewMedicines() {
if (medicines.isEmpty()) {
System.out.println("No medicines available.");
return;
}
System.out.println("\n----- Medicine List -----");
for (Medicine m : medicines) {
System.out.println("ID : " + m.id);
System.out.println("Name : " + m.name);
System.out.println("Price : Rs." + m.price);
System.out.println("Quantity : " + m.quantity);
System.out.println("-------------------------");
}
}
// Search Medicine
static void searchMedicine() {
sc.nextLine();
System.out.print("Enter medicine name to search: ");
String searchName = sc.nextLine();
boolean found = false;
for (Medicine m : medicines) {
if (m.name.equalsIgnoreCase(searchName)) {
System.out.println("\nMedicine Found!");

System.out.println("ID : " + m.id);
System.out.println("Name : " + m.name);
System.out.println("Price : Rs." + m.price);
System.out.println("Quantity : " + m.quantity);
found = true;
}
}
if (!found) {
System.out.println("Medicine not found.");
}
}
// Buy Medicine
static void buyMedicine() {
System.out.print("Enter Medicine ID: ");
int id = sc.nextInt();
Medicine selectedMedicine = null;
for (Medicine m : medicines) {
if (m.id == id) {
selectedMedicine = m;
break;
}
}
if (selectedMedicine == null) {
System.out.println("Medicine not found.");
return;
}
System.out.print("Enter quantity: ");
int quantity = sc.nextInt();
if (quantity <= 0) {
System.out.println("Invalid quantity.");

return;
}
if (quantity > selectedMedicine.quantity) {
System.out.println("Insufficient stock.");
return;
}
double total = quantity * selectedMedicine.price;
selectedMedicine.quantity =
selectedMedicine.quantity - quantity;
System.out.println("\n========== BILL ==========");
System.out.println("Medicine : " + selectedMedicine.name);
System.out.println("Quantity : " + quantity);
System.out.println("Price : Rs." + selectedMedicine.price);
System.out.println("--------------------------");
System.out.println("Total : Rs." + total);
System.out.println("==========================");
System.out.println("Purchase successful!");
}
// Delete Medicine
static void deleteMedicine() {
System.out.print("Enter Medicine ID to delete: ");
int id = sc.nextInt();
Medicine medicineToDelete = null;
for (Medicine m : medicines) {
if (m.id == id) {
medicineToDelete = m;
break;
}
}

if (medicineToDelete != null) {
medicines.remove(medicineToDelete);
System.out.println("Medicine deleted successfully!");
} else {
System.out.println("Medicine not found.");
}
}
// Main Method
public static void main(String[] args) {
// Sample medicines
medicines.add(
new Medicine(101, "Paracetamol", 5.0, 50)
);
medicines.add(
new Medicine(102, "Cetirizine", 3.0, 30)
);
medicines.add(
new Medicine(103, "Vitamin C", 10.0, 40)
);
int choice;
do {
System.out.println("\n================================");
System.out.println(" PHARMACY MANAGEMENT SYSTEM");
System.out.println("================================");
System.out.println("1. Add Medicine");
System.out.println("2. View Medicines");
System.out.println("3. Search Medicine");
System.out.println("4. Buy Medicine");

System.out.println("5. Delete Medicine");
System.out.println("6. Exit");
System.out.print("\nEnter your choice: ");
choice = sc.nextInt();
switch (choice) {
case 1:
addMedicine();
break;
case 2:
viewMedicines();
break;
case 3:
searchMedicine();
break;
case 4:
buyMedicine();
break;
case 5:
deleteMedicine();
break;
case 6:
System.out.println(
"Thank you for using Pharmacy Management System!"
);
break;
default:
System.out.println("Invalid choice.");
}
} while (choice != 6);

sc.close();
}
}
