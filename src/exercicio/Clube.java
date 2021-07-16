package exercicio;

public class Clube {
	
	String nome; //NOME DO CLUBE
	int pontos = 0; //PONTOS DO CLUBE
	int saldoGols = 0; // gols feitos - gols sofridos

	  void ganhar(int saldoGols) { //vale 3 pontos
			this.saldoGols += saldoGols; //acumula no saldoGols ja existente
			pontos += 3;
	}
	
	 void empatar() { //vale 1 ponto
		this.pontos = 1;
	}
	
	 void perder(int saldoGols) { //nao vale nada
		this.saldoGols += saldoGols; //diminui no saldoGols ja existente
		this.pontos += 0;	
	}

}
