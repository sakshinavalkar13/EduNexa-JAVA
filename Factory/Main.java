public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get an object of Circle and call its draw method
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
       // System.out.println();
        int circleHashCode = circle.hashCode();
        System.out.println("Circle Hash Code: " + circleHashCode);
        //System.out.println();
        System.out.println("--------------------------------------------------");

        // Get an object of Square and call its draw method
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
        //System.out.println();
       
        int squareHashCode = square.hashCode();
        System.out.println("Square Hash Code: " + squareHashCode);
        //System.out.println();
         System.out.println("--------------------------------------------------");


        // Get an object of Triangle and call its draw method
        Shape triangle = shapeFactory.getShape("TRIANGLE");
        triangle.draw();
        //System.out.println();
        int triangleHashCode = triangle.hashCode();
        System.out.println("Triangle Hash Code: " + triangleHashCode);
        System.out.println("--------------------------------------------------");
    }
}

