import java.util.*;
import java.util.Collection;
// import jdk.nashorn.internal.parser.Scanner;


public class Tugas {
    // Item details
    static Vector<String> productSKU = new Vector<>();
    static Vector<String> productName = new Vector<>();
    static Vector<Integer> productPrice = new Vector<>();

    // Order details
    static Vector<Integer> vorderId = new Vector<>();
    static Vector<String> vname = new Vector<>();
    static Vector<String> vorder = new Vector<>();
    static Vector<Integer> vquantity = new Vector<>();
    static Vector<Integer> vtotal = new Vector<>();

    public static void main(String [] args){
        //  Initialize dummy items.
        initItems();
        createDummyOrders( 10 );

        //  Show menu.
        menu();

    }

    static void initItems() {

        productSKU.add("A2");
        productName.add("Hoodie jumper");
        productPrice.add(92000);

        productSKU.add("B2");
        productName.add("Hoodie zipper");
        productPrice.add(100000);

        productSKU.add("C2");
        productName.add("Basic sweater");
        productPrice.add(86000);

        productSKU.add("D3"); // alphabet is type of jacket, numeric is type of materials //
        productName.add("Boomber jacket");
        productPrice.add(75000);

    }

    static void createDummyOrders( int dummyQuantity ) {

        for ( int i = 0; i <= dummyQuantity; i++ ) {
            Random random = new Random();

            String name = getSaltString();
            String order = productSKU.get(( random.nextInt(3 - 0 + 1) + 0 ));
            int quantity = random.nextInt(10 - 1 + 1) + 1;

            createOrder( name, order, quantity);
        }

    }

    // Just random some string.
    static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    static void menu(){
        Scanner scan = new Scanner(System.in);
        int choose = 0;
        do {

            System.out.println("               ========================*========================");
            System.out.println("               |             THIS IS LABELLECLOTHING           | ");
            System.out.println("               ========================*========================");

            System.out.println("1. List of product.");
            System.out.println("2. Add order.");
            System.out.println("3. List order.");
            System.out.println("4. Update order.");
            System.out.println("5. Checkout.");
            System.out.println("6. Exit.");
            System.out.print("Choose menu:");

            try {
                choose = scan.nextInt();

	            System.out.println();

	            switch(choose){
	                case 1:
	                    System.out.println("List Product.");
	                    listProduct();
	                break;
	                case 2:
	                    System.out.println("Add Order.");
	                    addOrder();
	                break;
	                case 3:
	                    String sort = "ASC_ID";
	                    System.out.println("List Order.");
	                    Scanner scanSubMenu = new Scanner(System.in);
	                    int chooseSubMenu = 1;

	                    do {
	                        switch(chooseSubMenu) {
	                            case 1:
	                                sort = "ASC_ID";
	                                break;
	                            case 2:
	                                sort = "DESC_ID";
	                                break;
	                            case 3:
	                                sort = "ASC_TOTAL";
	                                break;
	                            case 4:
	                                sort = "DESC_TOTAL";
	                                break;
	                            default:
	                                sort = "ASC_ID";
	                                break;
	                        }

	                        listOrders(sort);
	                        System.out.println("1. Sort ASC by ID.");
	                        System.out.println("2. Sort DESC by ID.");
	                        System.out.println("3. Sort ASC by Total.");
	                        System.out.println("4. Sort DESC by Total.");
	                        System.out.println("5. Exit.");
	                        System.out.print("Choose Submenu:");
	                        chooseSubMenu = scanSubMenu.nextInt();
	                    } while ( chooseSubMenu != 5 );
	                break;
	                case 4:
                    delete();
	                break;
	                case 5:
                    payment();
	                break;
	            }

			} catch ( InputMismatchException e ) {}

            clearScreen();

        } while( choose != 6 );

        scan.close();

    }

