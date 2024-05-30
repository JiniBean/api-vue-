package kr.co.rland.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
	@Id
	private Long id;
	private String username;
	private String pwd;
	private String email;
	private Date regDate;

	@OneToMany
	List<MemberRole> roles;

}
