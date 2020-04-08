package it.polito.tdp.anagrammi.model;

public class TestRicerca {

	public static void main(String[] args) {
		RicercaAnagrammi ric = new RicercaAnagrammi() ;
		
		ric.anagrammi("dog");
		System.out.println(ric.getCorretti());
		System.out.println(ric.getErrati());
		
	}

}
