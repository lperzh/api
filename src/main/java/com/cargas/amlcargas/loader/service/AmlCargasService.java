package com.cargas.amlcargas.loader.service;

public interface AmlCargasService {

	long executeBatch(String esquema, String layout, String fileName);
}
