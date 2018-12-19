import java.util.*;
public class Tugas{


	static void menu(){
		Scanner scan = new Scanner(System.in);
		int choose = 0;
		do {
			System.out.println("1. Menu 1");
			System.out.println("2. Menu 2");
			System.out.println("3. Menu 3");
			System.out.println("4. Menu 4");
			System.out.println("5. Menu 5");
			System.out.println("6. Exit");

			System.out.print("Choose :");

			choose = scan.nextInt();
			scan.nextLine();
		}while(choose != 6);
	}









	public static void main(String [] args){
		menu();
	}
}