package com.fresure.controller;

import com.fresure.entity.ERole;
import com.fresure.entity.RoleEntity;
import com.fresure.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	RoleRepository roleRepository;


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@PostMapping("/createRole")
	public String adminAccess(@RequestBody String role) {
		RoleEntity roleEntity1 = new RoleEntity(ERole.ROLE_ADMIN);
		roleRepository.save(roleEntity1);
		RoleEntity roleEntity2 = new RoleEntity(ERole.ROLE_MODERATOR);
		roleRepository.save(roleEntity2);
		RoleEntity roleEntity3 = new RoleEntity(ERole.ROLE_USER);
		roleRepository.save(roleEntity3);
		return "success";
	}

}
