package es.fuenteperez.jersey.sample.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import es.fuenteperez.jersey.sample.exception.ApiError;
import es.fuenteperez.jersey.sample.exception.RepositoryException;

@Provider
public class RepositoryExceptionMapper implements
		ExceptionMapper<RepositoryException> {

	@Override
	public Response toResponse(RepositoryException rnfe) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ApiError(rnfe.getCodigo(), rnfe.getMessage()))
				.build();
	}
}