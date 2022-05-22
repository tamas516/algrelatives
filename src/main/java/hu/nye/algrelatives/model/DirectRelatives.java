package hu.nye.algrelatives.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "direct_relatives")
public class DirectRelatives {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="relative_id2")
    private int relative_id2;

    @OneToOne(mappedBy = "directRelatives")
    Relative relative;

    @OneToOne(mappedBy = "directRelatives")
    KinshipType kinshipType;

    @Column(name="direct_kinship_type_id")
    private int direct_kinship_type_id;




    public DirectRelatives() {
    }

    public DirectRelatives(int relative_id2, int direct_kinship_type_id) {
        this.relative_id2 = relative_id2;
        this.direct_kinship_type_id = direct_kinship_type_id;
    }

    public int getRelative_id2() {
        return relative_id2;
    }

    public void setRelative_id2(int relative_id2) {
        this.relative_id2 = relative_id2;
    }

    public int getDirect_kinship_type_id() {
        return direct_kinship_type_id;
    }

    public void setDirect_kinship_type_id(int direct_kinship_type_id) {
        this.direct_kinship_type_id = direct_kinship_type_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectRelatives that = (DirectRelatives) o;
        return relative_id2 == that.relative_id2 && direct_kinship_type_id == that.direct_kinship_type_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relative_id2, direct_kinship_type_id);
    }

    @Override
    public String toString() {
        return "DirectRelatives{" +
                "relative_id2=" + relative_id2 +
                ", direct_kinship_type_id=" + direct_kinship_type_id +
                '}';
    }
}
