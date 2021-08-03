package myproject.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown   =   true )
public class Event {
    int id;
    String theme;
    String type;
    String place;
    String dateStartPlan;
    String dateEndPlan;
    String timeStart;
    String timeEnd;
    String description;
    String status;
    String dateStartActual;
    String dateEndActual;
    String timeStartActual;
    String timeEndActual;
    String priority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDateStartPlan() {
        return dateStartPlan;
    }

    public void setDateStartPlan(String dateStartPlan) {
        this.dateStartPlan = dateStartPlan;
    }

    public String getDateEndPlan() {
        return dateEndPlan;
    }

    public void setDateEndPlan(String dateEndPlan) {
        this.dateEndPlan = dateEndPlan;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateStartActual() {
        return dateStartActual;
    }

    public void setDateStartActual(String dateStartActual) {
        this.dateStartActual = dateStartActual;
    }

    public String getDateEndActual() {
        return dateEndActual;
    }

    public void setDateEndActual(String dateEndActual) {
        this.dateEndActual = dateEndActual;
    }

    public String getTimeStartActual() {
        return timeStartActual;
    }

    public void setTimeStartActual(String timeStartActual) {
        this.timeStartActual = timeStartActual;
    }

    public String getTimeEndActual() {
        return timeEndActual;
    }

    public void setTimeEndActual(String timeEndActual) {
        this.timeEndActual = timeEndActual;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isNull() {
        return false;
    }
}
