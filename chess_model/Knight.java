package chess_model;

import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int team) {
		super(team);
	}

	@Override
	public Iterable<Integer> mosseConsentite(byte x, byte y) {
		ArrayList<Integer> mosseConsentite = new ArrayList<Integer>();
		Piece other = null;
		
		//prima mossa partendo da radianti 0 
		if(y < 7 && x < 6 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x + 2), (byte)(y + 1))) == null || other .team != team))
			mosseConsentite.add((int)((x + 2) * 10 + y + 1));//aggiungo quella casella alle consentite
		//seconda mossa partendo da radianti 0
		if(y < 6 && x < 7 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x + 1), (byte)(y + 2))) == null || other .team != team))
			mosseConsentite.add((int)((x + 1) * 10 + y + 2));//aggiungo quella casella alle consentite		
		//terza mossa partendo da radianti 0
		if(y < 6 && x > 0 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x - 1), (byte)(y + 2))) == null || other .team != team))
			mosseConsentite.add((int)((x - 1) * 10 + y + 2));//aggiungo quella casella alle consentite		
		//quarta mossa partendo da radianti 0
		if(y < 7 && x > 1 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x - 2), (byte)(y + 1))) == null || other .team != team))
			mosseConsentite.add((int)((x - 2) * 10 + y + 1));//aggiungo quella casella alle consentite			
		//quinta mossa partendo da radianti 0
		if(y > 0 && x > 1 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x - 2), (byte)(y - 1))) == null || other .team != team))
			mosseConsentite.add((int)((x - 2) * 10 + y - 1));//aggiungo quella casella alle consentite
		//sesta mossa partendo da radianti 0
		if(y > 1 && x > 0 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x - 1), (byte)(y - 2))) == null || other .team != team))
			mosseConsentite.add((int)((x - 1) * 10 + y - 2));//aggiungo quella casella alle consentite
		//settima mossa partendo da radianti 0
		if(y > 1 && x < 7 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x + 1), (byte)(y - 2))) == null || other .team != team))
			mosseConsentite.add((int)((x + 1) * 10 + y - 2));//aggiungo quella casella alle consentite
		//ottava mossa partendo da radianti 0 (e chiudendo la circonferenza)
		if(y > 0 && x < 6 && ((other = ChessboardModel.getPezzoInPosizione((byte)(x + 2), (byte)(y - 1))) == null || other .team != team))
			mosseConsentite.add((int)((x + 2) * 10 + y - 1));//aggiungo quella casella alle consentite	
		return mosseConsentite;
	}


}
