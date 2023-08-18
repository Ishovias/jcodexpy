package com.JCodexpy;

public class Encriptador {

	private char[] llave;
	private char[] llave2;
	private String codificado;

	public Encriptador() {

		this.codificado = "";

		this.llave = new char[42];
		this.llave2 = new char[42];

		String llaveBruta = ("abcdefghijklmnopqrstuvwxyz0123456789@#$&?!");

		int x = 42;
		for (int i = 0; i < llaveBruta.length(); i++) {
			this.llave[i] = llaveBruta.charAt(i);
			x = x - 1;
			this.llave2[x] = llaveBruta.charAt(i);
		}
	}

	public void codifica(String frase) {
		this.codificado = "";
		for (int i = 0; i < frase.length(); i++) {
			for (int x = 0; x < this.llave.length; x++) {
				if (frase.charAt(i) == this.llave[x]) {
					this.codificado += this.llave2[x];
					break; 
				} else if (x == 41) {
					this.codificado += frase.charAt(i);
				}
			}
		}
	}

	public String getCodificado() {
		return this.codificado;
	}
}