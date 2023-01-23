abstract class Passenger {
    private int id;
    private int counter;
    private String name;
    private String surname;
    private String IIN;
    private int age;
    private boolean disabled;
    private int idOfVagon;
    private Train train;
    private int seat;
    public Passenger(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train){
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.IIN = IIN;
        this.disabled = (disabled.equalsIgnoreCase("Y"));
        this.id = counter;
        this.train = train;
        this.idOfVagon = idOfVagon;
        counter++;
    }

    public Passenger(String name , String surname,int age,String IIN,String disabled ,int idOfVagon,Train train,int seat){
        this(name,surname,age,IIN,disabled,idOfVagon,train);
        train.getVagon(idOfVagon-1).seats()[seat-1] = true;
    }
    public void infoAboutPassenger(){
        System.out.println("ID : " + id + " || Name : " + name + " || Surname : " + surname + " || Age : " + age + " || IIN : " + IIN + " || Personal Discount : " + getPersonalDiscount() + "%" + " || He/She has a disability : " + isDisabled());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public abstract int getPersonalDiscount();

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }
}
