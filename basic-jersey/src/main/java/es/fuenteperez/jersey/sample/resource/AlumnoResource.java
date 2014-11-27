package es.fuenteperez.jersey.sample.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import es.fuenteperez.jersey.sample.exception.ResourceNotFoundException;
import es.fuenteperez.jersey.sample.model.Alumno;
import es.fuenteperez.jersey.sample.repository.AlumnoRepository;

@Path("alumnos")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
public class AlumnoResource {
  static AlumnoRepository alumnoRepository = new AlumnoRepository();

  @POST
  public Response crearAlumno(Alumno alumno) throws Exception {
	alumnoRepository.anadirAlumno(alumno);
    return Response.ok().entity("").build();
  }

  @PUT
  @Path("{dni}")
  public Response actualizarAlumno(@PathParam("id") String username, Alumno alumno) {
	 alumnoRepository.actualizarAlumno(alumno);
    return Response.ok().entity("").build();
  }

  @DELETE
  @Path("{dni}")
  public Response eliminarAlumno(@PathParam("dni") String dni) {
	  alumnoRepository.buscarAlumnoPorDni(dni);
    return Response.ok().entity("").build();
  }

  @GET
  @Path("{dni}")
  public Response obtenerAlumno(@PathParam("dni") String dni) throws ResourceNotFoundException{
	Alumno alumno = alumnoRepository.buscarAlumnoPorDni(dni);  
    if (null != alumno) {
      return Response.ok().entity(alumno).build();
    } else {
      throw new ResourceNotFoundException(20, "Alumno no existe");
    }
  }
  
  @GET
  public List<Alumno> obtenerTodosLosAlumnos(){
	  return alumnoRepository.obtenerTodos();
  }
}
