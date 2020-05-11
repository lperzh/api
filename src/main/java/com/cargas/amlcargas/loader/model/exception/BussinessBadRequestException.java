package com.cargas.amlcargas.loader.model.exception;

import com.cargas.amlcargas.loader.model.ResponseCarga;

public class BussinessBadRequestException extends RuntimeException {
    
	private ResponseCarga responseCarga;

    public BussinessBadRequestException(String error, ResponseCarga responseCarga){
        super(error);
        this.responseCarga = responseCarga;
    }

	public ResponseCarga getResponseCarga() {
		return responseCarga;
	}

	public void setResponseCarga(ResponseCarga responseCarga) {
		this.responseCarga = responseCarga;
	}

    
}
