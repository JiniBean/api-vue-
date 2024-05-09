package kr.co.rland.api.entity;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long id;
	private String username;
	private String pwd;
	private String email;
	private Date regDate;
    
}
