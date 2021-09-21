package com.spacetravels.payment.order.pais;

import com.spacetravels.payment.order.Pedido;

public class PedidoMexico extends Pedido {

	@Override
	protected void calculaIVA() {
		importeIVA = importeSinIVA * 0.16;
	}

	
}
