public class Demo {

    public static void main(String[] args) {
        String myString = "We are from DEP-%d.";
        String formattedString = String.format(myString, 9);
        System.out.println(formattedString);

        myString = "Today is: %s but yesterday was: %s. Today temperature is around %fC";
        formattedString = String.format(myString, "2022-08-25", "2022-08-24", 31.7);
        System.out.println(formattedString);

        Customer customer = new Customer("C001", "Kasun", "Galle");
        customer.printDetail();

        Customer customer2 = new Customer("C002", "Tharindu", "Colombo");
        customer2.printDetail();

        myString = "I need to repeat something %1$s & %1$s and %1$s";
        String format = String.format(myString, "DEP-9");
        System.out.println(format);

        System.out.printf("This is a number with minimum four digits: %1$0+,10.2f\n", 50000.25555);
        System.out.printf("This is a number %d \n", -10);
        System.out.printf("This is a number %d \n", 10);
        System.out.printf("This is a number % d \n", -10);
        System.out.printf("This is a number % d \n", 10);
    }
}

class Customer{
    private String id;
    private String name;
    private String address;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void printDetail(){
//        System.out.println("[Customer ID: " + id + "; Customer Name: " + name + "; Customer Address: " + address + "]");
        System.out.printf("[Customer ID: %2$s; Customer Name: %3$s; Customer Address: %1$s]", address, id, name );
        System.out.println();
        //System.out.println(String.format("[Customer ID: %s; Customer Name: %s; Customer Address: %s]", id, name, address));
    }
}
