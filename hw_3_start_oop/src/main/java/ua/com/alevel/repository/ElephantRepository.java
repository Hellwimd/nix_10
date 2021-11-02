package ua.com.alevel.repository;

import ua.com.alevel.entity.Elephant;

import java.util.Arrays;

public class ElephantRepository {
    private Elephant[] elephants;

    public ElephantRepository() {
        elephants = new Elephant[1];
    }

    public void create(Elephant elephant) {
        elephant.setId(generateId());

        if (elephants.length != 0 && elephants[elephants.length - 1] == null) {
            elephants[elephants.length - 1] = elephant;
        } else {
            elephants = Arrays.copyOf(elephants, elephants.length + 1);
            elephants[elephants.length - 1] = elephant;
        }

        System.out.println("Created Elephant = " + elephant);
    }

    private Long generateId() {
        Double randomId = Math.random() * 1000000;
        Long id = randomId.longValue();
        for (Elephant elephant : elephants) {
            if (elephant != null && id.equals(elephant.getId())) {
                return generateId();
            }
        }
        return id;
    }

    public void update(Elephant elephant) {
        Elephant foundedElephant = findById(elephant.getId());
        if (foundedElephant == null) {
            return;
        }
        foundedElephant.setName(elephant.getName());
        foundedElephant.setWeight(elephant.getWeight());
        foundedElephant.setAge(elephant.getAge());
        System.out.println("Updated Elephant = " + foundedElephant);
    }

    public Elephant findById(Long id) {
        for (Elephant elephant : elephants) {
            if (elephant != null && id.equals(elephant.getId())) {
                return elephant;
            }
        }
        System.out.println("Elephant by id " + id + " not found");
        ;
        return null;
    }

    public Elephant[] findAll() {
        return elephants;
    }

    public void delete(Long id) {
        Elephant elephantToDelete = this.findById(id);

        if (elephantToDelete == null) {
            return;
        }

        for (int i = 0; i < elephants.length; i++) {
            if (elephants[i] != null && elephants[i].getId().equals(elephantToDelete.getId())) {
                elephants[i] = null;
            }
        }

        int newArrayLength = 0;
        for (int i = 0; i < elephants.length; i++) {
            if (elephants[i] != null) {
                elephants[newArrayLength] = elephants[i];
                newArrayLength++;
            }
        }

        elephants = Arrays.copyOf(elephants, newArrayLength);
    }
}