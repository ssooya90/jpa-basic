package hellojpa;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@Setter
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// 절대 업데이트 되지 않음. updatable = false
	@Column(name = "name" , nullable = false)
	private String username;

	private int age;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	private LocalDateTime localDateTime;




	@Lob
	private String description;

	// 임시용
	@Transient
	private int temp;

	// JPA는 반드시 기본 생성자가 있어야 함
	public Member() {

	}
}
