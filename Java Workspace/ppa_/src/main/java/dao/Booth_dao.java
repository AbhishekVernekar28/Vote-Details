package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Booth_dto;

public class Booth_dao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(Booth_dto booth_dto) {
		entityTransaction.begin();
		entityManager.persist(booth_dto);
		entityTransaction.commit();
	}

	public List<Booth_dto> fetch(int boothnumber)
	{
		return entityManager.createQuery("select x from Booth_dto x where Polling_Booth_Number=?1").setParameter(1, boothnumber).getResultList();

	}
	
	public List<Booth_dto> fetch1(String boothnumber)
	{
		return entityManager.createQuery("select x from Booth_dto x where Parent_Constituency=?1").setParameter(1, boothnumber).getResultList();

	}
	
	public List<Booth_dto> fetchAll()
	{
		return entityManager.createQuery("select x from Booth_dto x").getResultList();
	}
	
	public Booth_dto find(long mob)
	{
		return entityManager.find(Booth_dto.class, mob);
	}
	

}