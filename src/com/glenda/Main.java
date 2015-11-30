package com.glenda;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> menu = new ArrayList<>();
        ArrayList<Double> qtddrinksSold = new ArrayList<>();
        ArrayList<Double> priceCharged = new ArrayList<>();
        ArrayList<Double> costToMAke = new ArrayList<>();
        //ArrayList<Double> profit = new ArrayList<>();
       // ArrayList<String> quantidade = new ArrayList<>();

        //double profit = (costToMAke-priceCharged)*quantidade;


        //try {
           /* FileReader reader = new FileReader("src/coffee.txt");

            BufferedReader bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();

            while (line != null) {


                line = bufReader.readLine();
                System.out.println(line);
                String firstposition = line.split("\\;")[0];
                menu.add(firstposition);


            }
            bufReader.close();
        } catch (IOException ioe) {
            System.out.println("Could not read file coffee.txt");
            System.out.println(ioe.toString());

        }*/

        // The name of the file to open.
        String fileName = "src/coffee.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String firstposition = line.split(";")[0];
                menu.add(firstposition);
                System.out.println(line);

                //Swap this and the next thing around - priceCharged and costToMake are backwards
                String secondposition = line.split(";")[1];
                Double temp1 = Double.parseDouble(secondposition);
                costToMAke.add(temp1);
                //line = bufReader.readLine();

                String thirdposition = line.split(";")[2];
                Double temp2 = Double.parseDouble(thirdposition);
                priceCharged.add(temp2);
                //line = bufReader.readLine();

            }

            // Fechando o arquivo
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");


    }

        //System.out.println(menu);
        Scanner scanner = new Scanner(System.in);
        //Loop para pegar quantidade total de cade bebida vendida

        for (String drink : menu) {
            boolean validation = true;


            do {
                System.out.println("How many " + drink + " drinks did you sell?");
                String qtdTotalDrinks = scanner.nextLine();
                //qtddrinksSold.add(qtdTotalDrinks);
                //Validando o numbera enviado pelo usuario.
                //Se for menor que zero ou outro valor que não seja
                // numerido, print uma mensagem de erro e retorna para que
                //o usuario entre um valor valido.
                try {
                    double checknumber = Double.parseDouble(qtdTotalDrinks);

                    if (checknumber < 0) {
                        System.out.println("This number is not valid number.. Try again\n");
                        validation = true;


                    } else {
                        //(checknumber<0){
                        qtddrinksSold.add(checknumber);
                        validation = false;
                    }


                } catch (NumberFormatException nfe) {

                    System.out.println("This is a invalid number");
                    validation = true;
                }

            } while (validation == true);

        }


        //Set coffee object's name to "Cappuccino" and price to $3.50
        //CoffeeDrink coffee = new CoffeeDrink("Cappuccino", 3.50);

        //Without the constructor, we need to call the set methods.
        //   coffee.setName("Cappuccino");
        //   coffee.setPrice(3.50);


        /*
        //Before constructor - create CoffeeDrink object then call
        //the setName and setPrice methods.
        CoffeeDrink latte = new CoffeeDrink();
        latte.setName("Latte");
        latte.setPrice(3.00);
        */

        for (int i = 0 ; i < menu.size() ; i++) {


            CoffeeDrink drink = new CoffeeDrink(menu.get(i),costToMAke.get(i),priceCharged.get(i),qtddrinksSold.get(i));

            //Set the values of the things you know
            /*
            drink.setName(menu.get(i));
            drink.setCostToMake(costToMAke.get(i));
            drink.setPriceCharged(priceCharged.get(i));
            drink.setQntDrinks(qtddrinksSold.get(i));
            */

            //Now, can figure out profit
            drink.calculateProfitMade();//Calculando total ganho por cafe


            FileWriter salesReport = new FileWriter ("sales-report.txt", true);
            BufferedWriter bufWriter = new BufferedWriter(salesReport);

            bufWriter.write(drink.toString());
            bufWriter.close();
        }

        //CoffeeDrink latte = new CoffeeDrink("Latte", 3);

        //You can still call the get and set methods if you need

        //For example, what if you need to get name of latte?

        //System.out.println(latte.getName());

        //And the price of latte?

        //System.out.println("A latte costs $" + latte.getPrice());

        //Perhaps we need to change the price....

        //latte.setPrice(3.15);

        //get new price....

        //System.out.println("A latte costs $" + latte.getPrice());
    }
}

