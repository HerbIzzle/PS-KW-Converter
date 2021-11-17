public class UnitConverter {

    private double PSmultiplier = 1.3596216173;
    private double KWmultiplier = 0.73549875;


    public UnitConverter(){

    }

    public double calc(double param, double multiplier){

        return param * multiplier;

    }

}
