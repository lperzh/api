package com.cargas.amlcargas.loader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cargas.amlcargas.loader.dao.AmlCargasDao;
import com.cargas.amlcargas.loader.model.ProcessFile;

@Service
public class AmlCargasServiceImpl implements AmlCargasService{

	private static final Logger LOG = LoggerFactory.getLogger(AmlCargasServiceImpl.class);

	@Autowired
	AmlCargasDao amlCargasDao;

	@Value("${path.bath}")
    private String batch;

	@Value("${path.storage}")
	private String pathStorage;


	@Override
	public long executeBatch(String esquema, String layout, String fileName) {
    LOG.debug(":::::::::executeBatch:::::::::::");

		long secuencia = amlCargasDao.getSecIdProceso(esquema);
    LOG.debug("secuencia :::::> " + secuencia);
		String name = getMetaDataLoad(fileName);
    LOG.debug("name:    " + name);
		ProcessFile processFile = amlCargasDao.getMetaDataUploadFile(name, esquema);
    LOG.debug("processFile ::::");

		processFile.setFileName(pathStorage+fileName);
		processFile.setSchema(esquema);
		processFile.setUserSession("correo@mail.com");
		processFile.setHeadLinesNumber("1");
		processFile.setInputFile(pathStorage+fileName);
		processFile.setIdProceso(secuencia);
		Executer.executeBatch(processFile, batch);
		return secuencia;
	}

	private String getMetaDataLoad(String fileName) {
		String[] fileParse = fileName.split("-");
		String baseName;
		String[] subName;

		if (LOG.isDebugEnabled()) {
      LOG.debug("LOAD DATA EN FUNCTION::");
		}
		if (fileParse.length > 2) {
			baseName = fileParse[0] + "-" + fileParse[1];
		} else {
			subName = fileParse[1].split("\\.");
			try {
				Integer.parseInt(subName[0]);
				baseName = fileParse[0];
			} catch (NumberFormatException nfe) {
				baseName = fileParse[0] + "-" + subName[0];
			}
		}
		return baseName;

	}

}
