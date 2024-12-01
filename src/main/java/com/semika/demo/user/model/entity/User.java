package com.semika.demo.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(
			name = "CREATED_DATE",
			updatable = false
	)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	@Column(
			name = "CREATED_BY",
			updatable = false,
			length = 15
	)
	protected String createdBy = "SYSTEM";
	@Column(
			name = "MODIFIED_DATE"
	)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
	@Column(
			name = "MODIFIED_BY",
			length = 15
	)
	protected String modifiedBy = "SYSTEM";

	@Column(
			name = "ORGANIZATION_ID"
	)
	private Long organizationId;

	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<UserAddress> addressEntityList;

	@Column(name = "age")
	private Integer age;

	//@Version
	//private int version; // Optimistic locking version field

	public String defaultSortField() {
		return "firstName";
	}
}
