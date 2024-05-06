package org.generation.italy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int limiteVelocità,velocitàRilevata, tolleranza, eccesso, sanzione;
		String risposta;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Calcolo sanzioni autovelox\n\n");	// mostro il titolo e vado a capo 2 volte (\n)
		
		System.out.print("Inserire il limite di velocità (da 1 a 250): ");
		limiteVelocità=sc.nextInt();
		sc.nextLine();
		
			
		do {
			System.out.print("Inserire la velocità rilevata: ");
			velocitàRilevata=sc.nextInt();
			sc.nextLine();
			
			if (velocitàRilevata<0) 
				System.out.println("Velocità non valida, reinserire.");
			else {			
				if (velocitàRilevata<100)
					tolleranza=5;	// km/h
				else
					tolleranza=velocitàRilevata*5/100;   // km/h
				
				System.out.println("Tolleranza: "+tolleranza);
				eccesso=velocitàRilevata-tolleranza-limiteVelocità;
				
				if (eccesso<=0) 
					sanzione=0;
				else if (eccesso<10)	//tra 1 e 9:	sanzione è da 42 a 173
					sanzione=42+(eccesso-1)*(173-42)/8;
					//eccesso=1  =>   42+0*(.....)  = 42
					//eccesso=9	 =>   42+8*(.....)/8 =42+(173-42)=173
				else if (eccesso<40)	//tra 10 e 39:	sanzione è da 173 a 694
					sanzione=173+(eccesso-10)*(694-173)/29;
				else if (eccesso<60)	//tra 40 e 59:	sanzione è da 543 a 2170
					sanzione=543+(eccesso-40)*(2170-543)/19;
				else 	{				//oltre i 60: sanzione da 845 a 3382 					
					sanzione=845+(eccesso-40)*(3382-845)/59;
					if (sanzione >3382)
						sanzione=3382;						
				}
				System.out.println("Sanzione: "+sanzione);				
				
			}
			System.out.print("Vuoi inserire un'altra rilevazione (s/n)? ");
			risposta=sc.nextLine();
		} while(risposta.substring(0, 1).toLowerCase().equals("s"));
		System.out.println("Arrivederci!");
		sc.close();
	}
}
