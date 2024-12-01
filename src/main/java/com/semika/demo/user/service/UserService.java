package com.semika.demo.user.service;

import com.semika.demo.common.ThaproResponse;
import com.semika.demo.user.model.converter.UserConverter;
import com.semika.demo.user.model.dto.UserDto;
import com.semika.demo.user.model.entity.User;
import com.semika.demo.user.repository.UserRepository;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(
		readOnly = true
)
public class UserService {

	private UserRepository userRepository;
	private UserConverter converter;

	public UserService(UserConverter converter,
					   UserRepository userRepository) {
		this.userRepository = userRepository;
		this.converter = converter;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDto createUser(UserDto userDto) {
		User user = converter.dtoToDomain(userDto);
		userRepository.save(user);
		userDto.setId(user.getId());
		return userDto;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(Long id, UserDto userDto) {
		Optional<User> userOptional = userRepository.findById(id);
		userOptional.map((User user) -> {
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setAge(userDto.getAge());
			userRepository.save(user);
			return userDto;
		}).orElseThrow(() -> new RuntimeException("Unable to find the user"));
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDto alterAge(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.map((User user) -> {
			Integer currentAge = user.getAge();
			user.setAge(currentAge + 5);
			userRepository.save(user);
			return converter.domainToDto(user);
		}).orElseThrow(() -> new RuntimeException("Unable to find the user"));
	}

	public List<UserDto> findAll() {
		List<User> userList = userRepository.findAll();
		return userList.stream().map((User user) -> this.converter.domainToDto(user))
				.collect(Collectors.toList());
	}
}
