package com.dbs.cst.ircp.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.dbs.cst.ircp.model.Input;


public class InputProcessor implements ItemProcessor<Input, Input> {



	    private static final Logger log = LoggerFactory.getLogger(IRInputProcessor.class);

	    @Override
	    public Input process(final Input input) throws Exception {

	        log.info("Converting (" + input + ") into (" + input + ")");

	        return input;
	    }

	}


