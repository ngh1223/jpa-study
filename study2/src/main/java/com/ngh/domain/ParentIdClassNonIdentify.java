package com.ngh.domain;

import com.ngh.domain.key.ParentIdClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ParentIdClass.class)
public class ParentIdClassNonIdentify {
    @Id
    @Column(name="parent_id1")
    private String id1;

    @Id
    @Column(name = "parent_id2")
    private String id2;

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}
