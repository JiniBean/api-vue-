package kr.co.rland.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter
// @Setter
// @ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity // hibernate가 이 엔티티 가지고 쿼리 만들거임
public class Menu {

	@Id // 얘가 식별자야
	private Long id;

	private String korName;
	private String engName;
	private Integer price;
	private String img;
	private String regDate;
	private Long categoryId;
	private Long regMemberId;

}