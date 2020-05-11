package com.cargas.amlcargas.loader.model;

public class ProcessFile {

	private String inputFile;
	private String schema;
	private String idLayout;
	private long idProceso;
	private String cveProceso;
	private String fileName;
	private String userSession;
	private String cveTipoArchivo;
	private String separador;
	private String headLinesNumber;

	public ProcessFile() {

	}

	public ProcessFile(String inputFile, String schema, String idLayout, long idProceso, String cveProceso,
			String fileName, String userSession, String cveTipoArchivo, String separador, String headLinesNumber) {
		super();
		this.inputFile = inputFile;
		this.schema = schema;
		this.idLayout = idLayout;
		this.idProceso = idProceso;
		this.cveProceso = cveProceso;
		this.fileName = fileName;
		this.userSession = userSession;
		this.cveTipoArchivo = cveTipoArchivo;
		this.separador = separador;
		this.headLinesNumber = headLinesNumber;
	}

	@Override
	public String toString() {
		return "ProcessFile [inputFile=" + inputFile + ", schema=" + schema + ", idLayout=" + idLayout + ", idProceso="
				+ idProceso + ", cveProceso=" + cveProceso + ", fileName=" + fileName + ", userSession=" + userSession
				+ ", cveTipoArchivo=" + cveTipoArchivo + ", separador=" + separador + ", headLinesNumber="
				+ headLinesNumber + "]";
	}

	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getIdLayout() {
		return idLayout;
	}
	public void setIdLayout(String idLayout) {
		this.idLayout = idLayout;
	}
	public long getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(long idProceso) {
		this.idProceso = idProceso;
	}
	public String getCveProceso() {
		return cveProceso;
	}
	public void setCveProceso(String cveProceso) {
		this.cveProceso = cveProceso;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserSession() {
		return userSession;
	}
	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}
	public String getCveTipoArchivo() {
		return cveTipoArchivo;
	}
	public void setCveTipoArchivo(String cveTipoArchivo) {
		this.cveTipoArchivo = cveTipoArchivo;
	}
	public String getSeparador() {
		return separador;
	}
	public void setSeparador(String separador) {
		this.separador = separador;
	}
	public String getHeadLinesNumber() {
		return headLinesNumber;
	}
	public void setHeadLinesNumber(String headLinesNumber) {
		this.headLinesNumber = headLinesNumber;
	}



}
