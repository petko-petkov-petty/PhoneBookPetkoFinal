import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook{
    private Map<Person, PhoneNumber> entries;

    public PhoneBook() {
        entries = new HashMap<>();
    }

    public PhoneBook(File file) throws IOException {
        entries = new HashMap<>();
        createPhoneBook(file, entries);
    }
    
    public void createPhoneBook(File file, Map<Person, PhoneNumber> entries) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        String[] name;
        String[] offset;

        while ((line = bufferedReader.readLine())!= null){
            name = line.split("(\\s*)(00359|\\+359|0)(8[789][2-9]\\d{6})", 0);
            offset = line. split("(00359|\\+359|0)(8[789][2-9]\\d{6})", 0);

            addPair(name[0], line.substring(offset[0].length()));
        }
    }

    private Map.Entry<Person, PhoneNumber> getEntryByName(String name) {
        for (Map.Entry<Person, PhoneNumber> entry : entries.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return entry;
            }
        }

        return null;
    }

    private String printPair(Person person, PhoneNumber phoneNumber) {
        return (person.getName() + " " + phoneNumber.getNumber());
    }

    public PhoneNumber getNumberByName (String name) {
        System.out.println("Access to number " + printPair(getEntryByName(name).getKey(), getEntryByName(name).getValue()));
        return getEntryByName(name).getValue();
    }

    public void deletePairByName (String name) {
        System.out.println("Deleting entry " + printPair(getEntryByName(name).getKey(), getEntryByName(name).getValue()));
        this.entries.remove(getEntryByName(name).getKey());
        System.out.println("Entry deleted!");
    }

    public void addPair(String name, String number) {
        Person person = new Person(name);
        PhoneNumber phoneNumber = new PhoneNumber(number);

        if (person.getName() != null && phoneNumber.getNumber() != null) {
            this.entries.put(person, phoneNumber);
        }
    }

    private Map<Person, PhoneNumber> sortByName () {
        Map<Person, PhoneNumber> sortedByName = new TreeMap<>(entries);

        return sortedByName;
    }

    public void printSorted() {
        for (Map.Entry<Person, PhoneNumber> entry : sortByName().entrySet())
            System.out.println(entry.getKey().getName() + " " + entry.getValue().getNumber());
    }

    public void printFiveMostCalled() {
        int mostCalledCounter = 0;

        for (Map.Entry<Person, PhoneNumber> entry : sortByName().entrySet()){
            if (entry.getValue().getCallsCounter() > mostCalledCounter) {
                mostCalledCounter = entry.getValue().getCallsCounter();
            }
        }

        int printedCounter = 0;

        for (int mostCalled = mostCalledCounter; mostCalled >= 0 && printedCounter < 5; mostCalled--) {
            for (Map.Entry<Person, PhoneNumber> entry : sortByName().entrySet()){
                if (entry.getValue().getCallsCounter() == mostCalled && printedCounter < 5) {
                    ++printedCounter;
                    System.out.println("Number " + printedCounter + " most called is " +
                            printPair(entry.getKey(), entry.getValue()) + " with " + mostCalled + " calls");
                }
            }
        }
    }
}
