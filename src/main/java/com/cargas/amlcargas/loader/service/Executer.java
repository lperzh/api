package com.cargas.amlcargas.loader.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.cargas.amlcargas.loader.model.ProcessFile;

public class Executer {

	private static final Logger log = LoggerFactory.getLogger(Executer.class);
	
	private static final String FILE_PREFIX = "file:";

	/**
	 *
	 * @param inputFile
	 *            absolute path del archivo
	 * @param schema
	 *            schema sobre el que se debe ejecutar la carga
	 * @param idLayout
	 *            idLayout de la carga del archivo
	 * @param idProceso
	 *            idProceso con el que se inicio la carga
	 * @param cveProceso
	 *            Cve del proceso de carga que se esta ejecutando
	 * @param fileName
	 *            nombre del archivo
	 * @param userSession
	 *            usuario en session
	 * @param cveTipoArchivo
	 *            tipo de archivo C o B
	 * @param separador
	 *            Caracter que funciona como separador dentro del archivo
	 * @param headLinesNumber
	 *            Lineas que definen la cabecera
	 */
	public static void executeBatch(ProcessFile processFile, String batchDirectory) {

		final File executorDirectory = new File(batchDirectory);
		String command;
			command = "./loadFile.sh";
			log.debug(command);
			log.debug("EJECUTANDO BATCH: ");
			log.debug(processFile.toString());

			try {
				ProcessBuilder processBuilder = new ProcessBuilder(command, FILE_PREFIX + processFile.getInputFile(), processFile.getSchema(), processFile.getIdLayout(),
						processFile.getIdProceso() + "", processFile.getCveProceso(), processFile.getFileName(), processFile.getUserSession(), processFile.getCveTipoArchivo(), processFile.getSeparador(), processFile.getHeadLinesNumber());
				processBuilder.directory(executorDirectory);
				Process p = processBuilder.start();
				log.info("Script executed successfully");
				try {
					int shellExitStatus = p.waitFor();
					if (shellExitStatus != 0) {
						log.info("Successfully executed the shell script");
					}
				} catch (InterruptedException ex) {
					log.error("Shell Script preocess is interrupted");
					Thread.currentThread().interrupt();
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Executer :::::: executeBatch");				
			}
	}
}
