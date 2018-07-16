package com.chirag_bhardwaj.pokedex;

import java.io.Serializable;

class Stats implements Serializable {
    Stat stat;
    Integer effort, base_stat;

    public Stats(Stat stat, Integer effort, Integer base_stat) {
        this.stat = stat;
        this.effort = effort;
        this.base_stat = base_stat;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Integer getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(Integer base_stat) {
        this.base_stat = base_stat;
    }
}