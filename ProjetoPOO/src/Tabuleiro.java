import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private ArrayList<Posicionavel> casas;

	public Tabuleiro() {
		this.casas = new ArrayList<Posicionavel>();
	}

	public void adicionaPosicionavel() {
		this.casas.add(new Terreno("Leblon", 2, 100, 6, 30, 90, 270, 400, 500, 50, 50, 0, 6 ));
		this.casas.add(new Terreno("av. Presidente Vargas",3,60,2,10,30,90,100,250,30,50,0,2 ));
		this.casas.add(new Terreno("av. Nossa Senhora de Copacabana",4,60,2,10,30,90,100,250,30,50,0,2 ));
		this.casas.add(new Terreno("Av. Brigadeiro Faria lima",6,240,20,100,300,750,925,1100,120,150,0,20 ));
		this.casas.add(new Terreno("Av. Rebouças",8,220,18,90,250,700,875,1050,110,150,0,18 ));
		this.casas.add(new Terreno("AV. 9 de Julho",9,220,18,90,250,700,875,1050,110,150,0,18 ));
		this.casas.add(new Terreno("Av. Europa",11,200,16,80,220,600,800,1000,100,100,0,16 ));
		this.casas.add(new Terreno("Rua Augusta",13,180,14,70,200,550,750,950,90,100,0,14 ));
		this.casas.add(new Terreno("Av. Pacaembu",14,180,14,70,200,550,750,950,90,100,0,14 ));
		this.casas.add(new Terreno("Interlagos",17,350,35,175,500,1100,1300,1500,175,200,0,35 ));
		this.casas.add(new Terreno("Morumbi",19,400,50,200,600,1400,1700,2000,200,200,0,50 ));
		this.casas.add(new Terreno("Flamengo",21,120,8,40,100,300,450,600,60,50,0,8 ));
		this.casas.add(new Terreno("Botafogo",23,100,6,30,90,270,400,500,50,50,0,6 ));
		this.casas.add(new Terreno("Av. Brasil",26,160,12,60,180,500,700,900,80,100,0,12 ));
		this.casas.add(new Terreno("Av. Paulista",28,140,10,50,150,450,625,750,70,100,0,10  ));
		this.casas.add(new Terreno("Jardim Europa",29,140,12,60,180,500,700,900,80,100,0,12 ));
		this.casas.add(new Terreno("Copacabana",31,260,22,110,330,800,975,1150,130,150,0,22 ));
		this.casas.add(new Terreno("Av. Vieira Souto",33,320,28,150,450,1000,1200,1400,160,200,0,28 ));
		this.casas.add(new Terreno("Av. Atlâtica",34,300,26,130,390,900,1100,1275,150,200,0,26 ));
		this.casas.add(new Terreno("Ipanema",36,300,26,130,390,900,1100,1275,150,200,0,26 ));
		this.casas.add(new Terreno("Jardim Paulista",38,280,24,120,360,850,1025,1200,140,150,0,24 ));
		this.casas.add(new Terreno("Brooklin",39,260,22,110,330,800,975,1150,130,150,0,22 ));
		this.casas.add(new Companhia("Companhia Ferroviaria",5,200,100,50 ));
		this.casas.add(new Companhia("Companhia de Aviaçao",7,200,100,50 ));
		this.casas.add(new Companhia("Companhia de taxi",15,150,75,40 ));
		this.casas.add(new Companhia("Companhia de Navegaçao",25,150,75,40 ));
		this.casas.add(new Companhia("Companhia de Aviaçao",32,200,100,50 ));
		this.casas.add(new Companhia("Companhia de Taxi Aereo",35,200,100,50 ));
		
	}

	public ArrayList<Posicionavel> getCasas() {
		return casas;
	}

	public void setCasas(ArrayList<Posicionavel> casas) {
		this.casas = casas;
	}
	
	

}