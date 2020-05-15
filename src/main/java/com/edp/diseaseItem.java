package main.java.com.edp;


public class diseaseItem {
    private final String DiseaseName;
    private final String DiseaseURL;

    public diseaseItem(String DiseaseName, String DiseaseURL) {
        this.DiseaseName = DiseaseName;
        this.DiseaseURL = DiseaseURL;
    }
    public String getDiseaseName() { return DiseaseName; }
    public String getDiseaseURL() { return DiseaseURL; }
    @Override
    public String toString() {
        return DiseaseName;
    }
}
