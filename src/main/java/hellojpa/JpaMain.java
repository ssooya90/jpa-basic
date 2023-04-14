package hellojpa;

import jpabook.jpashop.domain.Member;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Member member = new Member();
			member.setUsername("member1");
			member.setAge(20);
			em.persist(member);


			TypedQuery<Member> query = em.createQuery("select m from Member m where m.id = 10",Member.class);

//			List<Member> resultList = query.getResultList();




			System.out.println("====");
			System.out.println(query);
			System.out.println("====");

			tx.commit();

		} catch (Exception e){
			tx.rollback();
		} finally {
			em.close();
		}


		emf.close();




	}
}
