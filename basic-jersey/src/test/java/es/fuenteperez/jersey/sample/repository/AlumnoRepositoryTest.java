package es.fuenteperez.jersey.sample.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.fuenteperez.jersey.sample.exception.RepositoryException;
import es.fuenteperez.jersey.sample.model.Alumno;

public class AlumnoRepositoryTest {

	AlumnoRepository alumnoRepository;

	@Before
	public void setUp() {
		alumnoRepository = new AlumnoRepository();
	}

	@After
	public void tearDown() {
		alumnoRepository = null;
	}

	@Test
	public void testObtenerTodos() {
		alumnoRepository = new AlumnoRepository();
		int nesperado = 10;
		List<Alumno> resultado = alumnoRepository.obtenerTodos();

		assertNotNull("Resultado esperado distinto null", resultado);
		assertEquals("Numero de resultados no es el esperado", nesperado,
				resultado.size());
	}

	@Test
	public void testBuscarAlumnoPorDni_no_existe() {
		String dni = "11111111L";
		alumnoRepository = new AlumnoRepository();
		Alumno resultado = alumnoRepository.buscarAlumnoPorDni(dni);

		assertNull("Se esperaba un null", resultado);
	}

	@Test
	public void testBuscarAlumnoPorDni() {
		alumnoRepository = new AlumnoRepository();
		List<Alumno> alumnos = alumnoRepository.obtenerTodos();
		Alumno esperado = alumnos.get(0);
		Alumno resultado = alumnoRepository.buscarAlumnoPorDni(esperado
				.getDni());

		assertNotNull("Resultado esperado distinto de Null", resultado);
		assertEquals("Resultado no es el esperado", esperado, resultado);
	}

	@Test
	public void testAnadirAlumno_ya_existe() {
		alumnoRepository = new AlumnoRepository();
		Alumno nuevoAlumno = alumnoRepository.obtenerTodos().get(0);

		try {
			alumnoRepository.anadirAlumno(nuevoAlumno);
			fail("Se esperaba una excepcion");
		} catch (RepositoryException e) {
			assertEquals("El alumno con dni " + nuevoAlumno.getDni()
					+ " ya existe.", e.getMessage());
		}
	}

	@Test
	public void testAnadirAlumno() throws Exception {
		alumnoRepository = new AlumnoRepository();
		Alumno nuevoAlumno = new Alumno();
		String esperado = "11111111K";
		nuevoAlumno.setDni(esperado);

		String resultado = alumnoRepository.anadirAlumno(nuevoAlumno);
		assertEquals("REsultado no es el esperado", esperado, resultado);
		assertEquals("Numero de alumnos no es el esperado", 11,
				alumnoRepository.obtenerTodos().size());
		//Dejamos la lista en el estado actual antes de la prueba
		alumnoRepository.eliminarAlumno(alumnoRepository.buscarAlumnoPorDni(resultado).getDni());
	}
	
	@Test
	public void testEliminarAlumno_no_existe() {
		String dni = "11111111L";
		alumnoRepository = new AlumnoRepository();
		try {
			alumnoRepository.eliminarAlumno(dni);
			fail("Se esperaba una excepcion");
		} catch (RepositoryException e) {
			assertEquals("No existe un alumno con dni " + dni + ".",
					e.getMessage());
		}
	}

	@Test
	public void testEliminarAlumno() throws Exception {
		alumnoRepository = new AlumnoRepository();
		Alumno alumnoEliminar = alumnoRepository.obtenerTodos().get(0);
		alumnoRepository.eliminarAlumno(alumnoEliminar.getDni());
		
		assertNull("El alumno no se ha eliminado correctamente", alumnoRepository.buscarAlumnoPorDni(alumnoEliminar.getDni()));
		assertEquals("Numero de usuarios no esperado",9, alumnoRepository.obtenerTodos().size());
		
		//Dejamos la lista en el estado actual antes de la prueba
		alumnoRepository.anadirAlumno(alumnoEliminar);
	}
	
	@Test
	public void testActualizarAlumno_no_existe(){
		Alumno updateAlumno = new Alumno();
		updateAlumno.setDni("11111111L");
		alumnoRepository = new AlumnoRepository();
		try {
			
			alumnoRepository.actualizarAlumno(updateAlumno);
			fail("Se esperaba una excepcion");
		} catch (RepositoryException e) {
			assertEquals("No existe un alumno con dni " + updateAlumno.getDni() + ".",
					e.getMessage());
		}
		
	}
	
	@Test
	public void testActualizarAlumno() throws Exception{
		alumnoRepository = new AlumnoRepository();
		Alumno updateAlumno = alumnoRepository.obtenerTodos().get(0);
		updateAlumno.setTelefono("947222222");
		String resultado = alumnoRepository.actualizarAlumno(updateAlumno);
		
		assertEquals("El alumno no se ha actualizado correctamente", updateAlumno.getDni(), resultado);
		assertEquals("El alumno no se ha actualizado correctamente", "947222222", alumnoRepository.buscarAlumnoPorDni(resultado).getTelefono());
		assertEquals("Numero de usuarios no esperado",10, alumnoRepository.obtenerTodos().size());
	}
	

}
