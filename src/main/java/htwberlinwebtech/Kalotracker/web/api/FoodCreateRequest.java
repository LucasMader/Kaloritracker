package htwberlinwebtech.Kalotracker.web.api;

public class FoodCreateRequest {
    private String name;
    private long kohlenhydrate;
    private long Fett;
    private long Eiweiß;
    private long Kalorien;

    public FoodCreateRequest(String name, long kohlenhydrate, long fett, long eiweiß, long kalorien) {
        this.name = name;
        this.kohlenhydrate = kohlenhydrate;
        Fett = fett;
        Eiweiß = eiweiß;
        Kalorien = kalorien;
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
