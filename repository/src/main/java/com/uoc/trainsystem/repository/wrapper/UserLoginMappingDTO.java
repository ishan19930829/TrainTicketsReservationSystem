package com.uoc.trainsystem.repository.wrapper;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "UserLoginDetails" , entities = {
		@EntityResult(entityClass = UserLoginMappingDTO.class , fields = {
				@FieldResult(name = "id" , column = "id"),
				@FieldResult(name = "firstName" , column = "frist_name"),
				@FieldResult(name = "secondName" , column = "second_name"),
				@FieldResult(name = "userName" , column = "user_name"),
				@FieldResult(name = "email" , column = "email"),
		})
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserLoginMappingDTO {

	@Id
	private Long id;
	private String firstName;
	private String secondName;
	private String userName;
	private String email;
	
}
