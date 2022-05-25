package hellojpa2;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member2 {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    // EnumType은 무조건 EnumType.STRING으로 써야한다!!
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // 과거 자바 버젼에는 LocalDate라는 타입이 없어서 이런방식으로 해야한다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

//    // 최신 자바 버젼은
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

    // 매핑 하기 싫으면 이거 사용, 메모리상에서 임시로 값 보고싶을 씀
    @Transient
    private int temp;


    public Member2() {
    }

    public Member2(Long id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, String description) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
