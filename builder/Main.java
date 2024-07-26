// Product
class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) { this.dough = dough; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setTopping(String topping) { this.topping = topping; }

    @Override
    public String toString() {
        return "Pizza [dough=" + dough + ", sauce=" + sauce + ", topping=" + topping + "]";
    }
}

// Builder Interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}

// Concrete Builders
class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() { pizza.setDough("cross"); }
    @Override
    public void buildSauce() { pizza.setSauce("mild"); }
    @Override
    public void buildTopping() { pizza.setTopping("ham+pineapple"); }
    @Override
    public Pizza getPizza() { return this.pizza; }
}

class SpicyPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public SpicyPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() { pizza.setDough("pan baked"); }
    @Override
    public void buildSauce() { pizza.setSauce("hot"); }
    @Override
    public void buildTopping() { pizza.setTopping("pepperoni+salami"); }
    @Override
    public Pizza getPizza() { return this.pizza; }
}

// Director
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    public Pizza getPizza() { return pizzaBuilder.getPizza(); }

    public void constructPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.constructPizza();
        Pizza pizza1 = waiter.getPizza();
        System.out.println("Pizza built: " + pizza1);

        waiter.setPizzaBuilder(spicyPizzaBuilder);
        waiter.constructPizza();
        Pizza pizza2 = waiter.getPizza();
        System.out.println("Pizza built: " + pizza2);
    }
}
