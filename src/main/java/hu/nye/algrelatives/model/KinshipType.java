package hu.nye.algrelatives.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kinship_types")
public class KinshipType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="direct_name_id")
    private int direct_name_id;
    @Column(name="sd_name")
    private String originname;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "direct_name_id")
    DirectRelatives directRelatives;

    public KinshipType() {
    }

    public KinshipType(int direct_name_id, String originname) {
        this.direct_name_id = direct_name_id;
        this.originname = originname;
    }

    public int getDirect_name_id() {
        return direct_name_id;
    }

    public void setDirect_name_id(int direct_name_id) {
        this.direct_name_id = direct_name_id;
    }

    public String getOriginname() {
        return originname;
    }

    public void setOriginname(String originname) {
        this.originname = originname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KinshipType that = (KinshipType) o;
        return direct_name_id == that.direct_name_id && Objects.equals(originname, that.originname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direct_name_id, originname);
    }

    @Override
    public String toString() {
        return "KinshipType{" +
                "direct_name_id=" + direct_name_id +
                ", originname='" + originname + '\'' +
                '}';
    }
}
