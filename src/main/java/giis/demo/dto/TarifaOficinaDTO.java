package giis.demo.dto;

public class TarifaOficinaDTO {
    private int tarifaId;
    private int oficinaId;

    public TarifaOficinaDTO() {

    }

    public TarifaOficinaDTO(int tarifaId, int oficinaId) {
        this.tarifaId = tarifaId;
        this.oficinaId = oficinaId;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public int getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(int oficinaId) {
        this.oficinaId = oficinaId;
    }
}
