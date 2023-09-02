package com.itproject.itproject.dto;

public class BookDTO {
  private Long id;
  private String name;
  private Long authorId; // Campo para el objeto Author completo
  private Long categoryId; // Campo para el objeto Category completo
  private double price;
  private Boolean status;

  // Getters
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public double getPrice() {
    return price;
  }

  public Boolean getStatus() {
    return status;
  }

  // Setters
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAuthor(Long authorId) {
    this.authorId = authorId;
  }

  public void setCategory(Long categoryId) {
    this.categoryId = categoryId;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