    //  List all products
    static void listProduct(){

        System.out.println();

        for ( int i = 0; i < productName.size(); i++ ){
            if (i == 0) {
                System.out.println("= = = = = = = = = = = = = =");
            }
            System.out.println("SKU  : " + productSKU.get(i));
            System.out.println("Name : " + productName.get(i));
            System.out.println("Price: " + productPrice.get(i));
            System.out.println( (i == productName.size() - 1) ? "= = = = = = = = = = = = = =" : "- - - - - - - - - - - - - -" );
            // expl ? --> Ternary is subtitute of 'if else' i == etc usually in 'else' you just have to add ? in the end //
        }

    }

    static void addOrder(){

        Scanner scan = new Scanner(System.in);

        String name, order;
        int quantity = 0;
        int total = 0;


        do {
            System.out.print("Input name [3..30 character]:");
            name = scan.nextLine();
        } while( name.length() < 3 || name.length() > 30 );


        do {
			listProduct();
            System.out.print("Input item SKU:");
            order = scan.nextLine();
        } while( ! isSkuExist(order) );

        do {
            try{
                System.out.print("Input Quantity [1..25(must be numeric)]:");
                quantity = scan.nextInt(); scan.nextLine();
            }catch(Exception e){
                quantity = 0;
            } scan.nextLine();
        } while( quantity < 1 || quantity > 25 );

        //  Count total
        total = quantity * productPrice.get( productSKU.indexOf(order) );

        System.out.println("Total Price: "+total);

        createOrder(name,order,quantity);
    }

    static void createOrder( String name, String order, int quantity ) {

        int total = quantity * productPrice.get( productSKU.indexOf(order) );

        vorderId.add((vname.size() + 1));
        vname.add(name);
        vorder.add(order);
        vquantity.add(quantity);
        vtotal.add(total);

    }

    //  List all orders
    static void listOrders( String sort ){

        //  Create order ID clone.
        Vector<Integer>listedOrderId = new Vector<>();
                       listedOrderId = (Vector) vorderId.clone();
        Vector<Integer>listedOrderTotal = new Vector<>();
                       listedOrderTotal = (Vector)vtotal.clone();

        String sortName = "";

        switch (sort) {
            case "ASC_ID":
                sortName = "ID Ascending.";
                Collections.sort(listedOrderId);
                break;

            case "DESC_ID":
                sortName = "ID Descending.";
                Collections.sort(listedOrderId, Collections.reverseOrder());
                break;

            case "ASC_TOTAL":
                sortName = "Total Ascending.";
                //  Bubble sort ascending total.
                int n = vtotal.size();
                int tempTotal = 0;
                int tempID = 0;
                for(int i=0; i < n; i++){
                    for(int j=1; j < (n-i); j++){
                        if(listedOrderTotal.get(j-1) > listedOrderTotal.get(j)){
                            //swap elements
                            tempID = listedOrderId.get(j-1);
                            tempTotal = listedOrderTotal.get(j-1);

                            listedOrderId.set(j-1, listedOrderId.get(j));
                            listedOrderTotal.set(j-1, listedOrderTotal.get(j));

                            listedOrderId.set(j, tempID);
                            listedOrderTotal.set(j, tempTotal);
                        }
                    }
                }
                break;

            case "DESC_TOTAL":
                sortName = "Total Ascending.";
                //  Bubble sort descending total.
                int x = vtotal.size();
                int tempTotal2 = 0;
                int tempID2 = 0;
                for(int i=0; i < x; i++){
                    for(int j=1; j < (x-i); j++){
                        if(listedOrderTotal.get(j-1) < listedOrderTotal.get(j)){
                            //swap elements
                            tempID2 = listedOrderId.get(j-1);
                            tempTotal2 = listedOrderTotal.get(j-1);

                            listedOrderId.set(j-1, listedOrderId.get(j));
                            listedOrderTotal.set(j-1, listedOrderTotal.get(j));

                            listedOrderId.set(j, tempID2);
                            listedOrderTotal.set(j, tempTotal2);
                        }
                    }
                }
                break;
        }

        System.out.println();
        System.out.println("Sort by: " + sortName);

        for ( int i = 0; i < listedOrderId.size(); i++ ){
            if (i == 0) {
                System.out.println("= = = = = = = = = = = = = =");
            }

            int index = listedOrderId.get(i) - 1;
            System.out.println( "Order #" + listedOrderId.get(i) );
            System.out.println( "- - - - - - - - - - - - - - - -" );
            System.out.println( "Name    :" + vname.get(index) );
            System.out.println( "Order   :" + vorder.get(index) );
            System.out.println( "Quantity:" + vquantity.get(index) );
            System.out.println( "Total   :" + vtotal.get(index) );
            System.out.println( (i == vname.size() - 1) ? "= = = = = = = = = = = = = =" : "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n" );
        }

    }

