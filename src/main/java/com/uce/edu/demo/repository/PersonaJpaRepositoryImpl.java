package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {
	private static final Logger LOGGER = Logger.getLogger(PersonaJpaRepositoryImpl.class);
	// Interfaz anotacion paa que se inyecte (Manejador de entidades)
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha insertado el Persona: " + persona);
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		LOGGER.info("Se ha actualizado el Persona: " + persona);
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarId(id);
		LOGGER.info("Se ha eliminado el Persona: " + persona);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		// SELECT * FROM persona where pers_cedula='1720757101';
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);

		return (Persona) jpqlQuery.getSingleResult();// Este devuelve un objeto generico;
	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class); // MANEJA
																										// GENERICOS(Tipo
																										// de dato)
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult(); // Este devuelve un objeto persona xq le especificamos
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");// Trabaja con Query
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		// SQL PURO
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula= :datoCedula",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);

		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		// SELECT p FROM Persona p WHERE p.cedula = :datoCedula
		// creamos una instancia de la interfaz CriteriaBuilder Fabrica para c
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		// Especificamos el retorno de mi Sql
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		// Aqui empezamos a contruir el SQL
		// Root o FROM se especifica cual es mi tabla principal
		Root<Persona> personaRoot = myQuery.from(Persona.class);

		// myQuery.select(personaRoot);//Select p From Persona
		// Las condiciones where en criteria Api se los conoce como predicados
		Predicate p1 = myBuilder.equal(personaRoot.get("cedula"), cedula);// Esta representando p.cedula = :datoCedula

		// CriteriaQuery<Persona>myQyeryCompleto=myQuery.select(personaRoot).where(p1);
		myQuery.select(personaRoot).where(p1);
		// Finalizado mi query completo

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Persona> buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);

		// pers_nombre='Pepito'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		// pers_apellido='Velez'
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate miPerdicadoFinal = null;

		/// pers_nombre='Pepito' and pers_apellido='Velez'
		if (genero.equals("M")) {
			miPerdicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
		} else {
			miPerdicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}

		myQuery.select(myTabla).where(miPerdicadoFinal);

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	@Override
	public List<Persona> buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);

		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);

		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);

		Predicate miPerdicadoFinal = null;

		if (genero.equals("M")) {
			miPerdicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			miPerdicadoFinal = myCriteria.and(miPerdicadoFinal, predicadoGenero);

		} else {
			miPerdicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			miPerdicadoFinal = myCriteria.or(miPerdicadoFinal, predicadoGenero);
		}

		myQuery.select(myTabla).where(miPerdicadoFinal);

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	@Override
	public List<Persona> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaSencilla> buscarApellidoSencillo(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<PersonaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre,p.apellido) FROM Persona p WHERE p.apellido = :datoApellido",
				PersonaSencilla.class);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		// SELECT pers_genero,count(pers_genero) FROM persona group by (pers_genero)
		// SELECT p.genero,COUNT(p.genero) FROM Persona p GROUP BY p.genero
		// SELECT New
		// com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero,COUNT(p.genero))
		// FROM Persona p GROUP BY p.genero
		TypedQuery<PersonaContadorGenero> myQuery = this.entityManager.createQuery(
				"SELECT New com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero,COUNT(p.genero)) FROM Persona p GROUP BY p.genero",
				PersonaContadorGenero.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub

		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getResultList();

	}

	@Override
	public List<Persona> buscarGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGeneroTyped(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero",
				Persona.class);
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGeneroNamed(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGeneroTypedNamed(String genero) {
		// TODO Auto-generated method stub

		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorGenero", Persona.class);
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarNombre(String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		// update persona set pers_genero='F' where pers_apellido='Perez'
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero= :datoGenero  WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		// delete from persona where pers_genero='Perez'
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero= :datoGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.executeUpdate();
	}

	@Override
	public Persona buscarPorCedulaApellidoTyped(String cedula, String apellido) {
		// TODO Auto-generated method stub

		TypedQuery<Persona> myQuery = this.entityManager.createQuery(
				"SELECT p FROM Persona p WHERE p.cedula= :datoCedula AND p.apellido= :datoApellido", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getSingleResult();

	}

	@Override
	public Persona buscarPorCedulaApellidoNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarCedulaApellido");
		myQuery.setParameter("datoCedula", cedula);
		myQuery.setParameter("datoApellido", apellido);

		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaApellidoTypedNamed(String cedula, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarCedulaApellido",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getSingleResult();
	}

}
