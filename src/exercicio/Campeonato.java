package exercicio;
import java.util.*; 


public class Campeonato {

	static Clube[] clubes = new Clube[5];

	static void jogarCampionato() {
		int partidas = 1;
		System.out.println("             Começou CAMPIONATO                 ");
		
		for (int i = 0; i<5; i++) { // criando os objetos de cada espaco do vetor
			Campeonato.clubes[i] = new Clube();
		}
		
		Campeonato.clubes[0].nome = "Brasil";
		Campeonato.clubes[1].nome = "Argentina";
		Campeonato.clubes[2].nome = "Peru";
		Campeonato.clubes[3].nome = "Colômbia";
		Campeonato.clubes[4].nome = "Equador";
		
		for (int i = 0; i<5; i++) { 
			for (int j = i+1; j<5; j++) { 
				System.out.format("Partida de numero %d ----- ",partidas);
				jogarPartida(Campeonato.clubes[i],Campeonato.clubes[j]);
				partidas++;
			}
		}
		getCampeao();
		
	}	
	
/* Para cada partida, o método jogarCampeonato deverá chamar seu método auxiliar jogarPartida, 
 * que irá sortear um placar como sendo dois inteiros entre 0 e 5 e vai verificar o resultado,
 *  chamando os respectivos métodos ganhar, empatar e perder dos dois clubes	
	*/
	static void jogarPartida(Clube n, Clube v) {

		Random random = new Random();        
        int resultado_n = random.nextInt(5)+1;  
        int resultado_v = random.nextInt(5)+1;
        int saldoGols = resultado_n - resultado_v;
        
	        if (saldoGols > 0) {
	        	n.ganhar(saldoGols);
	        	System.out.format("(%d)%s X %s(%d) %d GANHOU\n ",resultado_n,n.nome,v.nome,resultado_v,saldoGols);
	        }
	        else if (saldoGols < 0) {
	        	n.perder(saldoGols);
	        	System.out.format("(%d)%s X %s(%d) %d PERDEU\n",resultado_n,n.nome,v.nome,resultado_v,saldoGols);
	        }
	        else {
	        	n.empatar();
	        	System.out.format("(%d)%s X %s(%d) %d EMPATOU\n ",resultado_n,n.nome,v.nome,resultado_v,saldoGols);
	        }
	        
	        
	        
	}
	
//Ao final da execução do campeonato o método auxiliar getCampeao deverá ser chamado para retornar o clube campeão. Fique à vontade para escolher como implementar getcampeao de acordo com as regras descritas acima.

	static void getCampeao() {
		int maior = 0;
		int indice = 0;
		int[] indiceEmpates = new int[5];
		
		for (int i = 0; i < 5; i++) {
			if (Campeonato.clubes[i].pontos > maior) {
				maior = Campeonato.clubes[i].pontos;
				indice = i;
			}
			else if (Campeonato.clubes[i].pontos == maior) {
				indiceEmpates[i] = i;
			}
			
		}
		
		
		System.out.format("Brasil com %d pontos\t",Campeonato.clubes[0].pontos);
		System.out.format("Argentina com %d pontos\t",Campeonato.clubes[1].pontos);
		System.out.format("Peru com %d pontos\t",Campeonato.clubes[2].pontos);
		System.out.format("Colômbia com %d pontos\t",Campeonato.clubes[3].pontos);
		System.out.format("Equador com %d pontos\t",Campeonato.clubes[4].pontos);
		
		System.out.format("\nO VENCEDOR É %s com %d pontos\n",Campeonato.clubes[indice].nome,Campeonato.clubes[indice].pontos);
	}
	
}

