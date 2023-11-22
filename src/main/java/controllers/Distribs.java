package controllers;


public class Distribs {

    private String name;
    private Categories categorie;
    private int year;

    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name=n;
    }
    public Categories getCategorie() {
        return categorie;
    }
    public void setCategorie(Categories c) {
        this.categorie=c;
    }

    public int getYear(){
        return year;
    }
    public void setYear(int y){
        this.year=y;
    }

}
