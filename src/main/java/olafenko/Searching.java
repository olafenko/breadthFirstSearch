package olafenko;

import java.util.*;

public class Searching {

    private ArrayList<String> checkedPersons = new ArrayList<>();
    private HashMap<String, List<String>> persons = new HashMap<>();

    public void run() {

        preparing();

        search("Me");

    }

    private void search(String name) {

        Queue<String> personsToSearch = new LinkedList<>();
        personsToSearch.add(name);

        while (!personsToSearch.isEmpty()) {

            String person = personsToSearch.poll();

            if (!checkedPersons.contains(person)) {

                if (isSellerOfMango(person)) {
                    System.out.println("The seller of mango is: " + person);
                    return;
                } else {
                    personsToSearch.addAll(persons.get(person));
                    checkedPersons.add(person);
                }
            }

            System.out.println(personsToSearch);
        }

        System.out.println("Unfortunately noone here is seller of mango :( Keep searching. ");

    }
    private boolean isSellerOfMango(String name) {
        return name.endsWith("m");
    }
    private void preparing() {
        persons.put("Me", List.of("Jakub","Konrad","Filip"));
        persons.put("Konrad", List.of("Maciej", "Piotrek"));
        persons.put("Jakub", List.of("Maciej", "Salem"));
        persons.put("Filip", List.of("Ryszard"));
        persons.put("Maciej",List.of());
        persons.put("Piotrek", List.of());
        persons.put("Salem",List.of());
        persons.put("Ryszard",List.of());
    }
}
