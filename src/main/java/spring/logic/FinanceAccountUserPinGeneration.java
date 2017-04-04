package spring.logic;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */
import java.security.SecureRandom;
import java.math.BigInteger;

public class FinanceAccountUserPinGeneration {

    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
       return new BigInteger(130, random).toString(32);
    }

}
