package com.ngh.domain.key;

import java.io.Serializable;
import java.util.Objects;

public class ParentIdClass implements Serializable {
    private String id1;
    private String id2;

    public ParentIdClass() {}

    public ParentIdClass(String i1, String i2) {
        this.id1 = i1;
        this.id2 = i2;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentIdClass parentId = (ParentIdClass) o;
        return id1.equals(parentId.id1) && id2.equals(parentId.id2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id1, id2);
    }
}
