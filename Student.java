public class Student extends Passenger{
    private final int personalDiscount = (isDisabled()?30:10);
    private boolean disabled;
    public Student(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train) {
        super(name, surname, age,IIN,disabled,idOfVagon,train);
    }
    public Student(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train,int seat){
        super(name, surname, age,IIN,disabled,idOfVagon,train);
    }

    @Override
    public int getPersonalDiscount(){
        return personalDiscount;
    }
}
