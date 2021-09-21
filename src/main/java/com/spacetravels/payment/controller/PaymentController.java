package com.spacetravels.payment.controller;

import java.util.ArrayList;
import java.util.List;

import com.spacetravels.payment.model.PagoRealizado;
import com.spacetravels.payment.model.PagoRequest;
import com.spacetravels.payment.order.Pedido;
import com.spacetravels.payment.order.pais.PedidoColombia;
import com.spacetravels.payment.order.pais.PedidoMexico;
import com.spacetravels.payment.order.pais.PedidoPeru;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/payment")
public class PaymentController {

	private Pedido pedido;
	
	//static List<PagoRealizado> pagosRealizados = new ArrayList<PagoRealizado>();

	@Post
	public PagoRealizado pagar(@Body PagoRequest pago) {
		PagoRealizado pagoRealizado = null;
		switch (pago.pais) {
		case MEXICO:
			pedido = new PedidoMexico();
			pedido.setImporteSinIVA(pago.importeSinIVA);
			pedido.calculaPrecioConIVA();
			pagoRealizado = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
		  break;
		case COLOMBIA:
			pedido = new PedidoColombia();
			pedido.setImporteSinIVA(pago.importeSinIVA);
			pedido.calculaPrecioConIVA();
			pagoRealizado = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
		 break;
		case PERU:
			pedido = new PedidoPeru();
			pedido.setImporteSinIVA(pago.importeSinIVA);
			pedido.calculaPrecioConIVA();
			pagoRealizado = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
		 break;
		default:
			pagoRealizado = new PagoRealizado();
		}
		
		//pagosRealizados.add(pagoRealizado);
		return pagoRealizado;
	}
	
	@Get
	public String version() {
		return "Payment 3.0";
	}
	
	/*
	@Get("/pagos")
	public List<PagoRealizado> getPagosrealizados(){
		return pagosRealizados;
	}
	*/

}
