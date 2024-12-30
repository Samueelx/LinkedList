package dev.lpa;

public class Place {
    private String town;
    private int distance;

    public Place(String town, int distance){
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Place{" +
                "town='" + town + '\'' +
                ", distance=" + distance +
                '}';
    }
}
