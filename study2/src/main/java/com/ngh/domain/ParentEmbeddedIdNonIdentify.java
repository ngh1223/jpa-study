package com.ngh.domain;

import com.ngh.domain.key.ParentEmbeddedId;
import com.ngh.domain.key.ParentIdClass;

import javax.persistence.*;

@Entity
public class ParentEmbeddedIdNonIdentify {

    @EmbeddedId
    private ParentEmbeddedId id;

    public ParentEmbeddedId getId() {
        return id;
    }

    public void setId(ParentEmbeddedId id) {
        this.id = id;
    }
}
