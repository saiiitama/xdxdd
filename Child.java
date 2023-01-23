public class Child extends Passenger{
    private int personalDiscount = (isDisabled()?40:20);

    public Child(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train) {
        super(name, surname, age,IIN,disabled,idOfVagon,train);
    }
    public Child(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train,int seat){
        super(name, surname, age,IIN,disabled,idOfVagon,train);
    }

    @Override
    public int getPersonalDiscount(){
        return personalDiscount;
    }
}
