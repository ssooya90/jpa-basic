package hellojpa;

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

		// 실제 구현부


		try {

//
////			// 비영속
////			Member member = new Member();
////			member.setId(101L);
////			member.setName("helloPAAA");
////
////			// 영속 (entity manager에 의해서 관리되기 시작)
////
////			System.out.println("=== BEFORE ==");
////			em.persist(member);
//////			em.detach(member); // 영속성 컨텍스트에서 분리 (즉 준영속 상태로 만듦)
////			System.out.println("=== AFETR ==");
//
//
//			Member findMember1 = em.find(Member.class, 101L);
//			Member findMember2 = em.find(Member.class, 101L);

			// findMember1에서 조회할 때 1차 캐시에 저장하므로
			// findMemeber2는 select 쿼리를 날리지 않고 1차 캐시에서 가져옴 (즉 쿼리는 한번만 날림)

//			System.out.println("아이디 " + findMember1.getId());
//			System.out.println("이름 " + findMember1.getName());



//
//
//			Member member1 = new Member(150L , "A");
//			Member member2 = new Member(160L , "B");
//
//			em.persist(member1);
//			em.persist(member2);
//
//			System.out.println("=============");
//
//
//			tx.commit();
//			// 쿼리 날아감



			// update는 Dirty Checking(변경 감지)를 한다.
			// persist를 할 필요가 없음
			// 1차 캐시에 id, entity, 스냅샷이 있음. entity = 스냅샷을 비교하여 변경이 있는 경우 JPA가 알아서 update 쿼리를 만듬

			Member member = em.find(Member.class, 150L);
			member.setName("ZZZZ");



			tx.commit();






//			Member findMember = em.find(Member.class, 1L);
//			findMember.setName("HelloJPA");

			// 테이블이 아닌, 객체를 대상으로 쿼리 생성

			tx.commit();

			// 커밋을 하는 시점에 엔티티 매니저에 있는 ..?


		} catch (Exception e){
			tx.rollback();
		} finally {
			em.close();
		}


		emf.close();







	}
}
