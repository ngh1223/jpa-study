package com.ngh.domain;


import com.ngh.domain.key.ChildId;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class ChildIdClassIdentify {
    @Id
    @Column(name="child_id")
    private String childId;

    @Id
    @ManyToOne
    @JoinColumn(name = "parent_id")
    public ParentIdClassIdentify parent;

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public ParentIdClassIdentify getParent() {
        return parent;
    }

    public void setParent(ParentIdClassIdentify parent) {
        this.parent = parent;
    }
}
