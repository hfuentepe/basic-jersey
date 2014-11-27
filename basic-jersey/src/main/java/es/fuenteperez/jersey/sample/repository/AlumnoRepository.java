package es.fuenteperez.jersey.sample.repository;

import java.util.ArrayList;
import java.util.List;

import es.fuenteperez.jersey.sample.exception.RepositoryException;
import es.fuenteperez.jersey.sample.model.Alumno;

public class AlumnoRepository {
	static List<Alumno> alumnos = new ArrayList<Alumno>();
	static {
		alumnos.add(crearAlumno("08606736K", "nombre 1", "apellidos 1",
				"email1@fuenteperez.es", "947111111"));
		alumnos.add(crearAlumno("43575527A", "nombre 2", "apellidos 2",
				"email2@fuenteperez.es", "947222222"));
		alumnos.add(crearAlumno("01441892E", "nombre 3", "apellidos 3",
				"email3@fuenteperez.es", "947333333"));
		alumnos.add(crearAlumno("33389956M", "nombre 4", "apellidos 4",
				"email4@fuenteperez.es", "947444444"));
		alumnos.add(crearAlumno("31151958E", "nombre 5", "apellidos 5",
				"email5@fuenteperez.es", "947555555"));
		alumnos.add(crearAlumno("86628289P", "nombre 6", "apellidos 6",
				"email6@fuenteperez.es", "947666666"));
		alumnos.add(crearAlumno("65505654K", "nombre 7", "apellidos 7",
				"email7@fuenteperez.es", "947777777"));
		alumnos.add(crearAlumno("97470198Q", "nombre 8", "apellidos 8",
				"email8@fuenteperez.es", "947888888"));
		alumnos.add(crearAlumno("11427220S", "nombre 9", "apellidos 9",
				"email9@fuenteperez.es", "947999999"));
		alumnos.add(crearAlumno("32221271L", "nombre 10", "apellidos 10",
				"email10@fuenteperez.es", "947101010"));
	}

	public Alumno buscarAlumnoPorDni(String dni) {
		return getAlumnoByDni(dni);
	}
	
	public List<Alumno> obtenerTodos() {
		return alumnos;
	}

	public String anadirAlumno(Alumno nuevoAlumno) {
		if (getAlumnoByDni(nuevoAlumno.getDni()) != null) {
			throw new RepositoryException(11, "El alumno con dni " + nuevoAlumno.getDni()
					+ " ya existe.");
		}
		alumnos.add(nuevoAlumno);
		return nuevoAlumno.getDni();
	}

	public String actualizarAlumno(Alumno updateAlumno){
		Alumno alumnoActualizable = getAlumnoByDni(updateAlumno.getDni());
		if (alumnoActualizable == null) {
			throw new RepositoryException(22, "No existe un alumno con dni "
					+ updateAlumno.getDni() + ".");
		}
		alumnos.remove(alumnoActualizable);
		alumnos.add(updateAlumno);
		return updateAlumno.getDni();
	}

	public void eliminarAlumno(String dni) {
		Alumno alumnoEliminar = getAlumnoByDni(dni);
		if (alumnoEliminar == null) {
			throw new RepositoryException(33, "No existe un alumno con dni " + dni + ".");
		}
		alumnos.remove(alumnoEliminar);
	}

	private Alumno getAlumnoByDni(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}

	private static Alumno crearAlumno(String dni, String nombre,
			String apellidos, String email, String telefono) {
		Alumno alumno = new Alumno();
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setEmail(email);
		alumno.setTelefono(telefono);

		return alumno;
	}

	
}