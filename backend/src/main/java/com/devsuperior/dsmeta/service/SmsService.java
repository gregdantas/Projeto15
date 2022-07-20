package com.devsuperior.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


	@Service
	public class SmsService {

		@Value("${twilio.sid}")
		private String twilioSid;

		@Value("${twilio.key}")
		private String twilioKey;

		@Value("${twilio.phone.from}")
		private String twilioPhoneFrom;

		@Value("${twilio.phone.to}")
		private String twilioPhoneTo;
		
		@Autowired
		SaleRepository saleRepository ; 
        
		public void sendSms(Long saleId) {
			
			Sale sale = saleRepository.findById(saleId).get();           
			String date= sale.getDate().getMonth()+"/"+sale.getDate().getYear();/*maneira de capturar e inverter valor da data*/
			String sms ="Vendedor "+sale.getSellerName()+" teve um total de R$="+sale.getAmount()+" vendidos " + date ; 
			
			Twilio.init(twilioSid, twilioKey);

			PhoneNumber to = new PhoneNumber(twilioPhoneTo);
			PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

			Message message = Message.creator(to, from, sms).create();

			System.out.println(message.getSid());
		}
	}

 

