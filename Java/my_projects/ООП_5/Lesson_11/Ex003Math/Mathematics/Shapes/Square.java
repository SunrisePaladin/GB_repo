package Ex003Math.Mathematics.Shapes;

import Ex003Math.Mathematics.Exceptions.UnacceptableValueException;

public class Square extends Rectangle {

    private double width;
    private double height;
    /// ???...
    public static Square create(double size, String name) throws UnacceptableValueException{
        // ???...

        if (size < 0)
            throw new UnacceptableValueException("size < 0");
        var instance = new Square();
        instance.name = name;

        instance.width = size;
        instance.height = size;
        return instance;
    }

    private Square() {
        super();
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        // ???...
        return String.format("Name: %s  width: %d  height: %d", name, width, height);
    }
}
