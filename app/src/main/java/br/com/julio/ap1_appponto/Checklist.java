package br.com.julio.ap1_appponto;

public class Checklist {
    private String matricula;
    private String latitude;
    private String longitude;
    private String timeStamp;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTimeStamp() {
        return timeStamp;
    }


}