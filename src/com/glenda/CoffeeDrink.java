package com.glenda;

/**
 *
 * Represents a Coffee drink sold by a coffee shop.
 * CoffeeDrink objects have a name e.g. Cappuccino and a price e.g. $3.00.
 *
 * */
public class CoffeeDrink {

    private String nameOfDrink;
    private double costToMAke;
    private double priceCharged;
    private double profitMade;
    private double qntDrinks;

    //not used here (yet)
   // LinkedList ingredients = new LinkedList();  //you could save ingredients here



    //Constructor
    public CoffeeDrink(){}

    public CoffeeDrink(String name, double costtomake , double priceCharged, double qntDrinks) {

        this.nameOfDrink = name;
        this.costToMAke = costtomake;
        this.priceCharged = priceCharged;
        this.qntDrinks = qntDrinks;


    }

    public double getCostToMAke() {
        costToMAke = costToMAke * qntDrinks;
        return costToMAke;}

    public double getPriceCharged() {
        priceCharged = priceCharged * qntDrinks;
        return priceCharged;}

    public void setName(String name) {

        System.out.println("Calling the CoffeeDrink setName method");
        System.out.println("Setting the CoffeeDrink object's name to " + name);
        this.nameOfDrink = name;
    }

    public String getName() {return this.nameOfDrink;}

    public double setCostToMake(double costtomake) {
        this.costToMAke = costtomake;
        return costtomake;
    }

    public void setPriceCharged(double priceCharged) {

        this.priceCharged = priceCharged;
    }

    public double getProfitMade() {
        return profitMade;
    }

    public void calculateProfitMade() {

        this.profitMade = (priceCharged - costToMAke)  * qntDrinks;
    }

    public Double getQntDrinks() {
        return qntDrinks;
    }

    public void setQntDrinks(Double qntDrinks) {

        this.qntDrinks = qntDrinks;
    }

    public String toString () {
        return getName()+ " Sold "+ getQntDrinks() +" : Expenses  $" +  getCostToMAke() + ", Revenue $" + getPriceCharged() +
                " Profit " + getProfitMade()+ "\n";
    }

}
