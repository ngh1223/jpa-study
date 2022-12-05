package com.ngh.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("D")
@Table(name = "daum_join_strategy")
public class DaumJoinStrategy extends SiteJoinStrategy{

    @Column(name = "kakao_id")
    private String kakaoId;

    public String getKakaoId() {
        return kakaoId;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }
}
