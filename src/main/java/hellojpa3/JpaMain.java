package hellojpa3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            Member member2 = new Member();
            member2.setName("member2");
            member2.setTeamId(team.getId());
            em.persist(member2);

            // 조회
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("========================================");
            System.out.println("findMember.getName() = " + findMember.getName());
            System.out.println("========================================");
            
            // 연관관계가 없음
            Team findTeam = em.find(Team.class, team.getId());
            System.out.println("========================================");
            System.out.println("findTeam.getName() = " + findTeam.getName());
            System.out.println("========================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
