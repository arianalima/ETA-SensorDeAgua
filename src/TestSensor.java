import eta.TestETA;

public class TestSensor extends TestETA {
    Sensor sensor;

    @Override
    public void setup() {
        sensor = new Sensor();
    }

    @Override
    public void finalize() {

    }

    public void testNivelAtualAgua(){
        sensor.setNivelAgua(19);
        assertEquals(sensor.getNivelAgua(), 19);
    }

    public void testSensorAcima0Abaixo20(){
        sensor.setNivelAgua(19);
        assertEquals(sensor.getAltoFalante(), "ligado");
        assertEquals(sensor.getAlarmeVisual(), "ligado");
        assertEquals(sensor.getParar(), false);
    }

    public void testSensorAcima19Abaixo50(){
        sensor.setNivelAgua(20);
        assertEquals(sensor.getAlarmeVisual(), "piscando");
        assertEquals(sensor.getAltoFalante(), "desligado");
        assertEquals(sensor.getParar(), false);
    }

    public void testSensorAcima49Abaixo100(){
        sensor.setNivelAgua(50);
        assertEquals(sensor.getAltoFalante(), "desligado");
        assertEquals(sensor.getAlarmeVisual(), "desligado");
        assertEquals(sensor.getParar(), false);
    }

    public void testSensor100(){
        sensor.setNivelAgua(100);
        assertEquals(sensor.getAltoFalante(), "desligado");
        assertEquals(sensor.getAlarmeVisual(), "desligado");
        assertEquals(sensor.getParar(), true);
    }
}
