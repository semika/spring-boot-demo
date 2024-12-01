package com.semika.demo.user.controller;

import com.semika.demo.common.ThaproResponse;
import com.semika.demo.user.model.dto.UserDto;
import com.semika.demo.user.service.UserService;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/user") 
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping()
	public ThaproResponse<UserDto> createUser(@RequestBody UserDto userDto) {
		userService.createUser(userDto);
		ThaproResponse<UserDto> responseDto = new ThaproResponse<>();
		responseDto.setMessage("User creation successful");
		responseDto.setData(userDto);
		return responseDto;
	}

	@PutMapping("/{id}")
	public ThaproResponse<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
		userService.updateUser(id, userDto);
		ThaproResponse<UserDto> responseDto = new ThaproResponse<>();
		responseDto.setMessage("User update successful");
		responseDto.setData(userDto);
		return responseDto;
	}

	/**
	 * The purpose of this method is to observe, how this method behaves when making concurrent requests
	 * to increase the age field. If no handled properly, there can be dirty updates.
	 * @param id
	 * @param userDto
	 * @return
	 */
	@PutMapping("/{id}/increment-age")
	public ThaproResponse<UserDto> alterAge(@PathVariable Long id) {
		ThaproResponse<UserDto> responseDto = null;
		UserDto userDto = userService.alterAge(id);
		responseDto = new ThaproResponse<>();
		responseDto.setMessage("User update successful");
		responseDto.setData(userDto);
        return responseDto;
	}

	private ThaproResponse<UserDto> retryAlterAge(Long id) {
		UserDto userDto = userService.alterAge(id);
		ThaproResponse<UserDto> responseDto = new ThaproResponse<>();
		responseDto.setMessage("User update successful");
		responseDto.setData(userDto);
		return responseDto;
	}


	@GetMapping
	public ThaproResponse<UserDto> findAllUsers() {
		List<UserDto> dataList = userService.findAll();
		ThaproResponse<UserDto> response = new ThaproResponse<UserDto>();
		response.setDataList(dataList);
		response.setMessage("success");
		return response;
	}

	@GetMapping("/{id}")
	public ThaproResponse<UserDto> findById(@RequestParam Long id) {
		ThaproResponse response = ThaproResponse.builder()
				.message("success")
				.dataList(new ArrayList<>())
				.build();
		return response;
		//return userService.findById(id, searchFilter);
	}
}
