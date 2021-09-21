package com.spacetravels.payment.order.pais;

import com.spacetravels.payment.order.Pedido;

public class PedidoColombia extends Pedido 
{

	@Override
	protected void calculaIVA() {
		importeIVA = importeSinIVA * 0.19;
	}

}
