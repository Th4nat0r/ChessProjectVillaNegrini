package chess_controller;
import chess_model.Team;
import chess_model.ChessboardModel;
import chess_model.Core;
import chess_view.*;

import java.util.Scanner;

public class PlayMatch {

	public static void main(String[] args) {
		//vaiabili locali al main
		String input = "";
		int sx, sy, tx, ty; // start e target x e y
		Team player = Team.Team1;//variabile del turno a cui assegno il primo turno
		ChessboardModel.nuovaPartita();//preparo la scacchiera per una nuova partita
		//apre la finestra grafica
		
		while (true) {
			System.out.println(ChessboardModel.stringChessboard());

			if(Core.check(player)) {//se il re � sotto scacco
				if(Core.mate(player)){
					System.out.println("SCACCO MATTO, PARTITA FINITA!");
					break;
				}
				else System.out.println("ATTENZIONE, SEI SOTTO SCACCO!");
			}
			else if(Core.mate(player) || Core.staleMate()){
				//Tecnicamente, se non posso muovere, ma non sono in scacco, si tratta di STALLO
				//Oppure se mi trovo in una condizione di stallo matematico (re vs. re, re vs. re+cavallo, re vs. re+alfiere)
				System.out.println("STALLO, PARTITA FINITA!");
				break;
			}
			System.out.print("\nE' IL TUO TURNO "); 
			if (player == Team.Team1) System.out.println("GIOCATORE 1");//turno del giocatore
			else System.out.println("GIOCATORE 2");
			System.out.print("Inserisci coordinate di start: ");
			input = new Scanner(System.in).nextLine();
			sx = (int)(input.charAt(0) - 'A');//estraggo la x della coordinata scelta
			sy = Integer.parseInt(input.substring(1, 2)) - 1;//estraggo la y della coordinata scelta
			if( sx > 7 || sy < 0 || sx > 7 || sy < 0){
				System.out.println("Coordinate fuori scacchiera.");
				continue;
			}
			if (Core.getTeam(sx, sy) != player) {
				//getTeam lo chiedo a Core che fa il lavoro di restituire null anche se in quella posizione c'� null
				//ChessboardModel mi andrebbe in errore
				System.out.println("Non hai selezionato un tuo pezzo.");
				continue;
			}//il pezzo deve appartenere alla mia squadra
			
			for (int moves : Core.availableMoves(sx, sy))
				System.out.print("" + (char)('A' + moves/10) + (moves%10 + 1) + ", ");
			
			System.out.println("'.");
			System.out.print("Inserisci coordinate di target: ");
			input = new Scanner(System.in).nextLine();
			tx = (int)(input.charAt(0) - 'A');//estraggo la x della coordinata scelta
			ty = Integer.parseInt(input.substring(1, 2)) - 1;//estraggo la y della coordinata scelta
			if( tx > 7 || ty < 0 || tx > 7 || ty < 0){
				System.out.println("Coordinate fuori scacchiera.");
				continue;
			}
			switch(Core.move(sx, sy, tx, ty)){
				case 0:
					System.out.println("Mossa non valida!");
				break;
				case 1:
					System.out.println("Mossa effettuata!");
					if(ty == 7) Core.upPawn(tx, ty);
					player = (player == Team.Team1) ? Team.Team2 : Team.Team1;
				break;
				case 2:
					System.out.println("Questa mossa sarebbe stata valida, ma hai il Re sotto scacco!");
				break;
			}
		}//chiude while true
	}//chiude il main
	
}
 
