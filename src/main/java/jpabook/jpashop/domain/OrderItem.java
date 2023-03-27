package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class OrderItem {

	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

//	@ManyToOne
//	@Column(name = "ITEM_ID")
//	private Item item;

	private int orderPrice;
	private int count;


}
