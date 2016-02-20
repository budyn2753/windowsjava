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
		return this.czas;
	}
	public int getPriorytet(){
		return this.priorytet;
	}
	public int getID(){
		return this.id;
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
public static Boolean NiePustaKolejka[] = new Boolean[16];
public ArrayList<proces> KolejkaGotowychProcesow = new ArrayList<proces>();
//public ArrayList<proces>KolejkaProcesow= new ArrayList<proces>();
public static ArrayList<List<proces>> tab ;
static ArrayList<proces> group[] = new ArrayList[16];
public static ListIterator it ;
public static int ZnajdzMaxPriorytet(){
	
	for (int i =15; i>0;i--){
		if(NiePustaKolejka[i]=true){
			return i;
		}
	}
	return -1;	
}
public static void SetZeroBitTab(){
	for(int i = 15;i>0;i--){
		if (group[i].isEmpty()){
			NiePustaKolejka[i]= false;
		}else{
			NiePustaKolejka[i]= true;
		}
	}
}

public static void SetZeroBitTabPriority(int p){
	if (group[p].isEmpty()){
		NiePustaKolejka[p] = false;
	}else{
		NiePustaKolejka[p]= true;
	}
}
public static void NowyProces(int id,int priorytet,int czasPrzyjscia, int rozmiar){
	//tab.
	proces e = new proces(priorytet, czasPrzyjscia,rozmiar,id);
	group[priorytet].add(e);
	SetZeroBitTab();
}
public static void init(){
	for(int i=0;i<=15;i++){
		for(int x = 0; x < group.length; x++){
	        group[x] = new ArrayList<>();
	    }
	}
}
public static void WyswietlListe(){
	
	System.out.println();
	for (int i = 15; i > 0; i--){
		if(group[i].isEmpty()){
			System.out.println("PRIORYTET: "+i);}
		else{
		for (int x=0;x<group[i].size();++x){	
			System.out.println("PRIORYTET: "+i);
			//System.out.println(group[i]);
			System.out.println("Proces: "+group[i].get(x).getID()+"  Priorytet: "+group[i].get(x).getPriorytet()+" Pozostaly czas:  " +group[i].get(x).getCzasPrzyjscia());
		}
		}
		}
	System.out.println();
	}

	public static void main(String[] args) {
		int time = 0;
		
		int id = 0;
		Scanner scan = new Scanner(System.in);
		int prio, size, klaw;
		init();
		
		while(true){
			System.out.println("1: Dodaj proces, 2 : wyswietl liste, 3: nastepny krok: ");
			klaw = scan.nextInt();
			switch (klaw){
			case 1: {
				System.out.print("Podaj priorytet: ");
				prio = scan.nextInt();
				System.out.print("Podaj dlugosc procesu: ");
				size = scan.nextInt();
				NowyProces(id,prio,size, time);
				time--;
				id++;
				break;
				}
			case 2: {
				WyswietlListe();
				break;
			}
			case 3: {
				int Priorytet = ZnajdzMaxPriorytet();
				
				if (Priorytet == -1){
					System.out.println("Brak procesow");
					break;
				}
				
				group[Priorytet].get(0).run();
				
				if(group[Priorytet].get(0).koniec ==true){
					group[Priorytet].remove(0);
					SetZeroBitTabPriority(Priorytet);
				}
				else if (group[Priorytet].get(0).priorytet != group[Priorytet].get(0).priorytet_bazowy){
					int tmp = group[Priorytet].get(0).getPriorytet();
					int tmp2 = group[Priorytet].get(0).priorytet = group[Priorytet].get(0).priorytet-1;
				}
				
				
			}
			}
		}

	}

}
