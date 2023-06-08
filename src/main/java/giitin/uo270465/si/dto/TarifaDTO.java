package giitin.uo270465.si.dto;

public class TarifaDTO {

    private int tarifaId;
    private String concepto;
    private double precio;

    public TarifaDTO() {}

    public TarifaDTO(int tarifaId, String concepto, double precio) {
        this.tarifaId = tarifaId;
        this.concepto = concepto;
        this.precio = precio;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

