import java.util.HashMap;
import java.util.Map;

// Prototype
abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() { return type; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

// Concrete Prototypes
class Rectangle extends Shape {
    public Rectangle() { type = "Rectangle"; }
    @Override
    public void draw() { System.out.println("Drawing a Rectangle."); }
}

class Circle extends Shape {
    public Circle() { type = "Circle"; }
    @Override
    public void draw() { System.out.println("Drawing a Circle."); }
}

// Prototype Registry
class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("1");
        shapeMap.put(rectangle.getId(), rectangle);

        Circle circle = new Circle();
        circle.setId("2");
        shapeMap.put(circle.getId(), circle);
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape1 = ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape1.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape2.getType());
    }
}
