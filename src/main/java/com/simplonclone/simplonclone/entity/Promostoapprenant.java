package com.simplonclone.simplonclone.entity;

import jakarta.persistence.*;

@Entity
@IdClass(PromostoapprenantPK.class)
public class Promostoapprenant {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "promoId")
    private int promoId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "apprenantId")
    private int apprenantId;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public int getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(int apprenantId) {
        this.apprenantId = apprenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promostoapprenant that = (Promostoapprenant) o;

        if (promoId != that.promoId) return false;
        if (apprenantId != that.apprenantId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + apprenantId;
        return result;
    }
}