    static boolean isSkuExist( String SKU ) {

        return ( productSKU.indexOf(SKU) < 0 ? false : true );

    }

    //  Jump a few lines to clear the screen.
    static void clearScreen() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scan= new Scanner(System.in);
        scan.nextLine();
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    static void delete(){
        Vector<Integer> listedOrderId = new Vector<>();
                        listedOrderId = (Vector) vorderId.clone();
        // Vector<Integer> listedOrderTotal = new Vector<>();
        //                 listedOrderTotal = (Vector) vtotal.clone();
        Scanner scan = new Scanner(System.in);

        int temp = -1;
        if(vname.size()==0){
			System.out.println("No data!");
		}

		for(int i = 0;i<vname.size();i++){
        	int index = listedOrderId.get(i) - 1;
            System.out.println("Order #" + listedOrderId.get(i));
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.println("Name    :" + vname.get(index));
            System.out.println("Order   :" + vorder.get(index));
            System.out.println("Quantity:" + vquantity.get(index));
            System.out.println("Total   :" + vtotal.get(index));
            System.out.println( (i == vname.size() - 1) ? "= = = = = = = = = = = = = =" : "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n" );
		}
			System.out.println("Input number to be delete");
			temp = scan.nextInt();
            scan.nextLine();

			if (temp == 0){

			}

			else{
				vorderId.remove(temp-1);
				vname.remove(temp-1);
				vorder.remove(temp-1);
				vquantity.remove(temp-1);
				vtotal.remove(temp-1);
				System.out.println("data has been deleted");
			}

    }

    static void payment(){
        Scanner scan = new Scanner(System.in);
        String bank;
        String phone = "";
        String address;
        String kodebca = "0001";
        String kodemandiri = "00022";
        String kodebni = "00033";
        int jumlah = 0;
        boolean phone_state = true;

        for ( int i = 0; i < vname.size(); i++ ){
            System.out.println("Order #" + vorderId.get(i));
            System.out.println("Name    :" + vname.get(i));
            System.out.println("Order   :" + vorder.get(i));
            System.out.println("Quantity:" + vquantity.get(i));
            System.out.println("Total   :" + vtotal.get(i));
            jumlah += vtotal.get(i);
        }

        // masukan nomor telepon
        do {
            System.out.print("Input phone [12 digit]:");
            phone = scan.nextLine();
            for (int i = 1; i < phone.length(); i++) {
                if (Character.isDigit(phone.charAt(i))) {
                    phone_state = false;
                } else {
                    phone_state = true;
                    break;
                }
            }
        } while (phone.length() != 12 || phone_state);

        do {
            System.out.print("Input Address [must ends with 'Street']:");
            address = scan.nextLine();
        } while (!address.endsWith("Street"));

        System.out.println("Total Pembayaran ; " + jumlah);

        do{
            System.out.print("Pilih Bank [BCA | MANDIRI | BNI]");
            bank = scan.nextLine();

            if(bank.equals("BCA")){
                System.out.println("Virtual Account ="+ kodebca + phone );
            }
            else if(bank.equals("MANDIRI")){
                System.out.println("Virtual Account ="  + kodemandiri);
            }
            else if(bank.equals("BNI")){
                System.out.println("Virtual Account =" + kodebni);
            }
        }while(!bank.equalsIgnoreCase("BCA") && !bank.equalsIgnoreCase("MANDIRI") && !bank.equalsIgnoreCase("BNI"));
        System.out.println("Due Date = 24 jam x 2");

        clearScreen();
    }
}
