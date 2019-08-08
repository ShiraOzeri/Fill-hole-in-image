package WeighteFactory;

public class WeightFunFactory {

    public static WeightFun getWeight(int strategy, double z,double e){
        switch (strategy){
            default:
                return new WeightFunDefault(z,e);
        }
    }
}
