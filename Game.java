/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

/**
 *
 * @author fabio
 */
public class Game {
    
    //Atributos 
    private MySetFERG <Integer> drum;
    private MySetFERG <Integer> table;
    
    //constructor

    public Game(MySetFERG<Integer> drum, MySetFERG<Integer> table) {
        this.drum = drum;
        this.table = table;
    }
    
    //getters y setters

    public MySetFERG<Integer> getBombo() {
        return drum;
    }

    public void setBombo(MySetFERG<Integer> drum) {
        this.drum = drum;
    }

    public MySetFERG<Integer> getMesa() {
        return table;
    }

    public void setMesa(MySetFERG<Integer> table) {
        this.table = table;
    }
    
    
    public Integer extracNum(){
        int num=0;
        do{
        num = (int) Math.floor(Math.random()*90+1);
        }while(table.contains(num)!=false);
        drum.extract(num);
        table.insert(num);
        return num;
    }
    
    public MySetFERG<Integer> generateBoard(){
        MySetFERG<Integer> board = new MySetFERG<Integer>();
        int num=0;
        for(int i=1;i<16;i++){
        do{
        num = (int) Math.floor(Math.random()*90+1);
        }while(board.contains(num)!=false);
        board.insert(num);
        }
        return board;        
    }
    
    public boolean isWinner(MySetFERG<Integer> board){
        MySetFERG<Integer> auxSet = new MySetFERG<Integer>();
        auxSet=board.intersec(table);
        boolean x = true;
        if(auxSet.isQuantity()<15){
            x=false;
        }
        return x;
    }
    
    public void newGame(){
        
        drum=drum.union(table);
        table=null;
    }
    
}
