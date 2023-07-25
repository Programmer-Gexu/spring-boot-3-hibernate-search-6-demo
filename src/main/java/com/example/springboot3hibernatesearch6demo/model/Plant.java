package com.example.springboot3hibernatesearch6demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @FullTextField
  @NaturalId
  private String name;

  @FullTextField
  @NaturalId
  private String scientificName;

  @FullTextField
  private String family;

  private Instant createAt;

  public Plant(String name, String scientificName, String family) {

    this.name = name;
    this.scientificName = scientificName;
    this.family = family;
    this.createAt = Instant.now();
  }

  @Override
  public final boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
            .getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Plant plant = (Plant) o;
    return getId() != null && Objects.equals(getId(), plant.getId());
  }

  @Override
  public final int hashCode() {

    return getClass().hashCode();
  }
}
