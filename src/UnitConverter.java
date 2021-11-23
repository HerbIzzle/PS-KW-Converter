import Exceptions.InvalidNumberException;

public class UnitConverter {

    private double PSmultiplier = 1.3596216173;
    private double KWmultiplier = 0.73549875;


    public UnitConverter(){

    }

    public double calcParams(double param, double multiplier){

        return param * multiplier;

    }

    public double assignUnitToCalc(Object selectedItem, double userInputParam) throws InvalidNumberException {


            if ("KW".equals(selectedItem) && userInputParam > 0 && userInputParam < 5000) {

                double result = calcParams(userInputParam, KWmultiplier);
                return result;

            } else if ("PS".equals(selectedItem) && userInputParam > 0 && userInputParam < 5000) {

                double result = calcParams(userInputParam, PSmultiplier);
                return result;


            }

            if (userInputParam <= 0) {

                throw new InvalidNumberException("Der Wert ist zu klein oder 0");

            }

            if (userInputParam >= 5000) {
                throw new InvalidNumberException("Der Wert ist zu groß");
            }

            return userInputParam;

        }
    }



