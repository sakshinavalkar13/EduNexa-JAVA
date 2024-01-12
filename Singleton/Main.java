public class Main {
    public static void main(String[] args) {
        // Getting the instance of the Singleton class
        Singleton_design_pattern singletonInstance1 = Singleton_design_pattern.getInstance("Data for instance 1");
        Singleton_design_pattern singletonInstance2 = Singleton_design_pattern.getInstance("Data for instance 2");

        // Both instances should be the same
        System.out.println(singletonInstance1 == singletonInstance2); // Output: true

        // Check hashCode of the instances
        System.out.println("HashCode of instance 1: " + singletonInstance1.hashCode());
        System.out.println("HashCode of instance 2: " + singletonInstance2.hashCode());
    }
}
