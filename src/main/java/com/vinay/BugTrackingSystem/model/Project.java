package com.vinay.BugTrackingSystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  private List<Bug> bugs;  // Each project can have multiple bugs

  public Project(List<Bug> bugs, String description, String name) {
    this.bugs = bugs;
    this.description = description;
    this.name = name;
  }

  public Project(String name, String description, List<Bug> bugs) {
    this.name = name;
    this.description = description;
    this.bugs = bugs;
  }

  public Project() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Bug> getBugs() {
    return bugs;
  }

  public void setBugs(List<Bug> bugs) {
    this.bugs = bugs;
  }

  public Long getId() {
    return id;
  }

}

