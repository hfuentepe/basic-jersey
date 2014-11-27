package es.fuenteperez.jersey.sample.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import es.fuenteperez.jersey.sample.exception.ApiError;
import es.fuenteperez.jersey.sample.exception.ResourceNotFoundException;

@Provider
public class ResourceNotFoundExceptionMapper implements
		ExceptionMapper<ResourceNotFoundException> {

	@Override
	public Response toResponse(ResourceNotFoundException rnfe) {
		return Response.status(Status.NOT_FOUND)
				.entity(new ApiError(rnfe.getCodigo(), rnfe.getMessage()))
				.build();
	}
}