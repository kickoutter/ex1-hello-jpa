package hellojpa3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;

    /** 일대일[1:1]: 주 테이블(Member)에 외래키 양방향 */
    // Member와 양방향을 만들고 싶다면? mappedBy 적용
    @OneToOne(mappedBy = "locker")
    private Member member;

}
