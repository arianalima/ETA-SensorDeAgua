import eta.TestETA;

import javax.management.InvalidAttributeValueException;

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
        try {
            sensor.setNivelAgua(19);
            assertEquals(19, sensor.getNivelAgua());
        }catch (InvalidAttributeValueException e){
            fail("Failed");
        }
    }

    public void testNivelAtualAguaAbaixo0(){
        try{
            sensor.setNivelAgua(-1);
            fail("Failed");
        }catch (InvalidAttributeValueException e){
            sucess("Success");
        }
    }

    public void testNivelAtualAguaAcima100(){
        try{
            sensor.setNivelAgua(101);
            fail("Failed");
        }catch (InvalidAttributeValueException e){
            sucess("Success");
        }
    }

    public void testSensorAcima0Abaixo20(){
        try{
            sensor.setNivelAgua(19);
            assertEquals("ligado", sensor.getAltoFalante());
            assertEquals("ligado", sensor.getAlarmeVisual());
            assertEquals("false", sensor.getParar());
        }catch (InvalidAttributeValueException e){
            fail("Failed");
        }
    }

    public void testSensorAcima19Abaixo50(){
        try {
            sensor.setNivelAgua(20);
            assertEquals("piscando", sensor.getAlarmeVisual());
            assertEquals("desligado", sensor.getAltoFalante());
            assertEquals("false", sensor.getParar());
        }catch (InvalidAttributeValueException e){
            fail("Failed");
        }
    }

    public void testSensorAcima49Abaixo100(){
        try{
            sensor.setNivelAgua(50);
            assertEquals("desligado", sensor.getAltoFalante());
            assertEquals("desligado", sensor.getAlarmeVisual());
            assertEquals("false", sensor.getParar());
        }catch (InvalidAttributeValueException e){
            fail("Failed");
        }
    }

    public void testSensor100(){
        try{
            sensor.setNivelAgua(100);
            assertEquals("desligado", sensor.getAltoFalante());
            assertEquals("desligado", sensor.getAlarmeVisual());
            assertEquals("true", sensor.getParar());
        }catch (InvalidAttributeValueException e){
            fail("Failed");
        }
    }

    public static void main(String[] args) {
        TestSensor testSensor = new TestSensor();
        testSensor.run();
    }
}
