package com.ngh.domain.key;

import java.io.Serializable;
import java.util.Objects;

public class GrandChildId implements Serializable {
    private ChildId child;
    private String grandChildId;

    public ChildId getChild() {
        return child;
    }

    public void setChild(ChildId child) {
        this.child = child;
    }

    public String getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(String grandChildId) {
        this.grandChildId = grandChildId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrandChildId that = (GrandChildId) o;
        return Objects.equals(child, that.child) && Objects.equals(grandChildId, that.grandChildId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child, grandChildId);
    }
}
