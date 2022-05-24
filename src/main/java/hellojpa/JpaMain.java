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
//            em.persist(member);

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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(4)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member" + member.getId() +".getName() = " + member.getName());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
