package iqmsoft.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@RequiredArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = 6434715326731042687L;


  @Id
  @GeneratedValue(generator = "UUID2")
  @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
  UUID id;
  @NonNull String name;
}
