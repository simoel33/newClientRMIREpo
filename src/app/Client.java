package app;

import java.rmi.Naming;

import beans.Livre;
import beans.User;


public class Client {
	public static void main(String[] args) {
		 try {
	            IBiblio stub= (IBiblio) Naming.lookup("rmi://localhost:1099/BK");
	            User u= (User)stub.findUserById("PB23465");

	            System.out.println(u.getAdress());
	            Livre l=(Livre)stub.findBookById(1233);
<<<<<<< HEAD
	            //stub.Emprunter(l, u, "2021-12-31");
=======
	            System.out.println("------------------------");
	            System.out.println(l.getAuteur());
	            stub.Emprunter(l, u, "2021-12-31");
>>>>>>> 053424f (linking ui and fonctionalities)
	           
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		 
	}
	
	 

}
