package com.ngh.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("N")
@PrimaryKeyJoinColumn(name = "naver_id")
@Table(name = "naver_join_strategy")
public class NaverJoinStrategy extends SiteJoinStrategy{

    @Column(name = "nick_name")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
