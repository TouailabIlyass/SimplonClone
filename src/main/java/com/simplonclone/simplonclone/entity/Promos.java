package com.simplonclone.simplonclone.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Promos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "promostoapprenant",
            joinColumns = @JoinColumn(name = "promoId"),
            inverseJoinColumns = @JoinColumn(name = "apprenantId")
    )
    private Collection<Apprenant> apprenantsPerPromo;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<Brief> briefsById;
    @ManyToOne
    @JoinColumn(name = "formateurId", referencedColumnName = "id", insertable = false, updatable = false)
    private Formateur formateurByFormateurId;
    @Basic
    @Column(name = "formateurId")
    private Integer formateurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promos promos = (Promos) o;

        if (id != promos.id) return false;
        if (name != null ? !name.equals(promos.name) : promos.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Apprenant> getApprenantsById() {
        return apprenantsPerPromo;
    }

    public Collection<Brief> getBriefsById() {
        return briefsById;
    }

    public void setBriefsById(Collection<Brief> briefsById) {
        this.briefsById = briefsById;
    }

    public Formateur getFormateurByFormateurId() {
        return formateurByFormateurId;
    }

    public void setFormateurByFormateurId(Formateur formateurByFormateurId) {
        this.formateurByFormateurId = formateurByFormateurId;
    }

    public Integer getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(Integer formateurId) {
        this.formateurId = formateurId;
    }

    public void setApprenantsPerPromo(Collection<Apprenant> apprenantsPerPromo) {
        this.apprenantsPerPromo = apprenantsPerPromo;
    }
}
