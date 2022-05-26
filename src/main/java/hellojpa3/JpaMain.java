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

            /** 객체를 테이블에 맞추어 모델링 */
//            // 팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setTeamId(team.getId());
//            em.persist(member2);
//
//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("========================================");
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("========================================");
//
//            // 연관관계가 없음
//            Team findTeam = em.find(Team.class, team.getId());
//            System.out.println("========================================");
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            System.out.println("========================================");

            /** 객체 지향 모델링 */
            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
            em.persist(member);

//            em.flush();
//            em.clear();

            // 조회
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            // 참조를 사용해서 연관관계 조회
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());
            System.out.println("findTeam.getId() = " + findTeam.getId());

            // 새로운 팀B
            Team teamB = new Team();
            teamB.setName("TeamB");
            em.persist(teamB);

//            Team teamC = new Team();
//            teamC.setName("TeamC");
//            em.persist(teamC);

            // 회원1에 새로운 팀B 설정
            member.setTeam(teamB);
//            findMember.setTeam(teamC);

            Team updateFindTeam = findMember.getTeam();
            System.out.println("updateFindTeam.getName() = " + updateFindTeam.getName());
            System.out.println("updateFindTeam.getId() = " + updateFindTeam.getId());


            System.out.println("======================================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
