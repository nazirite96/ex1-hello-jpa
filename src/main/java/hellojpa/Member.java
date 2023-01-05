package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "member_seq")
    private Long id;

//    @Column(name="name" ,insertable = true,updatable = true)
//    @Column(name="name" ,nullable = false) //
//    @Column(name="name" ,unique = true) //유니크 제약 조건 not null 제약 조건 하지만 이름이 랜덤이라 사용하지 않는다.
//@Table의 uniqueConstraints와 같지만 한 커럼에 간단히 유니크 제약 조건을 걸 때 사용한다.
//    @Column(name="name" ,columnDefinition = "varchar(100) default 'EMPTY'") // 데이터베이스 커럼 정보를 직접 줄 수 있다.
    @Column(name="name")
    private String username;

    private int age;

    //ENUM 타입은 기본이 ordinary이지만 무조건 STRING으로 바꾸어라!! 운영 시 장애에 심각한 영향을 줄 수 있다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    //private LocalDateTime createDate; 대체 가능

    @Temporal(TemporalType.TIMESTAMP)//템프롤은 이제는 필요가 없다
    private Date lastModifiedDate;



    @Lob
    private String description; // 매핑하는 필드 타입이 문자면 CLOB , 나머지는 BLOB 매핑


    public Member() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
