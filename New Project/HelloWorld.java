import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;
import java.util.Iterator;

public class HelloWorld{

     public static void main(String []args){
        // value put in the tank
        double tank = 55.0;
        
        // car consumption L/100km
        double c = 10.0;
        
        // nb Km possibly done
        double kmDone = 55*100/c;
        
        System.out.println("Tank:"+tank);
        System.out.println("Consumption:"+c);
        System.out.println("Average Distance:"+kmDone);
        
        //order by >priodity and then <distance
        HashMap<String,double[]> places = new HashMap<String,double[]>();
        double[] d = new double[2];
        d[0]=100;
        d[1]=3;
        places.put("Brassov",d);
        d = new double[2];
        d[0]=3;
        d[1]=2;
        places.put("Bucuresti",d);
        d = new double[2];
        d[0]=400;
        d[1]=2;
        places.put("Bacau",d);
        d = new double[2];
        d[0]=1000;
        d[1]=1;
        places.put("Timisaora",d);
        
        ArrayList<String> cities = new ArrayList<String>();
        
        boolean bagFull = false;
        while(kmDone>0 && !bagFull){
            bagFull = true;
            Iterator it = places.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pairs = (Map.Entry)it.next();
                if(kmDone-places.get(pairs.getKey())[0]>=0){
                    cities.add((String)pairs.getKey());
                    kmDone-=places.get(pairs.getKey())[0];
                    bagFull=false;
                }
            }
           
        }
        
        System.out.println("Need to be dispatch:"+kmDone);
        for(int i =0;i<cities.size();++i){
            System.out.println("City "+i+" :"+cities.get(i));
        }
        
     }  
}
