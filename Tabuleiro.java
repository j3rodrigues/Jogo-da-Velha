public class Tabuleiro {
	private char [][] matriz = new char [3][3];
	private int linha;
	private int coluna;
	private int jogadas;
	int caso;

	Jogador j1 = new Jogador('X');
	Jogador j2 = new Jogador('O');

	Jogador jAux;

	//construtor:
	public Tabuleiro(Jogador j1, Jogador j2) {
		this.j1 = j1;
		this.j2 = j2;
	}

//inicia o tabuleiro com *
	public void reiniciarTabuleiro() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matriz[i][j] = '*';
			}
		}
	}	

//exibe o tabuleiro com o que estiver dentro da matriz
	public void exibirTabuleiro() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(matriz[i][j] + "|");
			}
			System.out.println(" ");
		}
	}
	
	public void setIniciante() {
		if (caso == 1 || caso > 2) {
			if(jogadas % 2 == 0) {
				jAux = j1;
			}else {
				jAux = j2;
			}
		} else if (caso == 2) {
			if(jogadas % 2 == 0) {
				jAux = j2;
			}else {
				jAux = j1;
			}
		}
	}
	public void jogar() {
		if (jogadas < 9) {
			System.out.println("jogada: " + (jogadas+1));
		}
		do {
			setIniciante();
			linha = jAux.escolherLinha();
			coluna = jAux.escolherColuna();
			
		} while (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || matriz[linha][coluna] != '*');
		
		matriz[linha][coluna] = jAux.getMarcador();
		jogadas++;
	}

	private char verificar() {
		for (int i = 0; i < 3; i++) {
			//linhasO
				if (matriz[i][0] == jAux.getMarcador() && matriz[i][1] == jAux.getMarcador() && matriz[i][2] == jAux.getMarcador()) {
					return jAux.getMarcador();
				}
				//colunas
				if (matriz[0][i] == jAux.getMarcador() && matriz[1][i] == jAux.getMarcador() && matriz[2][i] == jAux.getMarcador()) {
					return jAux.getMarcador();
				}
			}
			//diagonais
			if (matriz[0][0] == jAux.getMarcador() && matriz[1][1] == jAux.getMarcador() && matriz[2][2] == jAux.getMarcador()) {
				return jAux.getMarcador();
			}
			if (matriz[0][2] == jAux.getMarcador() && matriz[1][1] == jAux.getMarcador() && matriz[2][0] == jAux.getMarcador()) {
				return jAux.getMarcador();
			}
		return 'N';
	}
	
	//verifica se o jogo continua ou para
	public char verificarVencedor() {
		//o j1 (X) vencedor
		if(jAux.getMarcador() == 'X') {
			if(verificar() == jAux.getMarcador()) {
				return jAux.getMarcador();
			}
		}

			//o j2 (O) vencedor
		if(jAux.getMarcador() == 'O') {
			if(verificar() == jAux.getMarcador()) {
				return jAux.getMarcador();
			}
		}
		//deu velha
		if (jogadas == 9) {	
			return 'E';
		}
			//jogo continua
			        return 'N';
    }
}