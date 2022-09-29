package hu.petrik.bejegyzesProjekt;

import java.time.LocalDateTime;

public class Bejegyzes
{
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    Bejegyzes(String szerzo, String tartalom)
    {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo(String szerzo)
    {
        return this.szerzo;
    }

    public String getTartalom()
    {
        return this.tartalom;
    }

    public  void setTartalom(String tartalom)
    {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public int getLikeok()
    {
        return this.likeok;
    }

    public LocalDateTime getLetrejott()
    {
        return this.letrejott;
    }

    public LocalDateTime getSzerkesztve()
    {
        return this.szerkesztve;
    }

    public void like()
    {
        this.likeok ++;
    }

    @Override
    public String toString()
    {
        
    }

}
