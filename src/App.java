import machine.Machine;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        while(true){
            try{
                Machine machine = new Machine();
                Scanner in = new Scanner(System.in);
                System.out.println("Welcome to ATM Machine!");
                System.out.print("Insert your card number: ");
                String rekening = in.nextLine();
                System.out.print("Insert your ID: ");
                String idPengguna = in.nextLine();
                System.out.print("Insert your password: ");
                String pass = in.nextLine();
                int login = machine.login(rekening, idPengguna, pass);
                if(login != -1){
                    machine.menu(login);
                }
            } catch(Exception e){
                System.out.println("Something went wrong!");
            }
        }
    }
}
