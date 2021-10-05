package com.tranjt.springboot.crudedemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tranjt.springboot.crudedemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the current hiberate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the curret hibernate session
		Session curreSession = entityManager.unwrap(Session.class);

		// get the employee
		Employee theEmployee = curreSession.get(Employee.class, theId);

		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// get the curret hibernate session
		Session curreSession = entityManager.unwrap(Session.class);

		// save employee
		curreSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void delete(int theId) {

		// get the curret hibernate session
		Session curreSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery =
				curreSession.createQuery(
							"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
