import java.util.Scanner;
public class Testador {
	
	public static void main(String[] args) {
		Scanner tec = new Scanner (System.in);

		Jogador j1 = new Jogador('X');
		Jogador j2 = new Jogador ('O');

		Tabuleiro tab = new Tabuleiro(j1, j2);
		System.out.println("Inicie o jogador, escolhendo 1 = X ou 2 = O:");
		tab.caso = tec.nextInt();
		tab.reiniciarTabuleiro();
		do{
			tab.exibirTabuleiro();
			tab.jogar();
			if(tab.verificarVencedor() == 'X' || tab.verificarVencedor() == 'O') {
				tab.exibirTabuleiro();
				System.out.println( tab.jAux.getMarcador() + " É VENCEDOR!!");
				break;
			}else if (tab.verificarVencedor() == 'E') {
				tab.exibirTabuleiro();
				System.out.println("Deu Velha!!");
				break;
			}
		}while (tab.verificarVencedor() == 'N');
		tec.close();
	}
}