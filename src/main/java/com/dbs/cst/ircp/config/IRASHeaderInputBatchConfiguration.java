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

import com.dbs.cst.ircp.model.IRASHeaderInput;
import com.dbs.cst.ircp.model.IRInput;
import com.dbs.cst.ircp.service.IRASHeaderInputProcessor;
import com.dbs.cst.ircp.service.IRInputProcessor;

@Configuration
@EnableBatchProcessing
public class IRASHeaderInputBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    /*@Bean
    public FlatFileItemReader<IRInput> reader() {
        FlatFileItemReader<IRInput> reader = new FlatFileItemReader<IRInput>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<IRInput>() {{
        	
            /*setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "nric", "caseId", "taxType", "customerName", "amountDue", "appointmentDate", "releaseDate", "spaces" });
            }});*/
            /*setLineTokenizer(new FixedLengthTokenizer() {{
                setNames(new String[] { "nric", "caseId", "taxType", "customerName", "amountDue", "appointmentDate", "releaseDate", "spaces" });
                setColumns(new Range[] {new Range(1,1), new Range(2,2), new Range(3,3), new Range(4,4), new Range(5,5), new Range(6,15), new Range(16,25), new Range(26,26)});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<IRInput>() {{
                setTargetType(IRInput.class);
            }});
        }});
        return reader;
    }*/
  
    @Bean
    public FlatFileItemReader<IRASHeaderInput> reader() {
        FlatFileItemReader<IRASHeaderInput> reader = new FlatFileItemReader<IRASHeaderInput>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<IRASHeaderInput>() {{
        	
      //"fileId", "readTime", "completeTime", "orgName", "transDate", "headerValid", "noOfAppmt", "appmtAmount", "nricHash", "amountHash", 
        	//"noOfRelease", "releaseAmount", "trailerValid"
            setLineTokenizer(new FixedLengthTokenizer() {{
                setNames(new String[] { "orgName", "transDate", });
                setColumns(new Range[] { new Range(2,5), new Range(6,13)});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<IRASHeaderInput>() {{
                setTargetType(IRASHeaderInput.class);
            }});
        }});
        return reader;
    }

    
    @Bean
    public IRASHeaderInput validationProcessor() {
    	//Here we can have methods for transformation or validations
        return new IRASHeaderInput();
    }

    @Bean
    public IRASHeaderInputProcessor transformationProcessor() {
    	//Here we can have methods for transformation or validations
        return new IRASHeaderInputProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<IRASHeaderInput> writer() {
        JdbcBatchItemWriter<IRASHeaderInput> writer = new JdbcBatchItemWriter<IRASHeaderInput>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<IRASHeaderInput>());
        writer.setSql("INSERT INTO TBL_IRAS_FILE_HEADER(orgName, transDate) VALUES (:orgName, :transDate)");
        writer.setSql("");
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
                .<IRASHeaderInput, IRASHeaderInput> chunk(10)
                .reader(reader())
                .processor(validationProcessor())
                .processor(transformationProcessor())
                .writer(writer())
                .build();
    }
}
