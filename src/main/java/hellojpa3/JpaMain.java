package hellojpa3;

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

            /** 객체를 테이블에 맞추어 모델링 */
//            // 팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 회원 저장
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeamId(team.getId());
//            em.persist(member2);
//
//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("========================================");
//            System.out.println("findMember.getName() = " + findMember.getUsername());
//            System.out.println("========================================");
//
//            // 연관관계가 없음
//            Team findTeam = em.find(Team.class, team.getId());
//            System.out.println("========================================");
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            System.out.println("========================================");

            /** 객체 지향 모델링 */
//            // 팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // 회원 저장
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team); // 단방향 연관관계 설정, 참조 저장
//            em.persist(member);
//
//            // 이걸 해줘야 DB에서 깔끔하게 값을 가져옴
//            em.flush();
//            em.clear();

//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            // 참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            System.out.println("findTeam.getId() = " + findTeam.getId());
//
//            // 새로운 팀B
//            Team teamB = new Team();
//            teamB.setName("TeamB");
//            em.persist(teamB);
//
////            Team teamC = new Team();
////            teamC.setName("TeamC");
////            em.persist(teamC);
//
//            // 회원1에 새로운 팀B 설정
//            member.setTeam(teamB);
////            findMember.setTeam(teamC);
//
//            Team updateFindTeam = findMember.getTeam();
//            System.out.println("updateFindTeam.getName() = " + updateFindTeam.getName());
//            System.out.println("updateFindTeam.getId() = " + updateFindTeam.getId());

            /** 양방향 연관관계와 연관관계 주인1 */
            /** => 외래키가 있는 곳을 주인으로 정해라! */
//            // Member -> Team을 조회해보기
//            Member findMember = em.find(Member.class, member.getId());
//            Team findMemberTeam = findMember.getTeam();
//            System.out.println("findMemberTeam.getName() = " + findMemberTeam.getName());
//
//            // Team -> Member을 조회해보기 가능하므로 양방향
//            List<Member> members = findMemberTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

            /** 양방향 연관관계와 연관관계 주인 2 - 주의점, 정리 */
            /** 1) 양방향 매핑 시 가장 많이 하는 실수: 연관관계의 주인에 값을 입력하지 않음 (Member에 안하고 Team에 값 입력) */
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            // 역방향(주인이 아닌 방향)만 연관관계 설정
            // 연관관계의 양방향 다, 양쪽에 다 넣어 주어야함
//            member.changeTeam(team);
            // 이건 안된다 주인이 아니라 넣을 수 없음, 하지만 넣어줌 (연관관계 편의 메소드로서 Member객체에 setTeam메소드에 정의되어있음)
//            team.getMembers().add(member); // 따라서 안써도 됨

            // 이 위의 것을 한번에 하기 위해! 연관관계 편의 메소드 addMember()를 따로 만들어줌
            team.addMember(member);

            em.flush();
            em.clear();

            // ?? 항상 em.find할때, Id값으로만 얻어와서 조회 해야하는지 궁금함
            Team findTeam = em.find(Team.class, team.getId());
            System.out.println("findTeam = " + findTeam);

            List<Member> members = findTeam.getMembers();
            System.out.println("members.get(0) = " + members.get(0).getUsername());


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
