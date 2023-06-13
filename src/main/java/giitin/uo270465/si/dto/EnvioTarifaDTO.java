package giitin.uo270465.si.dto;

public class EnvioTarifaDTO {

    private String envioId;
    private int tarifaId;

    public EnvioTarifaDTO() {}

    public EnvioTarifaDTO(String envioId, int tarifaId) {
        this.envioId = envioId;
        this.tarifaId = tarifaId;
    }

    public String getEnvioId() {
        return envioId;
    }

    public void setEnvioId(String envioId) {
        this.envioId = envioId;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }
}
