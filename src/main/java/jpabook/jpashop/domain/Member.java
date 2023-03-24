package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@ManyToOne // 멤버 입장에서는 many, 팀 입장에서는 one
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	private String username;

}
