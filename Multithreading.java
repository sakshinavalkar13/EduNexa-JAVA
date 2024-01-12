import java.util.Scanner;
import java.util.function.Consumer;

class SharedResource{
    private int Value;
    private boolean hasValue=false;

    public synchronized void produce(int val){
        while(hasValue){
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        Value=val;
        System.out.println("Produced: "+ val);
        hasValue=true;
        notify();
    }

    public synchronized int Consume(){
        while(!hasValue){
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: "+Value);
        hasValue=false;
        notify();
        return Value;
    }
}

    class Producer implements Runnable{
        private SharedResource resource;
        private int ProduceLimit;

        public Producer(SharedResource resource,int ProduceLimit){
            
            this.resource=resource;
            this.ProduceLimit=ProduceLimit;
        }  
        @Override
        public void run(){
            for(int i=0;i<ProduceLimit;i++){
                resource.produce(i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        } 
    }  
    
    
    class MyConsumer implements Runnable{
        private SharedResource resource;
        private int ConsumeLimit;

        public MyConsumer(SharedResource resource,int ConsumeLimit){
            this.resource=resource;
            this.ConsumeLimit=ConsumeLimit;
        }
        @Override
        public void run(){
            for(int i=0;i<ConsumeLimit;i++){
                resource.Consume();
                try{
                    Thread.sleep(1500);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
public class Multithreading {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("ENTER THE NUMBER OF ITEMS TO PRODUCE: ");
    int ProduceLimit=sc.nextInt();

    System.out.println("ENTER THE NUMBER OF ITEMS TO CONSUME: ");
    int ConsumeLimit=sc.nextInt();
    
    SharedResource resource=new SharedResource();

    Thread producerThread=new Thread(new Producer(resource,ProduceLimit));
    Thread consumerThread=new Thread(new MyConsumer(resource,ConsumeLimit)); 

    producerThread.start();
    consumerThread.start();
        
    sc.close();
    };
}

    


