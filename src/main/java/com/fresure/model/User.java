package com.fresure.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
	private Long id;

	@NotNull
	@Size(max = 20)
	private String username;

	@Nullable
	@Size(max = 100)
	private String email;

	@NotNull
	@Size(max = 120)
	private String password;

	private Set<String> roles = new HashSet<>();

	private String firstName;

	@Nullable
	private String middleName;

	private String lastName;

	private String mobileNumber;

	private Set<Address> addresses= new HashSet<>();

	private boolean isActive;

	public void addAddress(Address address){
		this.addresses.add(address);
	}

}
