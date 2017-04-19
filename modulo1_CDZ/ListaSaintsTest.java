

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


public class ListaSaintsTest
{
     @Test
    public void buscarPorNomeSemRegistroRetornaNull() {
        ListaSaints lista = new ListaSaints();
        assertEquals(null, lista.buscarPorNome("Cacius"));
    }
    
    
   
    
}
