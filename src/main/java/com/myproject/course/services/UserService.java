package com.myproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.myproject.course.entities.User;
import com.myproject.course.repositories.UserRepository;
import com.myproject.course.services.exceptions.DatabaseException;
import com.myproject.course.services.exceptions.ResourceNotFoundException;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();	
	}
	
	public User findById(Long id){
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj){
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		userRepository.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	public static void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}

 
