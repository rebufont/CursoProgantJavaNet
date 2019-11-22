package com.getafe.curso;

public class ResultadoOperacion
{
	
	private int x;
	private int y;
	private String op;
	private int resultado;
	
	
	
	public ResultadoOperacion() {
		super();
	}
	
	public ResultadoOperacion(int x, int y, String op, int resultado) {
		super();
		this.x = x;
		this.y = y;
		this.op = op;
		this.resultado = resultado;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}	

}
