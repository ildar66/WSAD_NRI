package com.nri.domain;

import java.io.Serializable;

import com.nri.mapping.Mapper;
import com.nri.mapping.MapperFactory;
/**
 * Superclass that all NRI system domain classes extend from.
 * Also, delegates persistent request to mapper class.
 * 
 * Creation date: (2/2/00 3:04:35 PM)
 * @author: Administrator
 */
public class NriObject implements java.io.Serializable {
	private transient Mapper mapper = null;
	/**
	 * NriObject constructor.
	 */
	public NriObject() {
		super();
	}

	public Mapper getMapper() {
		if (mapper == null) {
			mapper = MapperFactory.getSystemMapperFactory().getMapper(this.getClass());
		}
		return mapper;
	}

}