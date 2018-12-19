import java.util.*;
public class Tugas{

	public static void main(String [] args){
		menu();
	}

	static void menu(){
		Scanner scan = new Scanner(System.in);
		int choose = 0;
		String name="";
		do {

			System.out.println("1. Name");
			System.out.println("2. Menu 2");
			System.out.println("3. Menu 3");
			System.out.println("4. Menu 4");
			System.out.println("5. Menu 5");
			System.out.println("6. Exit");
			System.out.print("Choose menu:");

			choose = scan.nextInt();
			scan.nextLine();

			switch(choose){
				case 1:
					do {
						System.out.println("Budi");
					}while(name.equals("Budi"));
				break;
			}

		}while(choose != 6);
	}

	public void clearScreen() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
