package com.example.proyectofinalmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skilled")
public class Skilled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    private LocalDate created_at;
    private LocalDate updated_at;

    @Column (name = "motive_state")
    private String motive_state; //Null

    @Column (name = "availability")
    private String availability;

    @Column (name = "modality")
    private String modality;  //Null
    private Boolean autonomous;   //Null

    @Column (name = "contact_phone")
    private String contact_phone;

    @Column (name = "contact_email")
    private String contact_email;

    @Column (name = "contact_country")
    private String contact_country;

    private String contact_linkedln;

    private String conditions_percentage;
    private String conditions_price_hour;

    @Column (name = "score")
    private String score;
    private String nif;

    private String email_credentials;
    private String email_password_credentials;
    private String zoom_credentials;
    private String zoom_password_credentials;

    private String photo_file; //Null
    private String cv_file; //Null

    @Column (name = "observations")
    private String observations; //Null
    private String origin; //Null

    @Column (name = "state")
    private String state;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "skilled_tags",
            joinColumns = {@JoinColumn(name = "skilled_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")}
    )

    @JsonIgnoreProperties("skilleds")
    private List<Tags> tags = new ArrayList<>();

    //CONSTRUCTOR
    public Skilled() {
    }


    public Skilled(String name, LocalDate created_at, LocalDate updated_at, String motive_state, String availability,
                   String modality, Boolean autonomous, String contact_phone, String contact_email, String contact_country,
                   String contact_linkedln, String conditions_percentage, String conditions_price_hour, String score,
                   String nif, String email_credentials, String email_password_credentials, String zoom_credentials,
                   String zoom_password_credentials, String photo_file, String cv_file, String observations,
                   String origin, String state) {

        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.motive_state = motive_state;
        this.availability = availability;
        this.modality = modality;
        this.autonomous = autonomous;
        this.contact_phone = contact_phone;
        this.contact_email = contact_email;
        this.contact_country = contact_country;
        this.contact_linkedln = contact_linkedln;
        this.conditions_percentage = conditions_percentage;
        this.conditions_price_hour = conditions_price_hour;
        this.score = score;
        this.nif = nif;
        this.email_credentials = email_credentials;
        this.email_password_credentials = email_password_credentials;
        this.zoom_credentials = zoom_credentials;
        this.zoom_password_credentials = zoom_password_credentials;
        this.photo_file = photo_file;
        this.cv_file = cv_file;
        this.observations = observations;
        this.origin = origin;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getMotive_state() {
        return motive_state;
    }

    public void setMotive_state(String motive_state) {
        this.motive_state = motive_state;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Boolean getAutonomous() {
        return autonomous;
    }

    public void setAutonomous(Boolean autonomous) {
        this.autonomous = autonomous;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_country() {
        return contact_country;
    }

    public void setContact_country(String contact_country) {
        this.contact_country = contact_country;
    }

    public String getContact_linkedln() {
        return contact_linkedln;
    }

    public void setContact_linkedln(String contact_linkedln) {
        this.contact_linkedln = contact_linkedln;
    }

    public String getConditions_percentage() {
        return conditions_percentage;
    }

    public void setConditions_percentage(String conditions_percentage) {
        this.conditions_percentage = conditions_percentage;
    }

    public String getConditions_price_hour() {
        return conditions_price_hour;
    }

    public void setConditions_price_hour(String conditions_price_hour) {
        this.conditions_price_hour = conditions_price_hour;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail_credentials() {
        return email_credentials;
    }

    public void setEmail_credentials(String email_credentials) {
        this.email_credentials = email_credentials;
    }

    public String getEmail_password_credentials() {
        return email_password_credentials;
    }

    public void setEmail_password_credentials(String email_password_credentials) {
        this.email_password_credentials = email_password_credentials;
    }

    public String getZoom_credentials() {
        return zoom_credentials;
    }

    public void setZoom_credentials(String zoom_credentials) {
        this.zoom_credentials = zoom_credentials;
    }

    public String getZoom_password_credentials() {
        return zoom_password_credentials;
    }

    public void setZoom_password_credentials(String zoom_password_credentials) {
        this.zoom_password_credentials = zoom_password_credentials;
    }

    public String getPhoto_file() {
        return photo_file;
    }

    public void setPhoto_file(String photo_file) {
        this.photo_file = photo_file;
    }

    public String getCv_file() {
        return cv_file;
    }

    public void setCv_file(String cv_file) {
        this.cv_file = cv_file;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Skilled{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", motive_state='" + motive_state + '\'' +
                ", availability='" + availability + '\'' +
                ", modality='" + modality + '\'' +
                ", autonomous=" + autonomous +
                ", contact_phone='" + contact_phone + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_country='" + contact_country + '\'' +
                ", contact_linkedln='" + contact_linkedln + '\'' +
                ", conditions_percentage='" + conditions_percentage + '\'' +
                ", conditions_price_hour='" + conditions_price_hour + '\'' +
                ", score='" + score + '\'' +
                ", nif='" + nif + '\'' +
                ", email_credentials='" + email_credentials + '\'' +
                ", email_password_credentials='" + email_password_credentials + '\'' +
                ", zoom_credentials='" + zoom_credentials + '\'' +
                ", zoom_password_credentials='" + zoom_password_credentials + '\'' +
                ", photo_file='" + photo_file + '\'' +
                ", cv_file='" + cv_file + '\'' +
                ", observations='" + observations + '\'' +
                ", origin='" + origin + '\'' +
                ", state='" + state + '\'' +
                ", tags=" + tags +
                '}';
    }
}
