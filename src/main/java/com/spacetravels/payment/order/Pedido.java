package com.spacetravels.payment.order;

import com.spacetravels.payment.constant.Pais;
import com.spacetravels.payment.model.Ticket;

public abstract class Pedido {
	
	
	protected double importeSinIVA;
	
	protected double importeIVA;
	
	protected double importeConIVA;
	
	
	protected abstract void calculaIVA();
	
	public void calculaPrecioConIVA() {
		this.calculaIVA();
		importeConIVA = importeSinIVA + importeIVA;
	}
	
	public void setImporteSinIVA(double importeSinIVA) {
		this.importeSinIVA = importeSinIVA;
	}

	public Ticket obtenerPagoRealizado(String nombre, Pais pais) {
		Ticket pagoRealizado = new Ticket();
		pagoRealizado.importeSinIVA = importeSinIVA;
		pagoRealizado.importeIVA = importeIVA;
	    pagoRealizado.importeConIVA = importeConIVA;
	    pagoRealizado.nombre = nombre;
	    pagoRealizado.pais = pais;
	    
	    return pagoRealizado;
	}
}
