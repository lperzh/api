package com.cargas.amlcargas.loader.api;



import com.cargas.amlcargas.loader.service.AmlCargasServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cargas.amlcargas.loader.model.RequestCarga;
import com.cargas.amlcargas.loader.model.ResponseCarga;
import com.cargas.amlcargas.loader.model.exception.BussinessException;
import com.cargas.amlcargas.loader.service.AmlCargasService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/aml/archivos")
public class AmlCargasController {

  private static final Logger LOG = LoggerFactory.getLogger(AmlCargasController.class);

	@Autowired
	AmlCargasService amlCargasService;

    @ApiOperation(value = "Carga de archivos al sistema AML")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = ResponseCarga.class),
            @ApiResponse(code = 201, message = "Loaded", response = ResponseCarga.class),
            @ApiResponse(code = 304, message = "Not Modified", response = ResponseCarga.class),
            @ApiResponse(code = 400, message = "Input Request is invalid or incorrect", response = ResponseCarga.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ResponseCarga.class),
            @ApiResponse(code = 404, message = "Not Found. Resource does not exist", response = ResponseCarga.class),
            @ApiResponse(code = 409, message = "Conflict in the request", response = ResponseCarga.class),
            @ApiResponse(code = 500, message = "Internal server error, Time out", response = ResponseCarga.class)
    })
    @PostMapping
    public ResponseCarga processFile(@RequestBody RequestCarga requestCarga) {
    	ResponseCarga responseCarga = null;
    	try {
        	long idProceso = amlCargasService.executeBatch(requestCarga.getEsquema(),
											requestCarga.getLayout(),
												requestCarga.getFileName());
        responseCarga = new ResponseCarga();
        responseCarga.setIdProceso(idProceso);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            throw new BussinessException(ex.getMessage(), null);
        }

    	return responseCarga;
    }
}
