package com.ngh.domain;


import javax.persistence.*;

@Entity
public class ChildIdClassNonIdentify {
    @Id
    private String id;

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "parent_id1"),
                    @JoinColumn(name = "parent_id2")
            }
    )
    private ParentIdClassNonIdentify parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParentIdClassNonIdentify getParent() {
        return parent;
    }

    public void setParent(ParentIdClassNonIdentify parent) {
        this.parent = parent;
    }
}
