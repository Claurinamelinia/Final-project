import java.util.*;

public class Tugas{

	//	Item details
	static Vector<String>productSKU = new Vector<>();
	static Vector<String>productName = new Vector<>();
	static Vector<Integer>productPrice = new Vector<>();

	public static void main(String [] args){

		//	Initialize dummy items.
		initItems();

		//	Show menu.
		menu();

	}

	static void initItems() {

		productSKU.add("");
		productName.add("Hoodie jumper");
		productPrice.add(92000);

		productSKU.add("");
		productName.add("Hoodie jumper");
		productPrice.add(100000);

		productSKU.add("");
		productName.add("Hoodie jumper");
		productPrice.add(86000);

		productSKU.add("");
		productName.add("Hoodie jumper");
		productPrice.add(75000);

	}

	static void form(){
		Scanner scan = new Scanner(System.in);
		Vector<String>vname = new Vector<>();
		Vector<String>vphone = new Vector<>();
		Vector<String>vaddress = new Vector<>();
		Vector<String>vorder = new Vector<>();
		Vector<Integer>vquantity = new Vector<>();
		Vector<Integer>vprices = new Vector<>();
		Vector<Integer>vtotal = new Vector<>();

		String name, address, order, phone ="";
		int quantity = 0;
		boolean phone_state = true;
		int prices = 0;
		int total = 0;

		do {
			System.out.print("Input name [3..30 character]:");
			name = scan.nextLine();
		}while(name.length() < 3 || name.length() > 30);

		do {
			System.out.print("Input phone [12 digit]:");
			phone = scan.nextLine();
			for(int i = 1; i < phone.length(); i++){
				if(Character.isDigit(phone.charAt(i))){
					phone_state = false;
				}else{
					phone_state = true;
					break;
				}
			}
		}while(phone.length() != 12 || phone_state);

		do {
			System.out.print("Input Address [must ends with 'Street']:");
			address = scan.nextLine();
		}while(!address.endsWith("Street"));

		do {
			System.out.print("Input order [Hoodie jumper | Hoodie Zipper | Basic sweater | Boomber jacket]:");
			order = scan.nextLine();
		}while(!order.equals("Hoodie jumper") && !order.equals("Hoodie zipper") && !order.equals("Basic sweater") && !order.equals("Boomber jacket"));

		do {
			try{
				System.out.print("Input Quantity [1..25(must be numeric)]:");
				quantity = scan.nextInt(); scan.nextLine();
			}catch(Exception e){
				quantity = 0;
			}
		}while(quantity < 1 || quantity > 25);

		if(order.equals("Hoodie jumper"))total = quantity * 92000;
		else if (order.equals("Hoodie zipper"))total = quantity * 100000;
		else if(order.equals("Basic sweater"))total = quantity * 86000;
		else if (order.equals("Boomber jacket"))total = quantity * 75000;

		System.out.println("Total Price"+total);


		vname.add(name);
		vphone.add(phone);
		vaddress.add(address);
		vorder.add(order);
		vquantity.add(quantity);
		vprices.add(prices);
		vtotal.add(total);

	}

	//	List all products
    static void listProduct(){

		System.out.println();

		System.out.println("List Product");

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

	static void menu(){
		Scanner scan = new Scanner(System.in);
		int choose = 0;
		String name="";
		do {

			System.out.println("               ========================*========================");
			System.out.println("               |             THIS IS LABELLECLOTHING           | ");
			System.out.println("               ========================*========================");

			System.out.println("1. List of Product");
			System.out.println("2. Order form");
			System.out.println("3. Canceling ");
			System.out.println("4. Checkout");
			System.out.println("5. Payment");
			System.out.println("6. Exit");
			System.out.print("Choose menu:");

			choose = scan.nextInt();


			switch(choose){
				case 1:
					listProduct();
				break;
				case 2:
					form();
				break;
				case 3:
				break;
				case 4:
				break;
				case 5:
				break;
			}


				String x = scan.nextLine();
				clearScreen();

		}while(choose != 6);
	}

	//	Jump a few lines to clear the screen.
	static void clearScreen() {
		System.out.println("Press \"ENTER\" to continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
