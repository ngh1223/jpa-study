package com.ngh;

import javax.persistence.*;


@Entity(name = "Member")
@Table(
    name="member",
    schema = "jpa",
    uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UQ", columnNames = {"name", "age"})}
)
public class Member {

    @Id
    @Column(columnDefinition = "VARCHAR(10)")
    private String id;
    @Column(columnDefinition = "VARCHAR(10)")
    private String name;

    private Integer age;

    private String ageName;

    // DB와 상관없는 필드
    @Transient
    private String nothing;

    // persistence 설정덕분에 snake case 로 자동으로 변환된다. (hibernate4 기준)
    private String camelCase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // ageName 에 getter 로 접근
    @Access(AccessType.PROPERTY)
    public String getAgeName() {
        return age + name;
    }

    public void setAgeName(String ageName) {
        this.ageName = ageName;
    }
}
