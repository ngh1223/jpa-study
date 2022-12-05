package com.ngh.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("N")
public class NaverSingleTableStrategy extends SiteSingleTableStrategy{

    @Column(name = "nick_name")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
