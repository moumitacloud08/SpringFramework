package com.family.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.family.model.Family;
import com.family.writer.EmailItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	// ==========================
	// Reader
	// ==========================
	@Bean
	public FlatFileItemReader<Family> familyReader() {

		FlatFileItemReader<Family> reader = new FlatFileItemReader<Family>();

		reader.setResource(new ClassPathResource("family.csv"));
		reader.setLinesToSkip(1);

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames("id", "name", "relation", "phoneNumber","email");

		BeanWrapperFieldSetMapper<Family> fieldSetMapper = new BeanWrapperFieldSetMapper<Family>();
		fieldSetMapper.setTargetType(Family.class);

		DefaultLineMapper<Family> lineMapper = new DefaultLineMapper<Family>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		reader.setLineMapper(lineMapper);

		return reader;

	}

	// ==========================
	// Processor
	// ==========================
	@Bean
	public ItemProcessor<Family, Family> familyProcessor() {
		return family -> {
			family.setName(family.getName().toUpperCase());
			family.setRelation(family.getRelation().toUpperCase());
			return family;
		};

	}


	 // ==========================
    // Step
    // ==========================
	@Bean
	public Step familyStep(JobRepository jobRepository,
			PlatformTransactionManager transactionManager,
			EmailItemWriter writer) {
		return new StepBuilder("familyStep", jobRepository)
				.<Family, Family>chunk(2, transactionManager)
				.reader(familyReader())
				.processor(familyProcessor())
				.writer(writer)
				.build();

	}
	
	// ==========================
    // Job
    // ==========================
	@Bean
	public Job familyJob(JobRepository jobRepository,
			Step familyStep) {
				return new JobBuilder("familyJob",jobRepository)
						.start(familyStep)
						.build();
		
	}

}
