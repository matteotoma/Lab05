package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class RicercaAnagrammi {
	private List<String> corretti;
	private List<String> errati;
	private AnagrammaDAO dao;
	
	public void anagrammi(String parola){
		corretti = new ArrayList<>();
		errati = new ArrayList<>();
		dao = new AnagrammaDAO();
		parola = parola.toLowerCase();
		List<Character> disponibili = new ArrayList<>();
		for(int i = 0; i<parola.length(); i++)
			disponibili.add(parola.charAt(i));
		cerca("", 0, disponibili);
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) {
			if(dao.isCorrect(parziale))
				corretti.add(parziale);
			else
				errati.add(parziale);
		}
		for(Character ch: disponibili) {
			String tentativo = parziale + ch;
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			cerca(tentativo, livello+1, rimanenti);
		}
	}

	public List<String> getCorretti() {
		return corretti;
	}

	public List<String> getErrati() {
		return errati;
	}

}
