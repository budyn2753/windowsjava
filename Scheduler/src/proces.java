import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.Scanner;



public class proces {
	public int id, kwant, priorytet, priorytet_bazowy, czas_przyjscia;
	public Boolean koniec = false;
	public int rozmiar;
	public int czas = 0;
	
	public proces(int priorytet, int czas, int rozmiar, int id){
		this.priorytet = priorytet;
		this.czas= czas;
		this.rozmiar = rozmiar;
		this.id = id;
		this.kwant = 1;
		this.priorytet_bazowy = priorytet;
	}
	
	public int getCzasPrzyjscia(){
		return this.czas_przyjscia;
	}
	public int getPriorytet(){
		return this.priorytet;
	}
	
	public void run(){
		rozmiar = rozmiar - kwant;
		czas_przyjscia = czas;
		System.out.println("Proces: "+id+" Priorytet: "+priorytet);
		
		if (kwant == 2){
			System.out.println("G³odzony proces: przydzielony czas 2 kwanty. ");
			kwant =1;
		}
		if (rozmiar<=0){
			rozmiar = 0;
			koniec = true;
			System.out.println("Zakoñczy³ swoje dzia³anie. ");
					
		}
		else {
			System.out.println("Pozosta³y czas: "+rozmiar);
			System.out.println(" ");
		}
	}
public static Boolean NiePustaKolejka[];
public ArrayList<proces> KolejkaGotowychProcesow = new ArrayList<proces>();
public ArrayList<proces>KolejkaProcesow= new ArrayList<proces>();
public static ArrayList<List<proces>> tab = new ArrayList<List<proces>>();
public ListIterator it ;
public int ZnajdzMaxPriorytet(){
	
	for (int i =15; i>0;i--){
		if(NiePustaKolejka[i]=true){
			return i;
		}
	}
	return -1;	
}
public static void SetZeroBitTab(){
	for(int i = 15;i>0;i--){
		if (tab.get(i).isEmpty()){
			NiePustaKolejka[i]= false;
		}else{
			NiePustaKolejka[i]= true;
		}
	}
}

public void SetZeroBitTabPriority(int p){
	if (tab.get(p).isEmpty()){
		NiePustaKolejka[p] = false;
	}else{
		NiePustaKolejka[p]= true;
	}
}
public static void NowyProces(int priorytet, int rozmiar, int id, int czasPrzyjscia){
	proces e = new proces(priorytet, czasPrzyjscia,rozmiar,id);
	tab.get(priorytet).add(e);
	SetZeroBitTab();
}
public static void WyswietlListe(){
	
	System.out.println();
	for (int i = 15; i > 0; i--){
		//it =  tab.listIterator();
		System.out.println("PRIORYTET: "+i);
		for (int x=0;x<=tab.get(i).size();x++){			
			System.out.println("Proces: "+tab.get(i).get(x).id+"  Priorytet: "+tab.get(i).get(x).priorytet+" Pozostaly czas:  " +tab.get(i).get(x).czas);
		}
		}
	System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int balans =0;
		int time = 0;
		
		int id = 0;
		Scanner scan = new Scanner(System.in);
		int prio, size, klaw;
		
		while(true){
			System.out.println("1: Dodaj proces, 2 : wyswietl liste, 3: nastepny krok: ");
			klaw = scan.nextInt();
			switch (klaw){
			case 1: {
				System.out.print("Podaj priorytet: ");
				prio = scan.nextInt();
				System.out.print("Podaj dlugosc procesu: ");
				size = scan.nextInt();
				NowyProces(prio,size,id,time);
				time++;
				id++;
				break;
				}
			case 2: {
				WyswietlListe();
			}
			}
		}

	}

}
