package hellojpa4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

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

    /** 일대일[1:1]: 주 테이블(Member)에 외래키 단방향 */
    // => 결론 주 테이블에 외래키 놓고 사용해라 1:1 할거면
    @OneToOne
    @JoinColumn(name = "Locker_ID")
    private Locker locker;

//    /** 다대다[N:M]: 객체는 컬렉션을 사용해 객체 2개로 다대다 관계 가능 */
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    /** 다대다를 -> 일대다,다대일로 바꾸고 JoinTable을 Entitiy로 승격시킴! */
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();




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
