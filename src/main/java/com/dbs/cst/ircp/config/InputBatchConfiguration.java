package com.dbs.cst.ircp.config;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


import com.dbs.cst.ircp.model.Input;

import com.dbs.cst.ircp.service.InputProcessor;

@Configuration
@EnableBatchProcessing
public class InputBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Input> reader() {
        FlatFileItemReader<Input> reader = new FlatFileItemReader<Input>();
        reader.setResource(new ClassPathResource("ABC.CSV"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Input>() {{
        	
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames(new String[] {"orgName", "transDate", "nric", "caseId", "taxType", "customerName", "amountDue", "appmtDate", "releaseDate" });
                setColumns(new Range[] {new Range(2,5), new Range(6,13), new Range(2,17), new Range(18,26), new Range(27,29), new Range(30,119), new Range(120,128), new Range(129,136), new Range(137, 144)});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Input>() {{
                setTargetType(Input.class);
            }});
        }});
        return reader;
    }

    @Bean
    public InputProcessor validationProcessor() {
    	//Here we can have methods for transformation or validations
        return new InputProcessor();
    }

    @Bean
    public InputProcessor transformationProcessor() {
    	//Here we can have methods for transformation or validations
        return new InputProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<Input> writer() {
    	
    	UUID fileId = UUID.randomUUID();
        JdbcBatchItemWriter<Input> writer = new JdbcBatchItemWriter<Input>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Input>());
        writer.setSql("INSERT INTO TBL_IRAS_FILE_HEADER (fileId, orgName, transDate) VALUES (:orgName, :transDate, :fileId)");
        writer.setSql("INSERT INTO TBL_IRAS_FILE_DETAILS(nric, caseId, taxType, customerName, amountDue, appmtDate, releaseDate) VALUES(:nric, :caseId, :taxType, :customerName, :amountDue, :appmtDate, :releaseDate)");
        writer.setDataSource(dataSource);
        return writer;
    }
    @Bean
 
    public Job importUserJob(InputJobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Input, Input> chunk(10)
                .reader(reader())
                .processor(validationProcessor())
                .processor(transformationProcessor())
                .writer(writer())
                .build();
    }
    // end::jobstep[]
}
