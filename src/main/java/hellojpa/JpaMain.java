package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            /** 1. 회원 등록 */
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member); // EntityManager의 1차캐시에 들어감 (영속성을 갖게됨)

            /** 2. 회원 수정 */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            /** 3. 회원 단건 조회 */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            /** 4. 회원 삭제 */
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            /** JPQL - 1. 전체 회원 조회 */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member" + member.getId() +".getName() = " + member.getName());
//            }

            /** JPQL - 2. 페이지네이션 (슬라이스 해서 조회??) */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(4)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member" + member.getId() +".getName() = " + member.getName());
//            }

            /** 영속성 컨텍스트1 */
//            // 비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            /** 영속성 컨텍스트2 - 1차 캐시에서 조회 */
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, 101L);
//
//              // tx.commit()이 발동되기 전이라, 아직 Entity는 EntityManager의 1차캐시에 있기
//              // 때문에, 쿼리가 프린트문 다음에 나온다.
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            /** 영속성 컨텍스트2 - DB에서 조회 */
//            // 영속
//            // select문이 한번만 뜸 (원래 다른 엔티티 조회하면 두번 뜸)
//            // 이유는 처음 조회할때만 쿼리가 작동되고, 그 다음에는 Entity가 EntityManager의 1차캐시에 저장되기 때문
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

            /** 영속성 컨텍스트2 - 영속성 엔티티의 동일성 보장 */
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2));

            /** 영속성 컨텍스트2 - 트랜잭션을 지원하는 쓰기지연 */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            em.flush(); // flush를 해주면 쿼리문이 여기서 발생됨 (여기서 플러쉬 되기 때문).
//
//            System.out.println("=== 이거 이후로 쿼리문이 나올거임 ===");

            /** 영속성 컨텍스트2 - 변경감지(dirty checking) */
//            Member findmember = em.find(Member.class, 150L);
//            findmember.setName("ZZZZ");
//
//            System.out.println("findmember.getName() = " + findmember.getName());

            /** 영속성 컨텍스트2 - 엔티티 삭제(지움) */
//            Member findmember = em.find(Member.class, 160L);
//
//            em.remove(findmember);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
