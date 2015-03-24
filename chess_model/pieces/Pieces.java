package chess_model.pieces;

import chess_model.Team;

public interface Pieces {

	Team getTeam(); //ci dovr� essere una variabile di tipo Team da restituire
	Iterable<Integer> mosseConsentite(int x, int y);
	boolean check(int x, int y);
}
