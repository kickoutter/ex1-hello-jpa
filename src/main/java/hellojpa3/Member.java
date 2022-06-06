package hellojpa3;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    /** 객체지향모델링, 이거 사용해라 다대일 */
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    /** Team이 연관관계 주인인 일대다 관계에 읽기전용으로 양방향 처럼 만든거이다. 쓰지마라! */
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
