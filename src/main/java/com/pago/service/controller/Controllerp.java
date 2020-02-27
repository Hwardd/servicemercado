package com.pago.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;


@Controller
public class Controllerp {

	
	@GetMapping("/pago")
	public String pago(Model model) throws MPException {
		
		MercadoPago.SDK.setAccessToken("TEST-3764181139893912-021917-4d74241a10559a6abfd0fefb4ff79e13-522092531");

		// Crea un objeto de preferencia
		Preference preference = new Preference();

		// Crea un ítem en la preferencia
		Item item = new Item();
		Payer payer = new Payer();
		payer.setName("Charles")
		     .setSurname("Luevano")
		     .setEmail("charles@hotmail.com")
		     .setDateCreated("2018-06-02T12:58:41.425-04:00");
		
		item.setTitle("Mi producto")
		    .setQuantity(1)
		    .setUnitPrice((float) 75.56);
		preference.appendItem(item);
		preference.setPayer(payer);
		preference.save();
		System.out.println(preference.getId());
		model.addAttribute("preference",preference.getId());
		
		return "pago";
	}
	
	
	
	
}
