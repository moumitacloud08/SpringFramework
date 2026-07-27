package com.family.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.family.model.Family;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public FlatFileItemReader<Family> familyReader() {

		FlatFileItemReader<Family> reader = new FlatFileItemReader<Family>();

		reader.setResource(new ClassPathResource("family.csv"));
		reader.setLinesToSkip(1);

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames("Id", "Name", "Relation", "Mobile Number");

		BeanWrapperFieldSetMapper<Family> fieldSetMapper = new BeanWrapperFieldSetMapper<Family>();
		fieldSetMapper.setTargetType(Family.class);

		DefaultLineMapper<Family> lineMapper = new DefaultLineMapper<Family>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		reader.setLineMapper(lineMapper);

		return reader;

	}

	public ItemProcessor<Family, Family> familyProcessor() {
		return family -> {
			family.setName(family.getName().toUpperCase());
			family.setRelation(family.getRelation().toUpperCase());
			return family;
		};

	}

}
