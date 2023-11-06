/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tuan Anh
 */
public class Outcome {
    private String ship;
    private String battle;
    private String result;

    public Outcome() {
    }

    public Outcome(String ship, String battle, String result) {
        this.ship = ship;
        this.battle = battle;
        this.result = result;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getBattle() {
        return battle;
    }

    public void setBattle(String battle) {
        this.battle = battle;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
