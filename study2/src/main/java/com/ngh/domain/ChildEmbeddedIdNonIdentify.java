package com.ngh.domain;


import javax.persistence.*;

@Entity
public class ChildEmbeddedIdNonIdentify {

    @Id
    String id;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1", referencedColumnName = "parent_id1"),
            @JoinColumn(name = "parent_id2", referencedColumnName = "parent_id2")
    })
    private ParentEmbeddedIdNonIdentify parent;

    public ParentEmbeddedIdNonIdentify getParent() {
        return parent;
    }
}
