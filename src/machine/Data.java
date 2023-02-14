package machine;

public class Data {
  public String[] name = new String[3];
  public String[] id = new String[3];
  public String[] number = new String[3];
  public long[] balance = new long[3];
  private String[] pin = new String[3];

  public Data() {
    this.name[0] = "Achmad Khalifah";
    this.id[0] = "alipsip";
    this.pin[0] = "123456";
    this.number[0] = "0123456789";
    this.balance[0] = 400000000;

    this.name[1] = "Rizdky Octa";
    this.id[1] = "bangky";
    this.pin[1] = "112233";
    this.number[1] = "1234567890";
    this.balance[1] = 3000000;

    this.name[2] = "Ricky Aditya";
    this.id[2] = "rick";
    this.pin[2] = "654321";
    this.number[2] = "0987654321";
    this.balance[2] = 25690000;
  }

  public String getName(int i) {
    return this.name[i];
  }

  public String getId(int i) {
    return this.id[i];
  }

  public String getNumber(int i) {
    return this.number[i];
  }

  public long getBalance(int i) {
    return this.balance[i];
  }

  public String getPin(int i) {
    return this.pin[i];
  }

  public void setBalance(int i, long balance) {
    this.balance[i] = balance;
  }

  public void setPin(int i, String pin) {
    this.pin[i] = pin;
  }

  public void setName(int i, String name) {
    this.name[i] = name;
  }

  public void setId(int i, String id) {
    this.id[i] = id;
  }

  public void setNumber(int i, String number) {
    this.number[i] = number;
  }
}
