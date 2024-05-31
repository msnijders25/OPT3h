import org.junit.Test;

import java.io.*; import java.lang.reflect.*; import java.lang.annotation.*; import java.util.*; import java.util.stream.*; import java.time.*; // Please do not change or remove this line.

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class Loan
{
    public static int calculateInterest(Boolean isRisky)
    {
        int interest;
        if (isRisky){
            interest = 7;
        }
        else{
            interest = 5;
        }
        return interest;
    }
}

