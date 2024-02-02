package strategy;

import java.util.ArrayList;
import java.util.List;

public class ConcreateStrategy {
    List<IStrategy> strategies = new ArrayList<IStrategy>();
    private int strategyInd = 0;


    public ConcreateStrategy(List<IStrategy> strategies){
        this.strategies = strategies;
    }

    public double calcPrice(double price){
        return strategies.get(strategyInd).calcPrice(price);
    }

    public void addStrategy(IStrategy strategy){
        strategies.add(strategy);
    }

    public void removeStrategy(int index){
        strategies.remove(index);
    }

    public void nextStrategy(){
        strategyInd++;

        if(strategyInd >= strategies.size()){
            strategyInd = 0;
        }
    }
}
