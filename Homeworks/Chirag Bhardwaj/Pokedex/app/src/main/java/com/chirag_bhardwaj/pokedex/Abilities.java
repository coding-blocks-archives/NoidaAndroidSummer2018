package com.chirag_bhardwaj.pokedex;

import java.io.Serializable;

class Abilities implements Serializable {
    Integer slot;
    Ability ability;

    public Abilities(Integer slot, Ability ability) {
        this.slot = slot;
        this.ability = ability;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}