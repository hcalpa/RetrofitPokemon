package com.example.andre.retrofitpoke.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andre on 26/05/2017.
 */

public class Ability {

    //Clase que recorre el array
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("ability")
    @Expose
    private Ability_ ability;

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Ability_ getAbility() {
        return ability;
    }

    public void setAbility(Ability_ ability) {
        this.ability = ability;
    }
}
