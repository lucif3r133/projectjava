package com.company;

public class Main {

    public static void main(String[] args) {
	    Baza baza = new Baza();
        /* baza.createTable(); */
        /*baza.addData("lewandowski99", 5, "Paulinka", "Lewandowska", 21, "Kałamarskiego", 8500);*/
        baza.selectRow("lewandowski99", 3);
        baza.selectData("lewandowski99", "NAME");
        baza.akutalizujDane("lewandowski99", "NAME", 2, "John");
        baza.selectData("lewandowski99", "NAME");




    }
}
