package giitin.uo270465.si.dto;

public class TarifaRutaDTO {
    private int tarifaId;
    private int rutaId;

    public TarifaRutaDTO() {

    }

    public TarifaRutaDTO(int tarifaId, int rutaId) {
        this.tarifaId = tarifaId;
        this.rutaId = rutaId;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public int getRutaId() {
        return rutaId;
    }

    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }
}