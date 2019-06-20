import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
        PhoneBook phoneBook = new PhoneBook(file);

/*        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPair("Petko Petkov", "0876922111");
        phoneBook.addPair("Georgi Manchev", "+359877240130");
        phoneBook.addPair("Musala", "00359882860851");*/

        phoneBook.addPair("Monika Micheva", "+359879636105");
        phoneBook.addPair("", "+359886507848");
        phoneBook.addPair("Shano", "wtf");

        phoneBook.printSorted();

        phoneBook.deletePairByName("Musala");

        phoneBook.getNumberByName("Petko Petkov").setCallsCounter(5);
        phoneBook.getNumberByName("Monika Micheva").setCallsCounter(3);

        phoneBook.printFiveMostCalled();
    }
}
