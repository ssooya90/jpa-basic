package hellojpa;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {


			Team team = new Team();
			team.setName("TEAM");
			em.persist(team);

			Member member = new Member();
			member.setUsername("최희수");
			member.setTeam(team);
			em.persist(member);


			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			System.out.printf("테스트" + findTeam.getName() );




			tx.commit();

		} catch (Exception e){
			tx.rollback();
		} finally {
			em.close();
		}


		emf.close();




	}
}
