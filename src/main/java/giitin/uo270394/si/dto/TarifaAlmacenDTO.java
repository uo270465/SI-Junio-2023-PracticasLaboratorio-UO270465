package giitin.uo270394.si.dto;

public class TarifaAlmacenDTO {
    private int tarifaId;
    private int almacenId;

    public TarifaAlmacenDTO() {

    }

    public TarifaAlmacenDTO(int tarifaId, int almacenId) {
        this.tarifaId = tarifaId;
        this.almacenId = almacenId;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public int getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(int almacenId) {
        this.almacenId = almacenId;
    }
}