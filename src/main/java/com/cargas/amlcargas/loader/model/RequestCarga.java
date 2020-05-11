package com.cargas.amlcargas.loader.model;

import io.swagger.annotations.ApiModelProperty;

public class RequestCarga {

	@ApiModelProperty(example = "BANCA, SOFOM, SOFIPO",  position = 0)
	private String esquema;
	
    @ApiModelProperty(example = "1, 13, 16",  position = 1)
    private String layout;

    @ApiModelProperty(example = "Clientes.svc",  position = 2)
    private String fileName;

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

    
    

}


