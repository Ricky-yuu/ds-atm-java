package machine;
import java.util.Scanner;

public class Machine {
  Data data = new Data();
  Scanner in = new Scanner(System.in);

  public int login (String rekening, String idPengguna, String pass) {
    for (int i = 0; i < data.id.length; i++) {
      if (idPengguna.equalsIgnoreCase(data.getId(i)) && pass.equals(data.getPin(i)) && rekening.equals(data.getNumber(i))) {
        System.out.println("Login Success!");
        System.out.println("Welcome " + data.getName(i));
        return i;
      }
    }

    System.out.println("Login Failed!");
    return -1;
  }

  public void menu(int i) {
    System.out.println("1. Check Balance");
    System.out.println("2. Withdraw Money");
    System.out.println("3. Transfer Money");
    System.out.println("4. Exit");
    System.out.print("Insert your choice: ");
    byte pil = in.nextByte();
    switch (pil) {
      case 1:
        lihatSaldo(i);
        break;
      case 2:
        tarikUang(i);
        break;
      case 3:
        transferUang(i);
        break;
      case 4:
        System.out.println("Thank you for using our ATM Machine!");
        break;
      default:
        System.out.println("Invalid Input!");
        break;
    }
  }

  public void lihatSaldo(int i) {
    System.out.println("Your balance Rp. " + data.getBalance(i));
    menu(i);
  }

  public void tarikUang(int i) {
    System.out.println("1. Rp.  50.000     4. Rp.  500.000");
    System.out.println("2. Rp. 100.000     5. Rp. 1.000.000");
    System.out.println("3. Rp. 200.000     6. Rp. 2.000.000");
    System.out.print("Insert your choice:");
    byte pil = in.nextByte();
    switch (pil) {
      case 1:
        data.setBalance(i, data.getBalance(i) - 50000);
        break;
      case 2:
        data.setBalance(i, data.getBalance(i) - 100000);
        break;
      case 3:
        data.setBalance(i, data.getBalance(i) - 200000);
        break;
      case 4:
        data.setBalance(i, data.getBalance(i) - 500000);
        break;
      case 5:
        data.setBalance(i, data.getBalance(i) - 1000000);
        break;
      case 6:
        data.setBalance(i, data.getBalance(i) - 2000000);
        break;
      default:
        System.out.println("Invalid Input!");
        break;
    }
    menu(i);
  }

  public void transferUang(int i) {
    System.out.print("Insert the number of the account you want to transfer: ");
    String rekening = String.valueOf(in.nextInt());
    System.out.print("Insert the amount of money you want to transfer:");
    int jumlah = in.nextInt();
    for (int j = 0; j < data.id.length + 1; j++) {
      if (rekening.equals(data.getNumber(j))) {
        data.setBalance(i, data.getBalance(i) - jumlah);
        data.setBalance(j, data.getBalance(j) + jumlah);
        System.out.println("Transfer Success!");
        menu(i);
      }
    }
    System.out.println("Transfer Failed!");
    menu(i);
  }

  public void withdraw (int i) {
    
    try (Scanner in = new Scanner(System.in)) {
      System.out.println("1. Rp.  50.000     4. Rp.  500.000");
      System.out.println("2. Rp. 100.000     5. Rp. 1.000.000");
      System.out.println("3. Rp. 200.000     6. Rp. 2.000.000");
      System.out.print("Insert your choice: ");
      byte pil = in.nextByte();
      switch (pil) {
        case 1:
          data.setBalance(i, 50000 + data.getBalance(i));
          break;
        case 2:
          data.setBalance(i, 100000 + data.getBalance(i));
          break;
        case 3:
          data.setBalance(i, 200000 + data.getBalance(i));
          break;
        case 4:
          data.setBalance(i, 500000 + data.getBalance(i));
          break;
        case 5:
          data.setBalance(i, 1000000 + data.getBalance(i));
          break;
        case 6:
          data.setBalance(i, 2000000 + data.getBalance(i));
          break;
        default:
          System.out.println("Invalid Input!");
          break;
      }
    }
    menu(i);
  }
}
