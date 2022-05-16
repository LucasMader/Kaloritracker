package htwberlinwebtech.Kalotracker.Persistence;

import javax.persistence.*;

@Entity(name = "Food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "kohlenhydrate", nullable = false)
    private long kohlenhydrate;
    @Column(name = "fett", nullable = false)
    private long Fett;
    @Column(name = "eiweiss", nullable = false)
    private long Eiweiß;
    @Column(name = "kalorien", nullable = false)
    private long Kalorien;


    public FoodEntity(String name, long kohlenhydrate, long fett, long eiweiß, long kalorien) {
        this.name = name;
        this.kohlenhydrate = kohlenhydrate;
        Fett = fett;
        Eiweiß = eiweiß;
        Kalorien = kalorien;
    }

    public FoodEntity() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getKohlenhydrate() {
        return kohlenhydrate;
    }

    public void setKohlenhydrate(long kohlenhydrate) {
        this.kohlenhydrate = kohlenhydrate;
    }

    public long getFett() {
        return Fett;
    }

    public void setFett(long fett) {
        Fett = fett;
    }

    public long getEiweiß() {
        return Eiweiß;
    }

    public void setEiweiß(long eiweiß) {
        Eiweiß = eiweiß;
    }

    public long getKalorien() {
        return Kalorien;
    }

    public void setKalorien(long kalorien) {
        Kalorien = kalorien;
    }
}
