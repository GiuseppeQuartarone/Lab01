package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		List<String> parole;
		
	public Parole() {
		parole = new LinkedList<>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> lista = new LinkedList<>(parole);
		Collections.sort(lista,new ComparatoreParole());
		return lista;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void cancella(String s) {
		if(parole.contains(s))
			parole.remove(s);
	}

}
