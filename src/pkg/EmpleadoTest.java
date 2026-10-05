package pkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    private Empleado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new Empleado();
    }

    @Test
    public void testNominaBrutaVendedorSinPrimas() {
        // Vendedor (2000), ventas < 1000 (0), 0 horas extra -> 2000
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.vendedor, 500f, 0f);
        assertEquals(2000f, resultado, 0.01f);
    }

    @Test
    public void testNominaBrutaEncargadoConLimitesVentas() {
        // Encargado (2500), ventas límite 1000 (prima 100), 2 horas extra (60) -> 2660
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.encargado, 1000f, 2f);
        assertEquals(2660f, resultado, 0.01f);
    }

    @Test
    public void testNominaNetaSinRetencion() {
        // Bruta 2099.99 (< 2100) -> retención 0% -> 2099.99
        float resultado = empleado.calculoNominaNeta(2099.99f);
        assertEquals(2099.99f, resultado, 0.01f);
    }

    @Test
    public void testNominaNetaPrimerTramoRetencion() {
        // Bruta 2100 (>= 2100 y < 2500) -> retención 15% -> 2100 * 0.85 = 1785
        float resultado = empleado.calculoNominaNeta(2100f);
        assertEquals(1785f, resultado, 0.01f);
    }

    @Test
    public void testNominaNetaSegundoTramoRetencion() {
        // Bruta 2500 (>= 2500) -> retención 18% -> 2500 * 0.82 = 2050
        float resultado = empleado.calculoNominaNeta(2500f);
        assertEquals(2050f, resultado, 0.01f);
    }
}