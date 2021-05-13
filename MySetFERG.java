/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implements;

import Interface.MySet;

/**
 *
 * @author fabio
 * @param <E>
 *
 */
public class MySetFERG<E> implements MySet<E>{
    
    private int length = 5;
    E set[];
    private int quantity;
    
    public MySetFERG(){
        set = (E[]) new Object[length];
        quantity = 0;
    }

    
    @Override
    //metodo para añadir un elemento
    public boolean insert(E elem) {
        //si no contiene el elemento, lo añade
        if(this.contains(elem)==false){
            //si el array esta lleno, duplica la longitud
            if (quantity == length){
                E[] newSet = (E[]) new Object[length*2];
                
                for (int i= 0; i<length;i++){
                    newSet[i] = set[i];
                }
                length = length*2;
                set= newSet;
                System.gc();
            }
            //si no esta lleno, lo añade
            set[quantity] = elem;
            quantity++;
            return true;
        }
        return false;
    }

    @Override
    public boolean extract(E elem) {
        //elimina un elemento del conjunto
        if(this.contains(elem)==true){
            int aux=0;
            for(int i= 0; i < quantity; i++){
                if(set[i]==elem){
                    aux= i;
                }
            }
            for(int i = aux; i< quantity-1; i++ ){
                set[i]=set[i+1];
            }
            set[quantity-1]= null;
            quantity--;
            return true;
        }
        return false;
    }
    
    @Override
    public MySetFERG<E> union(MySetFERG <E> set2) {
    MySetFERG <E> auxSet = new MySetFERG<E>();    
    //hace la union de dos conjuntos
    for (int k=0; k<quantity; k++){
        auxSet.insert(set[k]);
    }
        int i=0;
        int j=0;
        while (i < quantity){
            while(j<set2.quantity){
            if(auxSet.contains(set2.set[j])==false && set[i]!=set2.set[j]){
                    auxSet.insert(set2.set[j]);
                }
            j++;
            }
        i++;
        }
        set=auxSet.set;
        return auxSet;
        
    }

    @Override
    public MySetFERG<E> intersec(MySetFERG<E> set2) {
        //hace la interseccion de dos conjuntos
        MySetFERG<E> auxSet1 = new MySetFERG<E>();
        MySetFERG<E> auxSet2 = new MySetFERG<E>();
        for (int k=0; k<quantity; k++){
        auxSet1.insert(set[k]);
        }
        int i=0;
        int j=0;
        while(i<quantity){
            while(j<set2.quantity){
                if(auxSet1.contains(set2.set[j])){
                     auxSet2.insert(set2.set[j]);
                }
                j++;
            }
        i++;
        }
        set=auxSet2.set;
        return auxSet2;
    }   
        
    

   public boolean contains (E elem){
       //metodo para comprobar si contiene un elemento
       int x=0;
       boolean found = false;
       
       while((x < quantity) && !found){
           found = set[x].equals(elem);
           x++;
       }
       return found;
   }

    @Override
    public int isQuantity() {
        return this.quantity;
    }

    
  
}
