package hu.nye.algrelatives.model;

import javax.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "relative_data")
public class Relative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="relative_id")
    private int relative_id;
    @Column(name="complete_name")
    private String completename;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "relative_id")
    DirectRelatives directRelatives;

    public Relative() {
    }

    public Relative(int relative_id, String complete_name) {
        this.relative_id = relative_id;
        this.completename = complete_name;
    }

    public int getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(int relative_id) {
        this.relative_id = relative_id;
    }

    public String getComplete_name() {
        return completename;
    }

    public void setComplete_name(String complete_name) {
        this.completename = complete_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relative relative = (Relative) o;
        return relative_id == relative.relative_id && Objects.equals(completename, relative.completename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relative_id, completename);
    }

    @Override
    public String toString() {
        return "Relative{" +
                "relative_id=" + relative_id +
                ", complete_name='" + completename + '\'' +
                '}';
    }
}
