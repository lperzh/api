package com.cargas.amlcargas.loader.dao;

import com.cargas.amlcargas.loader.model.ProcessFile;

public interface AmlCargasDao {

	ProcessFile getMetaDataUploadFile(String baseName, String schema);
	Integer getSecIdProceso(String schema);
}
