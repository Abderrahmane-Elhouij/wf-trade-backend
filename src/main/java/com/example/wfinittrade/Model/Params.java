package com.example.wfinittrade.Model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.io.Serializable;
import java.util.logging.Logger;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "params")
public class Params implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Params.class.getName());

    // Raw attributes
    private Integer id;
    private String code;
    private String libelle;
    private String lib1;
    private String lib2;
    private String lib3;


    public String entityClassName() {
        return Params.class.getSimpleName();
    }

    @Column(name = "id", precision = 10)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Params id(Integer id) {
        setId(id);
        return this;
    }
    // -- [code] ------------------------

    @Transient
    public boolean isIdSet() {
        return id != null;
    }

    @NotEmpty
    @Size(max = 4)
    @Column(name = "code", nullable = false, length = 4)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    // -- [libelle] ------------------------

    public Params code(String code) {
        setCode(code);
        return this;
    }

    @NotEmpty
    @Size(max = 100)
    @Column(name = "libelle", nullable = false, length = 100)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    // -- [lib1] ------------------------

    public Params libelle(String libelle) {
        setLibelle(libelle);
        return this;
    }

    @Size(max = 100)
    @Column(name = "lib1", length = 100)
    public String getLib1() {
        return lib1;
    }

    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }
    // -- [lib2] ------------------------

    public Params lib1(String lib1) {
        setLib1(lib1);
        return this;
    }

    @Size(max = 100)
    @Column(name = "lib2", length = 100)
    public String getLib2() {
        return lib2;
    }

    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }
    // -- [lib3] ------------------------

    public Params lib2(String lib2) {
        setLib2(lib2);
        return this;
    }

    @Size(max = 100)
    @Column(name = "lib3", length = 100)
    public String getLib3() {
        return lib3;
    }

    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }

    public Params lib3(String lib3) {
        setLib3(lib3);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Params withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Params && hashCode() == other.hashCode());
    }

    /**
     * Hash code implementation using a business key.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id, code, libelle, lib1, lib2, lib3);
    }

    /**
     * Construct a readable string representation for this Params instance.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("code", getCode()) //
                .add("libelle", getLibelle()) //
                .add("lib1", getLib1()) //
                .add("lib2", getLib2()) //
                .add("lib3", getLib3()) //
                .toString();
    }
}