package giitin.uo270465.si.dto;

public class EnvioTarifaDTO {

    private int envioId;
    private int tarifaId;

    public EnvioTarifaDTO() {}

    public EnvioTarifaDTO(int envioId, int tarifaId) {
        this.envioId = envioId;
        this.tarifaId = tarifaId;
    }

    public int getEnvioId() {
        return envioId;
    }

    public void setEnvioId(int envioId) {
        this.envioId = envioId;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }
}
