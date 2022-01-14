package com.fatou.OneToOne8.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fatou.OneToOne8.entity.Passport;
import com.fatou.OneToOne8.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger travel = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	
	public Student findById(Long id) {
	 return em.find(Student.class, id);
		
	}
	
	public Student save(Student student) {
		if(student == null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return null;
	}
	public void deletedBy(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	public void saveWithPassport() {
		Passport passport = new Passport("15N865");
		em.persist(passport);
		
		Student student = new Student("Fatoumata");
		student.setPassport(passport);
		em.persist(student);
		
		
		
		
		
		
	}

}
