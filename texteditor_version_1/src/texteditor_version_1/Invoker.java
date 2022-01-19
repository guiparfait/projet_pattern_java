package texteditor_version_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Invoker {
	private String text;
	private int deb;
	
	public void setMescommandes(Map<String, Command> mescommandes) {
		this.mescommandes = mescommandes;
	}
	private int fin;
	
	
	private  Map<String, Command> mescommandes = new HashMap<>(); 
	
	
	public void setBeginindex(int deb) {
		this.deb = deb;
	}
	public void setEndIndex(int fin) {
		this.fin = fin;
	}
	public int getBeginindex() {
		return deb;
	}
	public int getEndIndex() {
		return fin;
	}
	public Invoker(Map<String, Command> commande) {
		mescommandes = commande;
	}
	public void addCommand(String key ,Command value){
		if(value!=null) {
			mescommandes.put(key, value);
		}
		
		
	}
	public String getText() {
		return this.text;
	}
	public void setText(String _text) {
		text= _text;
	}
	public void  playCommand(String s) {
		for(Map.Entry<String, Command>entry:mescommandes.entrySet()) {
			if(s == entry.getKey()) {
				entry.getValue().execute();
			}
		}
		
	}
	

}
