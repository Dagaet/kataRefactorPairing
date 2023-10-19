package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> personList;

    public Finder(List<Person> personFinder) {
        personList = personFinder;
    }

    public PersonComparator Find(AgeDistant inputAgeDistant) {
        List<PersonComparator> comparatorList = new ArrayList<>();

        for (int i = 0; i < personList.size() - 1; i++) {
            for (int j = i + 1; j < personList.size(); j++) {
                PersonComparator personComparator = new PersonComparator();
                if (personList.get(i).birthDate.getTime() < personList.get(j).birthDate.getTime()) {
                    personComparator.olderPerson = personList.get(i);
                    personComparator.youngerPerson = personList.get(j);
                } else {
                    personComparator.olderPerson = personList.get(j);
                    personComparator.youngerPerson = personList.get(i);
                }
                personComparator.dateDiference = personComparator.youngerPerson.birthDate.getTime() - personComparator.olderPerson.birthDate.getTime();
                comparatorList.add(personComparator);
            }
        }

        if (comparatorList.size() < 1) {
            return new PersonComparator();
        }

        PersonComparator answer = comparatorList.get(0);
        for (PersonComparator result : comparatorList) {
            switch (inputAgeDistant) {
            case CLOSEST:
                if (result.dateDiference < answer.dateDiference) {
                    answer = result;
                }
                break;

            case FURTHEST:
                if (result.dateDiference > answer.dateDiference) {
                    answer = result;
                }
                break;
            }
        }

        return answer;
    }
}
