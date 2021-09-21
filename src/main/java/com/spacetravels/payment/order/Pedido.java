package com.spacetravels.payment.order;

import com.spacetravels.payment.constant.Pais;
import com.spacetravels.payment.model.PagoRealizado;

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

	public PagoRealizado obtenerPagoRealizado(String nombre, Pais pais) {
		PagoRealizado pagoRealizado = new PagoRealizado();
		pagoRealizado.importeSinIVA = importeSinIVA;
		pagoRealizado.importeIVA = importeIVA;
	    pagoRealizado.importeConIVA = importeConIVA;
	    pagoRealizado.nombre = nombre;
	    pagoRealizado.pais = pais;
	    
	    return pagoRealizado;
	}
}
