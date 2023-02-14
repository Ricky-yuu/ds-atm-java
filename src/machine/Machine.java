package machine;
// import machine.Data;
import java.util.Scanner;

public class Machine {
  Data data = new Data();
  Scanner in = new Scanner(System.in);

  public void welcome() {
    System.out.println("Selamat datang di ATM Bank Java");
    System.out.print("Masukkan nomor rekening: ");
    String rekening = in.nextLine();
    System.out.print("Masukkan ID Pengguna: ");
    String idPengguna = in.nextLine();
    System.out.print("Masukkan PIN: ");
    String pass = in.nextLine();
    int login = login(rekening, idPengguna, pass);
    if(login != -1){
      menu(login);
    }
  }

  public int login (String rekening, String idPengguna, String pass) {
    for (int i = 0; i < data.id.length; i++) {
      if (idPengguna.equalsIgnoreCase(data.getId(i)) && pass.equals(data.getPin(i)) && rekening.equals(data.getNumber(i))) {
        System.out.println("Login berhasil!");
        System.out.println("Selamat datang " + data.getName(i));
        return i;
      }
    }

    System.out.println("Nomor Rekening atau Password salah!");
    return -1;
  }

  public void menu(int i) {
    System.out.println("1. Lihat Saldo");
    System.out.println("2. Tarik Uang");
    System.out.println("3. Transfer Uang");
    System.out.println("4. Keluar");
    System.out.print("Masukkan pilihan: ");
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
        System.out.println("Terima kasih telah menggunakan ATM kami!");
        break;
      default:
        System.out.println("Pilihan tidak tersedia!");
        break;
    }
  }

  public void lihatSaldo(int i) {
    System.out.println("Saldo anda Rp " + data.getBalance(i));
    menu(i);
  }

  public void tarikUang(int i) {
    System.out.println("1. Rp  50.000     4. Rp  500.000");
    System.out.println("2. Rp 100.000     5. Rp 1.000.000");
    System.out.println("3. Rp 200.000     6. Rp 2.000.000");
    System.out.print("Masukkan pilihan: ");
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
        System.out.println("Pilihan tidak tersedia!");
        break;
    }
    menu(i);
  }

  public void transferUang(int i) {
    System.out.print("Masukkan nomor rekening tujuan: ");
    String rekening = String.valueOf(in.nextInt());
    System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
    int jumlah = in.nextInt();
    for (int j = 0; j < data.id.length; j++) {
      if (rekening.equalsIgnoreCase(data.getNumber(j))) {
        data.setBalance(i, data.getBalance(i) - jumlah);
        data.setBalance(j, data.getBalance(j) + jumlah);
        System.out.println("Transfer berhasil!");
        System.out.println("Saldo anda Rp " + data.getBalance(i));
        break;
      }

      if (j == data.id.length - 2) {
        System.out.println("Nomor rekening tidak ditemukan!");
      }
    }
    menu(i);
  }

  public void withdraw (int i) {
    
    try (Scanner in = new Scanner(System.in)) {
      System.out.println("1. Rp  50.000     4. Rp  500.000");
      System.out.println("2. Rp 100.000     5. Rp 1.000.000");
      System.out.println("3. Rp 200.000     6. Rp 2.000.000");
      System.out.print("Masukkan pilihan: ");
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
          System.out.println("Pilihan tidak tersedia!");
          break;
      }
    }
    menu(i);
  }
}
