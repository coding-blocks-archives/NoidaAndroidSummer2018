package com.example.dell.pokedex;

import java.io.Serializable;

public class abilities implements Serializable {
    ability ability;
    public abilities(ability ability){
        this.ability=ability;
    }
    public ability getAbility() {
        return ability;
    }
 //   n mn;
//public abilities(n mn){
  //  this.mn=mn;
//}

  //  public void setMn(n mn) {
    //    this.mn = mn;
    //}

//    public n getMn() {
  //      return mn;
    //}
}
