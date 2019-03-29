import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="konto_table")
public class Konto {
    @Version
    private int laas=0;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "saldo")
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean trekk(double belop) {
        if (belop > 0) {
            this.saldo -= belop;
            return true;
        } else {
            return false;
        }
    }

    public boolean leggTil(double belop){
        if (belop > 0) {
            this.saldo += belop;
            return true;
        } else {
            return false;
        }
    }

}
