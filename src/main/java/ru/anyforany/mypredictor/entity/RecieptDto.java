package ru.anyforany.mypredictor.entity;

import javax.persistence.*;

@Entity
@Table(name = "recieps")
public class RecieptDto {

    public RecieptDto() {

    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public int getTirage_amount() {
        return tirage_amount;
    }

    public void setTirage_amount(int tirage_amount) {
        this.tirage_amount = tirage_amount;
    }

    public int getNaut_amount() {
        return naut_amount;
    }

    public void setNaut_amount(int naut_amount) {
        this.naut_amount = naut_amount;
    }

    public int getHh_amount() {
        return hh_amount;
    }

    public void setHh_amount(int hh_amount) {
        this.hh_amount = hh_amount;
    }

    public int getB1_amount() {
        return b1_amount;
    }

    public void setB1_amount(int b1_amount) {
        this.b1_amount = b1_amount;
    }

    public int getB2_amount() {
        return b2_amount;
    }

    public void setB2_amount(int b2_amount) {
        this.b2_amount = b2_amount;
    }

    public int getNrd_amount() {
        return nrd_amount;
    }

    public void setNrd_amount(int nrd_amount) {
        this.nrd_amount = nrd_amount;
    }

    public int getHpe_amount() {
        return hpe_amount;
    }

    public void setHpe_amount(int hpe_amount) {
        this.hpe_amount = hpe_amount;
    }

    public RecieptDto(String dish_name, int tirage_amount, int naut_amount, int hh_amount) {
        this.dish_name = dish_name;
        this.tirage_amount = tirage_amount;
        this.naut_amount = naut_amount;
        this.hh_amount = hh_amount;
    }

    public RecieptDto(long create_time ,String dish_name, int b1_amount, int b2_amount, int nrd_amount, int hpe_amount){
        this.create_time = create_time;
        this.dish_name = dish_name;
        this.b1_amount = b1_amount;
        this.b2_amount = b2_amount;
        this.nrd_amount = nrd_amount;
        this.hpe_amount = hpe_amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RecieptDto(Long id, long create_time, String dish_name, int tirage_amount, int naut_amount, int hh_amount, int b1_amount, int b2_amount, int nrd_amount, int hpe_amount) {
        this.id = id;
        this.create_time = create_time;
        this.dish_name = dish_name;
        this.tirage_amount = tirage_amount;
        this.naut_amount = naut_amount;
        this.hh_amount = hh_amount;
        this.b1_amount = b1_amount;
        this.b2_amount = b2_amount;
        this.nrd_amount = nrd_amount;
        this.hpe_amount = hpe_amount;
    }

    private long create_time;
    private String dish_name;
    private int tirage_amount;
    private int naut_amount;
    private int hh_amount;

    private int b1_amount;
    private int b2_amount;
    private int nrd_amount;
    private int hpe_amount;
}
