public class TriangleTester {
    public static void main(String[] args) {
        Triangle t = new Triangle(10);
        int area = t.getArea();
        System.out.println("Area: " + area);
        System.out.println("Expected: 55");
    }
}

/*
 * output
 * 
 * Area: 55 Expected: 55
 * 
 */