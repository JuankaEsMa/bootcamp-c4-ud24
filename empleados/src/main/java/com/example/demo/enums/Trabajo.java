package com.example.demo.enums;

public enum Trabajo {
	LIMPIEZA("limpieza",1200),
	INFORMATICO("informatico",1500),
	DIRECTOR("director",3000),
	RECURSOS_HUMANOS("recursos humanos",1800),
	SECRETARIO("secretario",1600),
	OPERARIO("operario",2000);
		
	private String code;
	private double salario;
	
	private Trabajo(String code, int salario) {
		this.code = code;
		this.salario = salario;
	}
	
	public String getTrabajo() {
		return code;
	}
	
	public double getSalario() {
		return salario;
	}
	

}
