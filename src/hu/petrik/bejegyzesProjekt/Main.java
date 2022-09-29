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

        System.out.println("Hany darab bejegyzest szeretnel hozzaadni?\n");


        while (!sc.hasNextInt())
        {
            System.out.println("Pozitiv egesz szamot adj meg!\n");
            sc.next();
            sc.nextLine();
        }
        db = sc.nextInt();
        sc.nextLine();
        while (db <= 0)
        {
            System.out.print("Pozitiv egesz szamot adj meg!\n");
            db = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0 ; i < db; i++)
        {
            System.out.print("add meg a bejegyzes szerzojét\n");
            String ujSzerzo =  sc.nextLine();
            System.out.print("add meg a bejegyzes tartalmat\n");
            String ujTartalom =  sc.nextLine();
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



        for (int i = 0; i < _bejegyzesek.getBejegyzesek().size() * 20; i++)
        {
            int rnd = (int)((Math.random() * (_bejegyzesek.getBejegyzesek().size() - 1)) + 1);
            _bejegyzesek.getBejegyzesek().get(rnd).like();
        }

        System.out.print("Mi legyen a tartalom a 2-es bejegyzesnel\n");
        String ujTartalom = sc.nextLine();
        _bejegyzesek.getBejegyzesek().get(1).setTartalom(ujTartalom);
        System.out.print(_bejegyzesek);

        int max = 0;
        for (int i = 0; i < _bejegyzesek.getBejegyzesek().size(); i++)
        {

            if (_bejegyzesek.getBejegyzesek().get(i).getLikeok() > max)
            {
                max = _bejegyzesek.getBejegyzesek().get(i).getLikeok();

            }
        }
        System.out.print(String.format("Legtobb like: %s", max));

        boolean vane = false;
        for (int i = 0; i < _bejegyzesek.getBejegyzesek().size(); i++)
        {

            if (_bejegyzesek.getBejegyzesek().get(i).getLikeok() > 35)
            {
                vane = true;

            }
        }
        System.out.print("Van 35-nel tobb like: " + vane);

        int kevesek = 0;
        for (int i = 0; i < _bejegyzesek.getBejegyzesek().size(); i++)
        {

            if (_bejegyzesek.getBejegyzesek().get(i).getLikeok() < 15)
            {
                kevesek++;

            }
        }
        System.out.print(String.format("15-nel kevesebb like: %s", kevesek));

        



    }
}
