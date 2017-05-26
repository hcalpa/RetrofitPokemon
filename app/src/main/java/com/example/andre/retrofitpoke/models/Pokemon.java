package com.example.andre.retrofitpoke.models;

import java.util.ArrayList;

/**
 * Created by andre on 19/05/2017.
 */

public class Pokemon {

    //VARIABLE DEL NUMERO DE LA IMAGEN DE CADA POKEMON, NO LA DA EL WEBSERVICE
    private int number;
    //VARIABLES QUE PROPORCIONA EL WEBSERVICE Y DEBEN SER ESPECIFICADAS TAL Y COMO ESTAN EN EL
    private String name;
    private String url;
    private String weight;
    private String height;
    private String base_experience;
    private ArrayList<Types> types;
    private ArrayList<Ability> abilities;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public int getNumber() {
        //SEPARAR CADA PARTE DEL URL POR EL SIMBOLO SLASH
        String[] urlPartes = url.split("/");
        //ULTIMA POSICIÓN, LA QUE CONTIENE EL NUMERO Y SE CONVIERTE A INT
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ArrayList<Types> getTypes() {
        return types;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypes(ArrayList<Types> types) {
        this.types = types;
    }
}
