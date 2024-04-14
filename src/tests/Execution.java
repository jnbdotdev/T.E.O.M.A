package tests;

import java.util.Scanner;
import backend.Person;


public class Execution {

	public static void main(String[] args) {
	
		
	}

	public static void creation() {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite a estatura: ");
		double stature = sc2.nextDouble();
		System.out.println("Digite a idade: ");
		int age = sc2.nextInt();
		System.out.println("Digite o poder: ");
		int power = sc2.nextInt();
		System.out.println("Digite a mana: ");
		int mana = sc2.nextInt();
		System.out.println("Digite o poder principal: ");
		String ppower = sc.nextLine();
		System.out.println("Digite o ataque principal: ");
		String patack = sc.nextLine();
		System.out.println("Digite o P.A.T: ");
		String pat = sc.nextLine();
		System.out.println("Digite o tipo: ");
		String type = sc.nextLine();
		System.out.println("Digite a raridade: ");
		String rarity = sc.nextLine();
		System.out.println("Digite o level: ");
		int mlevel = sc2.nextInt();
		
		Person pp = new Person(nome, stature, age, power, mana, ppower, patack, pat, type, rarity, mlevel);
		pp.savePerson();
		
		String option;
		System.out.print("Deseja ler o arquivo de personagem? [s/n]");
		option = sc.next();
		if(option.equals("s")) {
			
		}
		sc.close();
		sc2.close();
	}
	

}
