package Ex003Math.Core.Presenters;

 
import Ex003Math.Core.Infrastructure.Generator;
import Ex003Math.Core.Models.Model;
import Ex003Math.Core.Views.View;
import Ex003Math.Mathematics.Exceptions.UnacceptableValueException;
import Ex003Math.Mathematics.Shapes.Circle;
import Ex003Math.Mathematics.Shapes.Rectangle;
import Ex003Math.Mathematics.Shapes.Shape;
import Ex003Math.Mathematics.Shapes.Square;

public class Presenter {
    Model model;
    View view;

    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public void append() throws UnacceptableValueException {
        view.set("1 - Circle, 2 - Rectangle, 3 - Square");
        String response = view.get();
        Shape figure;

        switch (response) {
            case "1":
                figure = Circle.create(Generator.number(), "Circle_" + Generator.number());
                break;
            case "3":
                figure = Square.create(Generator.number(), "Square_" + Generator.number());
                break;
            default:
                figure = Rectangle.create(
                    Generator.number(),
                    Generator.number(),
                    "Rectangle_" + Generator.number());
                break;
        }

        model.append(figure);
        view.set("ok");

    }

    public void show() {
        view.set(model.show());
    }

    public void showArea()
        {
            view.set(String.format("all Area %s", model.area()));
        }
}
