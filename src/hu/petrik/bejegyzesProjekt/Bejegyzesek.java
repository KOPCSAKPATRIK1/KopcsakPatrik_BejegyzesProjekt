package hu.petrik.bejegyzesProjekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bejegyzesek
{
    private List<Bejegyzes> _bejegyzesek;

    public Bejegyzesek(Bejegyzes[] bejegyzesTomb)
    {
        this._bejegyzesek = new ArrayList<>();
        this._bejegyzesek.addAll(Arrays.asList(bejegyzesTomb));
    }

    public Bejegyzesek(String fajlNev) throws IOException
    {
        this._bejegyzesek = new ArrayList<>();
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            this._bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public List<Bejegyzes> getBejegyzesek()
    {
        return _bejegyzesek;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Bejegyzes e: this._bejegyzesek)
        {
            sb.append(e.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
