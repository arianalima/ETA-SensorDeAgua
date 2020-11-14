import javax.management.InvalidAttributeValueException;

public class Sensor {

    private int nivelAgua;
    private String altoFalante = "desligado";
    private String alarmeVisual = "desligado";
    private String parar = "false";

    public int getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(int nivelAgua) throws InvalidAttributeValueException{
        if (nivelAgua >= 0 && nivelAgua <= 100){
            this.nivelAgua = nivelAgua;
        }else {
            throw new InvalidAttributeValueException();
        }

        if (this.nivelAgua == 100){
            this.parar = "true";
            this.altoFalante = "desligado";
            this.alarmeVisual = "desligado";
        }else if (this.nivelAgua <20){
            this.setAltoFalante("ligado");
            this.setAlarmeVisual("ligado");
        }else if (this.nivelAgua < 50){
            this.setAlarmeVisual("piscando");
            this.setAltoFalante("desligado");
            this.setParar("false");
        }else{
            this.setAltoFalante("desligado");
            this.setAlarmeVisual("desligado");
            this.setParar("false");
        }
    }

    public String getAltoFalante() {
        return altoFalante;
    }

    public void setAltoFalante(String altoFalante) {
        this.altoFalante = altoFalante;
    }

    public String getAlarmeVisual() {
        return alarmeVisual;
    }

    public void setAlarmeVisual(String alarmeVisual) {
        this.alarmeVisual = alarmeVisual;
    }

    public String getParar() {
        return parar;
    }

    public void setParar(String parar) {
        this.parar = parar;
    }


}
