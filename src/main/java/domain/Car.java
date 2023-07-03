package domain;


import utils.NumberGenerator;

public class Car {

    public static final int MOVABLE_NUMBER_LOWER_BOUND = 4;

    private final Name Name;
    private Position position;

    private Car(Name name, Position position) {
        this.Name = name;
        this.position = position;
    }

    public Car(String name) {
        this(new Name(name), Position.create());
    }

    public void move(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (number >= MOVABLE_NUMBER_LOWER_BOUND) {
            position = position.increase();
        }
    }

    public boolean hasSamePositionWith(Car other) {
        return position.equals(other.position);
    }

    public String getName() {
        return Name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
