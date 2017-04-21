package com.dbs.cst.ircp.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.dbs.cst.ircp.model.IRASHeaderInput;


	public class IRASHeaderInputProcessor implements ItemProcessor<IRASHeaderInput, IRASHeaderInput> {



		    private static final Logger log = LoggerFactory.getLogger(IRASDetailsInputProcessor.class);

		    @Override
		    public IRASHeaderInput process(final IRASHeaderInput input) throws Exception {

		        log.info("Converting (" + input + ") into (" + input + ")");

		        return input;
		    }

		}




