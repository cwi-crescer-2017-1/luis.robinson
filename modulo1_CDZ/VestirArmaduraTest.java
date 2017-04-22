

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VestirArmaduraTest
{
    @Test
    public void vestirArmaduraNoMetodoExecutarDeixaVestida() throws Exception {
        Saint shaina = new SilverSaint("Shain","Serpente");
        Movimento movimento = new VestirArmadura(shaina);
        movimento.executar();
        assertEquals(true,shaina.getArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmaduraNoMetodoExecutarDeixaNaoVestida() throws Exception {
        Saint shaina = new SilverSaint("Shain","Serpente");
        Movimento movimento = new VestirArmadura(shaina);        
        assertEquals(false,shaina.getArmaduraVestida());
    }
}
