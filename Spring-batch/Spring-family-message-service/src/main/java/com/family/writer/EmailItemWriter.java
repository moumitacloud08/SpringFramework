package com.family.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.family.model.Family;
import com.family.service.EmailService;

@Component
public class EmailItemWriter  implements ItemWriter<Family>{
	
	@Autowired
	EmailService emailService;
	
	@Override
	public void write(Chunk<? extends Family> chunk) {
		
		for(Family family : chunk.getItems()) {
			try {
				emailService.sendEmail(family,true);
			} catch (Exception e) {
				e.printStackTrace();
				emailService.sendEmail(family);
			}
		}
	}
	

}
