package org.ryank;

public class Main {
    public static void main(String[] args) {

        Address a1 = new Address(123, "Main St", "Montreal", Province.QC, "H3Z2Y7");
        Address a2 = new Address(50, "Queen St", "Toronto", Province.ON, "INVALID");

        System.out.println(a1);
        System.out.println(a2);   // Should show null fields

    }
}
