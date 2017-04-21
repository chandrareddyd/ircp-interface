package com.dbs.cst.ircp.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.dbs.cst.ircp.model.IRASDetailsInput;


	public class IRASDetailsInputProcessor implements ItemProcessor<IRASDetailsInput, IRASDetailsInput> {



		    private static final Logger log = LoggerFactory.getLogger(IRASDetailsInputProcessor.class);

		    @Override
		    public IRASDetailsInput process(final IRASDetailsInput input) throws Exception {

		        log.info("Converting (" + input + ") into (" + input + ")");

		        return input;
		    }

		}




