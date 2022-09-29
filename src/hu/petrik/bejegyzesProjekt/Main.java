package hu.petrik.bejegyzesProjekt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Veréb Ádám", "Valami");
        Bejegyzes b2 = new Bejegyzes("Optimus Primniga", "Ezt uzenem minden autobotnak!");
        Scanner sc = new Scanner(System.in);
        Bejegyzesek _bejegyzesek = new Bejegyzesek(new Bejegyzes[]{b1, b2});
        int db;

        System.out.print("Hany darab bejegyzest szeretnel hozzaadni?\n");


        while (!sc.hasNextInt()){
            System.out.print("Pozitiv egesz szamot adj meg!");
            sc.next();
        }
        db = sc.nextInt();
        while (db <= 0){
            System.out.print("Pozitiv egesz szamot adj meg!");
            db = sc.nextInt();
        }

        for (int i = 0 ; i < db; i++)
        {
            System.out.print("add meg a bejegyzes szerzojét\n");
            String ujSzerzo =  sc.next();
            System.out.print("add meg a bejegyzes tartalmat\n");
            String ujTartalom =  sc.next();
            _bejegyzesek.getBejegyzesek().add(new Bejegyzes(ujSzerzo, ujTartalom));
        }

        try
        {
            _bejegyzesek.getBejegyzesek().addAll(new Bejegyzesek("bejegyzesek.csv").getBejegyzesek());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("hiba bejegyzesek.csv nem talalhato");
        }
        catch (IOException e)
        {
            System.err.println("hiba");
        }

        System.out.print(_bejegyzesek.getBejegyzesek());






    }
}
