package com.cursos_online;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;

public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		
		Curso curso1 = new Curso("Fundamento de Java");
		Curso curso2 = new Curso("Hibernate para Novatos");
		ingresarCurso(curso1);
		ingresarCurso(curso2);
		
		List<Curso> cursos = getCursos();
		for (Curso temp:cursos) {
			System.out.println(temp);
		}
		Curso cursoss = new Curso(1,"Fundamento de Python");
		modificarCurso(cursoss);

		
		Estudiante est1= new Estudiante("Elvis","Calderon");
		Estudiante est2= new Estudiante("Melanie","Garcia");
		Estudiante est3= new Estudiante("Melanie","Lopez");
		ingresarEstudiante(est1);
		ingresarEstudiante(est2);
		ingresarEstudiante(est3);
		List<Estudiante> estudiantes = getEstudiante();
		for(Estudiante temp:estudiantes){
			System.out.println(temp);
		}
		List<Estudiante> estudiante = getEstudiantesPorNombre("Melanie");
		for(Estudiante e:estudiante){
			System.out.println(e);
		}
		Estudiante est0= new Estudiante(3,"Elvis","Vera");
		modificarEstudiante(est0);
		
		

	}
	static void ingresarCurso(Curso curso){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(curso);
		
		session.getTransaction().commit();
		session.close();
	}
	static void ingresarEstudiante(Estudiante estudiante){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(estudiante);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(estudiante.getId());
	}
	static List<Curso> getCursos(){
		Session session = sessionFactory.openSession();
		List<Curso> cursos= session.createQuery("from Curso", Curso.class).list();
		return cursos;
	}
	static List<Estudiante> getEstudiante(){
		Session session = sessionFactory.openSession();
		List<Estudiante> estudiantes= session.createQuery("from Estudiante", Estudiante.class).list();
		return estudiantes;
	}
	static List<Estudiante> getEstudiantesPorNombre(String nombres){
		Session session = sessionFactory.openSession();
		Query query= session.createQuery("from Estudiante where nombre=:nombre");
		query.setParameter("nombre",nombres);
		List<Estudiante> estudiantes=(List<Estudiante>)query.getResultList();
		return estudiantes;
	}
	
	
	static void modificarCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(curso);
		session.getTransaction().commit();
		session.close();
		
	}
	static void eliminarCurso(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(id);
		session.getTransaction().commit();
		session.close();
	}
	static void modificarEstudiante(Estudiante estudiante) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(estudiante);
		session.getTransaction().commit();
		session.close();
		

	}
	static void eliminarEstudiante(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(id);
		session.getTransaction().commit();
		session.close();
	}

}
