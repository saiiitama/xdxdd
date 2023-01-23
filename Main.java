import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        Train Skorost = new Train();
        Skorost.setMaxVagon(10);
        Skorost.setName("Skorost");
        Skorost.setPassengers(new ArrayList<>());

        ArrayList<Vagon> temp = new ArrayList<>();
        for(int i = 0;i<10;i++){
            if(i>=8){
                temp.add(new Vip());
            }
            else if(i<5){
                temp.add(new Platskart());
            }
            else{
                temp.add(new Kupe());
            }
        }
        Skorost.setVagons(temp);
        {
            ArrayList<Passenger> passengers = new ArrayList<>();
            passengers.add(new Elderly("Name","Surname",77,"123456789123","N",1,Skorost,3));
            passengers.add(new Student("Bekzat","Kanay",17,"888999456123","N",1,Skorost,1));
            passengers.add(new Student("Yali","Ualikhanov",20,"998456321123","Y",1,Skorost,7));
            passengers.add((new Child("Emporio","Eniston",12,"777412365478","N",3,Skorost,10)));

            Skorost.setPassengers(passengers);
        }

        Train Raketa = new Train();
        Raketa.setPassengers(new  ArrayList<>());
        Raketa.setName("Raketa");
        ArrayList<Vagon> temp1 = new ArrayList<>();
        temp1.add(new Vip());
        temp1.add(new Kupe());
        temp1.add(new Platskart());

        Raketa.setVagons(temp1);
        Raketa.setMaxVagon(3);

        ArrayList<Train> Trains = new ArrayList<>();
        Trains.add(Skorost);
        Trains.add(Raketa);

        System.out.println("\n1.Enter as a administrator\n2.Quit");
        int n = in.nextInt();
        if(n==2){
            return;
        }
        while (true){
            System.out.println("""
                    1. Add passenger
                    2. Remove passenger
                    3. Get information about all passengers
                    4. Change the passenger information
                    5. Get information about exact passenger
                    0. Quit menu""");
            n = in.nextInt();
            switch (n) {
                case 1 -> addPassenger(Trains);
                case 2 -> {
                    ArrayList<Passenger> passengers = findTrain(Trains).getPassengers();
                    if(passengers.isEmpty()){
                        System.out.println("There are no passenger int this train.");
                        break;
                    }
                    removePassenger(passengers);
                }
                case 3 -> {
                    ArrayList<Passenger> passengers = findTrain(Trains).getPassengers();
                    if(passengers.isEmpty()){
                        System.out.println("There is nobody in this Train.");
                        break;
                    }
                    infoAboutAllPassengers(passengers);
                }
                case 4 -> {
                    ArrayList<Passenger> passengers = findTrain(Trains).getPassengers();
                    if(passengers.isEmpty()){
                        System.out.println("There are no passenger int this train.");
                        break;
                    }
                    changeInfo(passengers);
                }
                case 5 ->{
                    System.out.print("Enter the Id of passenger : ");
                     int idPassenger = in.nextInt();
                    boolean found = false;
                    ArrayList<Passenger> passengers = findTrain(Trains).getPassengers();
                    for(Passenger passenger : passengers){
                        if(passenger.getId() == idPassenger) {
                            found = true;
                            passenger.infoAboutPassenger();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Passenger was not found!");
                    }
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    private static void changeInfo(ArrayList<Passenger> passengers) {
        Scanner in = new Scanner(System.in);
        System.out.print("Write the ID of this passenger :");

        int id = in.nextInt();
        for(Passenger el : passengers){
            if(el.getId() == id){
                el.infoAboutPassenger();
                System.out.println("""
                        What u wanna change:
                        1. Name
                        2. Surname\s
                        3. Age
                        4. Has a disability
                        0. Quit""");
                int n = in.nextInt();
                System.out.print("Write the correct ");
                switch (n) {
                    case 1 -> {
                        System.out.print("name : ");
                        String name = in.next();
                        el.setName(name);
                        System.out.println("Name was successfully changed!\n");
                        return;
                    }
                    case 2 -> {
                        System.out.print("surname : ");
                        String surname = in.next();
                        el.setSurname(surname);
                        System.out.println("Surname was successfully changed!\n");
                        return;
                    }
                    case 3 -> {
                        System.out.print("age : ");
                        int age = in.nextInt();
                        el.setAge(age);
                        System.out.println("Age was successfully changed!\n");
                        return;
                    }
                    case 4 -> {
                        System.out.print("form (Y/N):");
                        String dis = in.next();
                        while (!dis.equalsIgnoreCase("Y") && dis.equalsIgnoreCase("N")) {
                            System.out.print("Write Y if yes , else no : ");
                            dis = in.next();
                        }
                        el.setDisabled((dis.equalsIgnoreCase("Y")));
                        System.out.println("Form (has disabled?) was successfully changed!\n");
                        return;
                    }
                    case 0 -> {
                        return;
                    }
                }
            }
        }
        System.out.println("Passenger was not found. Make sure that u write the right ");
    }

    private static void infoAboutAllPassengers(ArrayList<Passenger> passengers) {
        int count = 0;
        for(Passenger el : passengers){
            el.infoAboutPassenger();
            count++;
        }
        System.out.println("There are all " + count + " passengers in this train.\n");
    }

    private static void removePassenger(ArrayList<Passenger> passengers) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the ID of passenger that must be removed: ");
        int ID = in.nextInt();
        for(Passenger el : passengers){
            if(el.getId() == ID){
                el.infoAboutPassenger();
                System.out.print("Do u sure that you wanna remove this Passenger?(Y/N) :");
                String answer = in.next();
                if(answer.equals("Y")){
                    passengers.remove(el);
                    System.out.println("Passenger was successfully removed!\n");
                }
                else{
                    System.out.println("Passenger was not deleted.\n");
                }
                return;
            }
        }
        System.out.println("The passenger was not found. See if you have made a mistake in the ticket number .");
    }


    private static void addPassenger(ArrayList<Train> Trains){
        Scanner in = new Scanner(System.in);
        System.out.println("Select the train : ");
        for(Train train : Trains){
            infoTrain(train);
        }
        System.out.print("For choose train write the name of train : ");
        String trainName = in.next();
        while (!trainName.equalsIgnoreCase("Raketa") && !trainName.equalsIgnoreCase("Skorost")){
            System.out.print("Enter the right name of train : ");
            trainName = in.next();
        }
        Train train = (trainName.equalsIgnoreCase("raketa")?Trains.get(1):Trains.get(0));
        System.out.println("Select the Id of train.");

        infoTrain(train);
        int idVagon = in.nextInt();

        while (idVagon<1 || idVagon>train.getMaxVagon()){
            System.out.print("Vagon with this id is not exist. Select the vagon with real ID : ");
            idVagon = in.nextInt();
        }
        Vagon vagon = train.getVagon(idVagon-1);
        vagon.showEmptySeats();
        System.out.print("Enter the number of seat place : ");
        int seat = in.nextInt();
        while (seat<1 || seat>vagon.getMaxSeats()){
            System.out.print("This place is dont exist. Please select the empty one : ");
            seat = in.nextInt();
        }
        while (vagon.seats()[seat-1]){
            System.out.print("This place is sold. Please select the empty one : ");
            seat = in.nextInt();
        }

        System.out.println("Place is selected.");
        System.out.print("Now, enter the name of passenger : ");
        String name = in.next();

        System.out.print("Surname of the passenger : ");
        String surname = in.next();

        System.out.print("Age of the passenger : ");
        int age = in.nextInt();

        System.out.print("IIN of the passenger : ");
        String IIN = in.next();
        boolean unique;
        boolean right = true;
        ArrayList<Passenger> passengers = train.getPassengers();
        boolean check = passengers.isEmpty();
        System.out.println(check);
        while (true){
            unique = true;
            right = true;
            if(!check) {
                for (Passenger passenger : passengers) {
                    if (passenger.getIIN().equalsIgnoreCase(IIN)) {
                        System.out.println("Passenger with this IIN is already exists. Please enter the right IIN , or enter 0 to quit menu : ");
                        IIN = in.next();
                        if (IIN.equalsIgnoreCase("0")) {
                            return;
                        }
                    }
                }
            }
            if(!IIN.matches("^[0-9]+$") || IIN.length()!=12){
                right = false;
                System.out.println("This is incorrect IIN. Please enter the correct one : ");
            }
            if(unique && right){
                break;
            }
            IIN = in.next();
        }

        System.out.print("Is passenger is disabled?(Y/N) :");
        String disabled = in.next();
        while (!disabled.equalsIgnoreCase("Y") && !disabled.equalsIgnoreCase("N")){
            System.out.print("Enter 'Y' if yes , 'N' if no :");
            disabled = in.next();
        }
        Passenger passenger ;
        if(age <= 12){
            passenger = new Child(name,surname,age,IIN,disabled,idVagon,train);
        }
        else if(age<=25){
            passenger = new Student(name,surname,age,IIN,disabled,idVagon,train);
        }
        else if(age>=65){
            passenger = new Elderly(name,surname,age,IIN,disabled,idVagon,train);
        }
        else{
            passenger = new Person(name,surname,age,IIN,disabled,idVagon,train);
        }
        double price = vagon.getPrice()-((vagon.getPrice()*passenger.getPersonalDiscount())/100);
        System.out.println("All the necessary data has been received. With yor personal discount in will cost :" + price);
        System.out.print("Pay to buy the place : ");
        double money = in.nextDouble();
        while (money<price){
            System.out.print("Pay the full cost : ");
            money = in.nextDouble();
        }
        passengers.add(passenger);
        vagon.seats()[seat-1] = true;
        train.setPassengers(passengers);
        System.out.println("The ticket was successfully purchased. Thank you for your purchase and have a good trip!\n");
    }

    private static void infoTrain(Train train){
        System.out.println("In the train " + train.getName() + " has:");
        for(Vagon vagon : train.getVagons()){
            System.out.println("\tID : " + vagon.getId()+" || In " + vagon.getType()+" has " + vagon.emptySeats() + " empty seats.");
        }
        System.out.println();
    }
    private static Train findTrain(ArrayList<Train> Trains){
        Scanner in = new Scanner(System.in);
        System.out.println("Which train is the passenger on?\n1.Skorost\n2.Raketa");
        int k = in.nextInt();
        while (k!=1 && k!=2){
            System.out.print("Enter 1 to select Skorost , 2 to select Raketa : ");
            k = in.nextInt();
        }
        return Trains.get(k-1);
    }
}