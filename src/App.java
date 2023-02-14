import machine.Machine;

public class App {
    public static void main(String[] args) throws Exception {
        while(true){
            Machine machine = new Machine();
            machine.welcome();
        }
    }
}
