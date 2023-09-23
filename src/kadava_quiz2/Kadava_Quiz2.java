/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kadava_quiz2;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    int Number;
    
    Node next;

    Node(int Number) {
        this.Number = Number;
        
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    CircularLinkedList() {
        head = null;
    }
 public void add(int data){
     Node list = new Node(data);
     
     list.Number=data;
     list.next=null;
     
     if(head==null){
         head=list;
         
     }else{
         Node n = head;
         while(n.next !=null){
             n=n.next;
         }
         n.next=list;
     }
 }    
    
  void addAccount(int position,int Number) {
        Node newNode = new Node(Number);
        if (position <0) {
            System.out.println("empty");
        }
        if (position ==0) {
            
            newNode.next = head;
            head=newNode;
            return;}
       
            Node current = head;
            int currentindex=0;
            while (current.next != null && currentindex < position -1) {
                current = current.next;
                currentindex++;
            }
            if(newNode !=null){
            current.next = newNode;
            newNode.next = head;
            }
            else{
                System.out.println("invalid");
            }
        
    }
        void searchAccount(int accountNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        boolean found = false;
        
        do {
            if (current.Number == accountNumber) {
                found = true;
                System.out.println(" Number: " + current.Number);
                
                break;
            }
            current = current.next;
        } while (current != head);
        
        if (!found) {
            System.out.println(" not found.");
        }
    }
       public  void displayAccounts() {
    
        Node current = head;

        while(current.next!=null){
            System.out.println(current.Number);
            
            current = current.next;
        } System.out.println(current.Number);
    }
}
public class Kadava_Quiz2 {
    public static void main(String[] args) {
        
        CircularLinkedList Accounts = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        
       
        while (true) {
            System.out.println("==================================");
            System.out.println(" Menu:");
            System.out.println("1. Add");
            System.out.println("2. Search ");
            System.out.println("3. data ");
            System.out.println("4. Display ");
            System.out.println("5. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.println("positon:");
                    int posNumber = scanner.nextInt();
                 Accounts.addAccount(posNumber, accountNumber);
                                       break;
                
                case 2:
                    System.out.print("Enter  Number to search: ");
                    int searchAccountNumber = scanner.nextInt();
                    Accounts.searchAccount(searchAccountNumber);
                    break;
                case 3:
                    System.out.println("enter data:");
                    int input=scanner.nextInt();
                    Accounts.add(input);
                    break;
                case 4:
                    Accounts.displayAccounts();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}