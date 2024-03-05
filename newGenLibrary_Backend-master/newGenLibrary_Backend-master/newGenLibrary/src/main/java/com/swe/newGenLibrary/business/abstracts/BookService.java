package com.swe.newGenLibrary.business.abstracts;

import java.util.List;

import com.swe.newGenLibrary.core.utulitites.result.DataResult;



public interface BookService {
	Object getAll();
	
	Object getByPageNumber(int pageNumber);

}
