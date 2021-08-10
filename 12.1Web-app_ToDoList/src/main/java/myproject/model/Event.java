package myproject.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@JsonIgnoreProperties(ignoreUnknown   =   true )
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String theme;
   private String type;
   private String place;
   private String dateStartPlan;
   private String dateEndPlan;
   private String timeStart;
   private String timeEnd;
   private String description;
   private String status;
   private String dateStartActual;
   private String dateEndActual;
   private String timeStartActual;
   private String timeEndActual;
   private String priority;

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
