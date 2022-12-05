package com.ngh.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("N")
@Table(name = "naver_table_per_class_strategy")
public class NaverTablePerClassStrategy extends SiteTablerPerClassStrategy{

    @Column(name = "nick_name")
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
