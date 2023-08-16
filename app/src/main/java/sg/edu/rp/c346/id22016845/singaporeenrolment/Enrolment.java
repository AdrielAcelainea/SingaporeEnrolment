package sg.edu.rp.c346.id22016845.singaporeenrolment;

public class Enrolment {
    private int year;
    private String studyType;
    private int enrolmentCount;

    public Enrolment(int year, String studyType, int enrolmentCount){
        this.year=year;
        this.studyType=studyType;
        this.enrolmentCount=enrolmentCount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public int getEnrolmentCount() {
        return enrolmentCount;
    }

    public void setEnrolmentCount(int enrolmentCount) {
        this.enrolmentCount = enrolmentCount;
    }

    public String toString(){
        return "Year: "+year+" Type of Study: "+ studyType+ " Enrolment(Count): "+ enrolmentCount;
    }

}
