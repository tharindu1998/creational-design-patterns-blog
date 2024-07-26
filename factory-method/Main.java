// Abstract Products
interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

// Concrete Products
class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Modern chair.");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Victorian sofa.");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a Modern sofa.");
    }
}

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

// Concrete Factories
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

public class Main {
    private static void createFurniture(FurnitureFactory factory) {
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        chair.sitOn();
        sofa.lieOn();
    }

    public static void main(String[] args) {
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        createFurniture(victorianFactory);

        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        createFurniture(modernFactory);
    }
}
