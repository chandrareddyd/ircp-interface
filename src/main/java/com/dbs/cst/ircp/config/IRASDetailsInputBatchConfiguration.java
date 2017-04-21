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
import com.dbs.cst.ircp.model.IRASDetailsInput;
import com.dbs.cst.ircp.model.IRInput;
import com.dbs.cst.ircp.service.IRASDetailsInputProcessor;
import com.dbs.cst.ircp.service.IRASHeaderInputProcessor;
import com.dbs.cst.ircp.service.IRInputProcessor;

@Configuration
@EnableBatchProcessing
public class IRASDetailsInputBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;



    @Bean
    public FlatFileItemReader<IRASDetailsInput> reader() {
        FlatFileItemReader<IRASDetailsInput> reader = new FlatFileItemReader<IRASDetailsInput>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<IRASDetailsInput>() {{
        	
      //fileId, nric, nricReformat, caseId, taxType, customerName, amountDue,  appmtDate, releaseDate, fileDate, isValid, errorCode
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames(new String[] { "nric", "caseId", "taxType", "customerName", "amountDue", "appmtDate", "releaseDate" });
                setColumns(new Range[] { new Range(2,17), new Range(18,26), new Range(27,29), new Range(30,119), new Range(120,128), new Range(129,136), new Range(137, 144)});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<IRASDetailsInput>() {{
                setTargetType(IRASDetailsInput.class);
            }});
        }});
        return reader;
    }

    
    @Bean
    public IRASDetailsInput validationProcessor() {
    	//Here we can have methods for transformation or validations
        return new IRASDetailsInput();
    }

    @Bean
    public IRASDetailsInputProcessor transformationProcessor() {
    	//Here we can have methods for transformation or validations
        return new IRASDetailsInputProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<IRASDetailsInput> writer() {
        JdbcBatchItemWriter<IRASDetailsInput> writer = new JdbcBatchItemWriter<IRASDetailsInput>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<IRASDetailsInput>());
        writer.setSql("INSERT INTO TBL_IRAS_FILE_HEADER(orgName, transDate) VALUES (:orgName, :transDate)");
        writer.setDataSource(dataSource);
        return writer;
    }
    @Bean
 
    public Job importUserJob(IRInputJobCompletionNotificationListener listener) {
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
                .<IRASDetailsInput, IRASDetailsInput> chunk(10)
                .reader(reader())
                .processor(validationProcessor())
                .processor(transformationProcessor())
                .writer(writer())
                .build();
    }
}
