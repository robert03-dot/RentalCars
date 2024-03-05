import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IasiRentals {
    private int regular;
    private int premium;
    private int mini;
    private Map<String,Integer> rentalSystem = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private String[] category = {"regular","premium","mini"};
    public String addCustomers(){
        System.out.println("Adaugati un client nou:");
        String newCustomer = scanner.next();
        return newCustomer;
    }
    public int returnFidelityPoints(String newCustomer) throws Exception {
        System.out.println("Puncte de fidelitate:");
        if(!rentalSystem.containsKey(newCustomer)){
         throw new Exception("Clientul nu exista in sistem!");
        }
        return rentalSystem.get(newCustomer);//returnam valoarea asociata cheii(returnam punctele de loialitate pe care le are un client)
    }
    public static void printOptions(){
        System.out.println("Adauga un nou client nou:add");
        System.out.println("Inchide aplicatia:quit");
        System.out.println("Arata punctele de loialitate ale unui client:points");
        System.out.println("Gaseste un client:find");
    }
    public void run(){
        printOptions();
        boolean quit=false;
        while(!quit){
            System.out.println("Alege o comanda:");
            String option = scanner.next();
            switch (option){
                case "quit":
                    quit=true;
                    scanner.close();
                    break;
                case "add":
                    String newCustomer = addCustomers();
                    System.out.println("Ce tip de masina doriti sa inchiriati?");
                    String carOption = scanner.next();
                    if(carOption.equals(category[2])){
                        System.out.println("Pentru cate zile doriti sa inchiriati masina?");
                        int daysNumber = scanner.nextInt();
                        int miniValueAux = 0;
                        if(daysNumber<=3){
                            miniValueAux+=daysNumber*15;
                        }else{
                            int additionalDays = daysNumber-3;
                            miniValueAux+=45+additionalDays*10;
                        }
                        mini+=miniValueAux;
                    }
                default:
                    System.out.println("Comanda nu exista.Incearca din nou!");
                    printOptions();
            }
        }
    }
}