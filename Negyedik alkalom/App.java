public class App {
    
    private static final String FILE = "REK.DAT";
    public static void main(String[] args) throws Exception {

        // Initializing the Repository array, containing the products I store in the binary file.
        Repository[] repos = {new Repository("Screw Warehouse", 
                                            3, 
                                            2, 
                                            1, 
                              new Product[]{
                                new Product(
                                    "Lead-screw", 
                                    12), 
                                new Product(
                                    "Wood-screw", 
                                    10)}),
                                new Repository("Fruit storage", 
                                                13, 
                                              80, 
                                               0, 
                                new Product[]{(
                                new Product(
                                    "Raspberry",
                                    20))})}; 
        
        // Writing the first Product to the binary file
        Repository.writeData(FILE, repos[0].getProducts()[0].toString(), 5);
        
        // Reading the first Product from the binary file
        System.out.println("Product:\n" + new String(Repository.readData(FILE, 1, 10000)));

        // Appending the second Product to the binary file
        System.out.println("\nContents after appending the second and the thids products:\n");
        Repository.appendData(FILE, "\n" + repos[0].getProducts()[1].toString());
        Repository.appendData(FILE, "\n" + repos[1].getProducts()[0].toString());

        // Reading the second Product from the binary file
        System.out.println(new String(Repository.readData(FILE, 1, 10000)));

        // Deleting the first Product from the binary file
        System.out.println("\nContents after deleting the first product:");
        Repository.deleteData(FILE, repos[0].getProducts()[0].toString());
        System.out.println(new String(Repository.readData(FILE, 1, 10000)));
    }
}
