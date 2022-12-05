package com.ngh.domain;


import com.ngh.domain.key.GrandChildId;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
public class GrandChildIdClassIdentify {
    @Id
    @ManyToOne(optional = false)
    @JoinColumns(
            {
                    @JoinColumn(name = "child_id"),
                    @JoinColumn(name = "parent_id")
            }
    )
    private ChildIdClassIdentify child;

    @Id
    @Column(name = "grand_child_id")
    public String grandChildId;

    public ChildIdClassIdentify getChild() {
        return child;
    }

    public void setChild(ChildIdClassIdentify child) {
        this.child = child;
    }

    public String getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(String grandChildId) {
        this.grandChildId = grandChildId;
    }
}
