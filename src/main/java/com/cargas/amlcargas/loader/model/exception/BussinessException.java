package com.cargas.amlcargas.loader.model.exception;

import com.cargas.amlcargas.loader.model.ResponseCarga;

public class BussinessException extends RuntimeException {

    private ResponseCarga responseCarga;

    public BussinessException(String error, ResponseCarga responseCarga){
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