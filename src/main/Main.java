package main;

import implementation.Expression;
import implementation.Node;

public class Main {
    public static void main(String[] args) {
        // Expression 1.....
        Expression l1 = new Expression();
        l1.addLast(3,2);
        l1.addLast(2,1);
        l1.addLast(1,0);
        l1.traverse();

        //Expresion 2.....
        Expression l2 = new Expression();
        l2.addLast(2,3);
        l2.addLast(1,2);
        l2.addLast(0,1);
        l2.traverse();

        Main obj = new Main();
        Expression res = obj.Expression(l1,l2);
        res.traverse();
    }


    public Expression Expression(Expression e1, Expression e2){
        Expression res = new Expression();
        Node temp1 = e1.getHead();
        Node temp2 = e2.getHead();

        while(temp1 != null && temp2 != null) {
            if (temp1.getPower() == temp2.getPower()) {
                int coefficient = temp1.getCoefficient() + temp2.getCoefficient();
                res.addLast(coefficient, temp1.getPower());
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else if (temp1.getPower() < temp2.getPower()) {
                res.addLast(temp2.getCoefficient(), temp2.getPower());
                temp2 = temp2.getNext();
            } else if (temp1.getPower() > temp2.getPower()) {
                res.addLast(temp2.getCoefficient(), temp1.getPower());
                temp1 = temp1.getNext();
            }
        }
        if(temp1 != null){
            while(temp1 != null){
                res.addLast(temp1.getCoefficient(), temp1.getPower());
                temp1 = temp1.getNext();
            }
        }
        else{
            while(temp2 != null){
                res.addLast(temp2.getCoefficient(), temp2.getPower());
                temp2 = temp2.getNext();
            }
        }
        return res;
    }
}
