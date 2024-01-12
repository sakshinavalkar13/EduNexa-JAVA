public class Singleton_design_pattern {
    private static  volatile Singleton_design_pattern instance;
    private String data;

    // Private constructor to prevent instantiation from other classes
    private Singleton_design_pattern(String data) {
        this.data=data;
    }

    // Public method to get the instance of Singleton class
    public static Singleton_design_pattern getInstance(String data) {
        if (instance == null) {
            synchronized(Singleton_design_pattern.class){
                if(instance==null){
                     instance = new Singleton_design_pattern(data);
                }
            }
           
        }
        return instance;
    }

    // // Add other methods and properties here
    // public void doSomething() {
    //     System.out.println("Singleton instance is doing something.");
    // }
   
    
}
