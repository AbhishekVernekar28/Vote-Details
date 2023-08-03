package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Booth_dto;
import dto.UserDto;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();


	public List<UserDto> check1(String email) {
		return manager.createQuery("select x from UserDto x where email=?1").setParameter(1, email).getResultList();
	}

	public List<UserDto> check(long mobile) {
		return manager.createQuery("select x from UserDto x where mobile=?1").setParameter(1, mobile).getResultList();
	}

	public void save(UserDto userDto) {
		transaction.begin();
		manager.persist(userDto);
		transaction.commit();
	}
	public List<UserDto> fetchAll()
	{
		return manager.createQuery("select x from UserDto x").getResultList();
	}

	public void update(UserDto userDto) {
		transaction.begin();
		manager.merge(userDto);
		transaction.commit();
	}

	public UserDto login(int username) {
		return manager.find(UserDto.class, username);
	}

	public List<UserDto> fetchall() {
		return manager.createQuery("select x from UserDto x").getResultList();
	}
}
